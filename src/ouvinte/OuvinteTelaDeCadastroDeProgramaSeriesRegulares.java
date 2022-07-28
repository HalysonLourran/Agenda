package ouvinte;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;

import entity.Canal;
import entity.ProgramaSeriesRegulares;
import enuns.EstiloSeriesRegulares;
import enuns.StatusDeExebicao;
import model.CentralDeInformacoes;
import model.DiasDaSemana;
import model.Persistencia;
import model.StatusHiato;
import personalizedMessage.MensagemCanal;
import personalizedMessage.MensagemException;
import personalizedMessage.MensagemPrograma;
import personalizedMessage.MensagemUsuario;
import tela.TelaCadastroDeProgramaSeriesRegulares;
import tela.TelaDeMenu;

public class OuvinteTelaDeCadastroDeProgramaSeriesRegulares implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	private TelaCadastroDeProgramaSeriesRegulares telaCadastroDePrograma;

	public TelaCadastroDeProgramaSeriesRegulares getTelaCadastroDePrograma() {
		return telaCadastroDePrograma;
	}

	public OuvinteTelaDeCadastroDeProgramaSeriesRegulares(TelaCadastroDeProgramaSeriesRegulares tela) {
		this.telaCadastroDePrograma = tela;
	}

	public void actionPerformed(ActionEvent e) {
		new TelaDeMenu(null);
		telaCadastroDePrograma.setVisible(false);
	} // end action

	public void actionPerformedSalvar(ActionEvent e) {

		try {

			String nome = telaCadastroDePrograma.getCampoNomeDoPrograma().getText();
			long id = Long.parseLong(telaCadastroDePrograma.getCampoIDCanal().getText());
			String horario = telaCadastroDePrograma.getCampoHorario().getText();
			String genero = telaCadastroDePrograma.getCampoGenero().getText();
			String temporada = telaCadastroDePrograma.getCampoTemporada().getText();
			String[] diasDaSemana = telaCadastroDePrograma.getCampoDiasDaSemana().getText().split(", ");

			if (nome.isBlank() || horario.isBlank() || genero.isBlank() || temporada.isBlank()) {
				MensagemUsuario.usuarioCampoVazio();
			} else {

				Canal canal = centralDeInformacoes.recuperarCanalId(id);

				if (canal != null) {

					StatusHiato status = new StatusHiato();
					StatusDeExebicao statusFinal = status.statusDeExebicao();
					EstiloSeriesRegulares estilo = status.estiloSeriesRegulares();
					DayOfWeek dias[] = DiasDaSemana.dias(diasDaSemana);
					
					ProgramaSeriesRegulares programa = new ProgramaSeriesRegulares(nome, statusFinal, canal, dias, horario,
							status.getData(), temporada, genero, estilo);
					canal.conta(1);
					
					centralDeInformacoes.adicionarProgramaDeTV(programa);
					persistencia.salvarCentral(centralDeInformacoes);
					MensagemPrograma.programaSalvo();
					new TelaCadastroDeProgramaSeriesRegulares(null);
					telaCadastroDePrograma.setVisible(false);
					
				} else {
					MensagemCanal.canalNaoEncontardo();
				} // end else
			} // end if
		} catch (NumberFormatException number) {
			MensagemException.numberFormatException(number);
		} catch (HeadlessException e1) {
			e1.printStackTrace();
		} // end catch
	} // end action
} // end class
