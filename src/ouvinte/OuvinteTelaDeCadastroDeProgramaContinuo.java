package ouvinte;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.DayOfWeek;

import entity.Canal;
import entity.ProgramaContinuo;
import enuns.StatusDeExebicao;
import model.CentralDeInformacoes;
import model.DiasDaSemana;
import model.Persistencia;
import model.StatusHiato;
import personalizedMessage.MensagemCanal;
import personalizedMessage.MensagemException;
import personalizedMessage.MensagemPrograma;
import personalizedMessage.MensagemUsuario;
import tela.TelaCadastroDeProgramaContinuo;
import tela.TelaCadastroDeProgramaSeriesRegulares;
import tela.TelaDeMenu;

public class OuvinteTelaDeCadastroDeProgramaContinuo implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	private TelaCadastroDeProgramaContinuo telaCadastroDePrograma;

	public TelaCadastroDeProgramaContinuo getTelaCadastroDePrograma() {
		return telaCadastroDePrograma;
	}

	public OuvinteTelaDeCadastroDeProgramaContinuo(TelaCadastroDeProgramaContinuo tela) {
		this.telaCadastroDePrograma = tela;
	}

	public void actionPerformed(ActionEvent e) {

		telaCadastroDePrograma.dispose();
		new TelaDeMenu(null);
	} // end action

	public void actionPerformedSalvar(ActionEvent e) throws ParseException {

		try {

			String nome = telaCadastroDePrograma.getCampoNomeDoPrograma().getText();
			long id = Long.parseLong(telaCadastroDePrograma.getCampoIDCanal().getText());
			String horario = telaCadastroDePrograma.getCampoHorario().getText();
			String diasDaSemana[] = telaCadastroDePrograma.getCampoDiasDaSemana().getText().split(", ");
			String apresentador = telaCadastroDePrograma.getCampoApresentador().getText();

			if (nome.isBlank() || horario.isBlank()) {
				MensagemUsuario.usuarioCampoVazio();
			} else {

				Canal canal = centralDeInformacoes.recuperarCanalId(id);

				if (canal != null) {
					
					StatusHiato status = new StatusHiato();
					StatusDeExebicao statusFinal = status.statusDeExebicao();
					DayOfWeek dias[] = DiasDaSemana.dias(diasDaSemana);

					ProgramaContinuo programa = new ProgramaContinuo(nome, apresentador, statusFinal, canal, dias, horario, status.getData());

					centralDeInformacoes.adicionarProgramaDeTV(programa);
					
					persistencia.salvarCentral(centralDeInformacoes);
					MensagemPrograma.programaSalvo();
					telaCadastroDePrograma.dispose();
					new TelaCadastroDeProgramaSeriesRegulares(null);
				} else {
					MensagemCanal.canalNaoEncontardo();
				}
			} // end if
		} catch (NumberFormatException number) {
			MensagemException.numberFormatException(number);
		} catch (HeadlessException e1) {
			e1.printStackTrace();
		}
	} // end action
} // end class
