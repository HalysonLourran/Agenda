package ouvinte;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;

import entity.Canal;
import entity.ProgramaDeRealityShows;
import enuns.StatusDeExebicao;
import model.CentralDeInformacoes;
import model.DiasDaSemana;
import model.Persistencia;
import model.StatusHiato;
import personalizedMessage.MensagemCanal;
import personalizedMessage.MensagemException;
import personalizedMessage.MensagemPrograma;
import personalizedMessage.MensagemUsuario;
import tela.TelaCadastroDeProgramaDeRealityShows;
import tela.TelaCadastroDeProgramaSeriesRegulares;
import tela.TelaDeMenu;

public class OuvinteTelaDeCadastroDeProgramaDeRealityShows implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	private TelaCadastroDeProgramaDeRealityShows telaCadastroDePrograma;

	public TelaCadastroDeProgramaDeRealityShows getTelaCadastroDePrograma() {
		return telaCadastroDePrograma;
	}

	public OuvinteTelaDeCadastroDeProgramaDeRealityShows(TelaCadastroDeProgramaDeRealityShows tela) {
		this.telaCadastroDePrograma = tela;
	}

	public void actionPerformed(ActionEvent e) {
		
		telaCadastroDePrograma.dispose();
		new TelaDeMenu(null);
		
	} // end action

	public void actionPerformedSalvar(ActionEvent e) {

		try {

			String nome = telaCadastroDePrograma.getCampoNomeDoPrograma().getText();
			long id = Long.parseLong(telaCadastroDePrograma.getCampoIDCanal().getText());
			String horario = telaCadastroDePrograma.getCampoHorario().getText();
			String apresentador = telaCadastroDePrograma.getCampoApresentador().getText();
			String temporada = telaCadastroDePrograma.getCampoTemporada().getText();
			String diasDaSemana[] = telaCadastroDePrograma.getCampoDiasDaSemana().getText().split(", ");
			
			if (nome.isBlank() || horario.isBlank() || apresentador.isBlank() || temporada.isBlank()) {
				MensagemUsuario.usuarioCampoVazio();
			} else {
				
				Canal canal = centralDeInformacoes.recuperarCanalId(id);

				if (canal != null) {

					StatusHiato status = new StatusHiato();
					StatusDeExebicao statusFinal = status.statusDeExebicao();
					DayOfWeek dias[] = DiasDaSemana.dias(diasDaSemana);
						
					ProgramaDeRealityShows programa = new ProgramaDeRealityShows(nome, apresentador, statusFinal, canal,
							dias, horario, status.getData(), temporada);
					canal.conta(1);
					centralDeInformacoes.adicionarProgramaDeTV(programa);
					persistencia.salvarCentral(centralDeInformacoes);
					MensagemPrograma.programaSalvo();
					telaCadastroDePrograma.dispose();
					new TelaCadastroDeProgramaSeriesRegulares(null);
					
				} else {
					MensagemCanal.canalNaoEncontardo();
				} // end else
			} // end if
		} catch (NumberFormatException number) {
			MensagemException.numberFormatException(number);
		} catch (HeadlessException e1) {
			e1.printStackTrace();
		}
	} 
} // end class
