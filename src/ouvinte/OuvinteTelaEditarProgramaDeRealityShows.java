package ouvinte;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;

import entity.Canal;
import entity.Programa;
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
import tela.TelaEditarProgramaDeRealityShows;
import tela.TelaListarTodosOsProgramas;

public class OuvinteTelaEditarProgramaDeRealityShows implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	private TelaEditarProgramaDeRealityShows telaEditarProgramaDeRealityShows;

	public TelaEditarProgramaDeRealityShows telaEditarProgramaDeRealityShows() {
		return telaEditarProgramaDeRealityShows;
	}

	public OuvinteTelaEditarProgramaDeRealityShows(TelaEditarProgramaDeRealityShows tela) {
		this.telaEditarProgramaDeRealityShows = tela;
	}

	public void actionPerformed(ActionEvent e) {
		new TelaListarTodosOsProgramas(null);
		telaEditarProgramaDeRealityShows.setVisible(false);
	} // end action

	public void actionPerformedSalvar(ActionEvent e) {

		try {

			String nome = telaEditarProgramaDeRealityShows.getCampoNomeDoPrograma().getText();
			String nomeDoApresentador = telaEditarProgramaDeRealityShows.getCampoApresentador().getText();
			long idCanal = Long.parseLong(telaEditarProgramaDeRealityShows.getCampoIDCanal().getText());
			String horario = telaEditarProgramaDeRealityShows.getCampoHorario().getText();
			String temporada = telaEditarProgramaDeRealityShows.getCampoTemporada().getText();
			long idPrograma = Long.parseLong(telaEditarProgramaDeRealityShows.getCampoIDPrograma().getText());
			String diasDaSemana[] = telaEditarProgramaDeRealityShows.getCampoDiasDaSemana().getText().split(", ");
		
			if (nome.isBlank() || horario.isBlank() || nomeDoApresentador.isBlank() || temporada.isBlank()) {
				MensagemUsuario.usuarioCampoVazio();
			} else {

				Canal canal = centralDeInformacoes.recuperarCanalId(idCanal);

				if (canal != null) {

					StatusHiato status = new StatusHiato();
					StatusDeExebicao statusFinal = status.statusDeExebicao();
					DayOfWeek dias[] = DiasDaSemana.dias(diasDaSemana);
					
					Programa programa = centralDeInformacoes.recuperarProgramaDeTVporId(idPrograma);

					if (programa instanceof ProgramaDeRealityShows) {
						ProgramaDeRealityShows pr = (ProgramaDeRealityShows) programa;

						if (programa != null) {

							pr.setNome(nome);
							pr.setNomeDosApresentadores(nomeDoApresentador);
							pr.setStatusDeExebicao(statusFinal);
							pr.setCanal(canal);
							pr.setDiasDaSemana(dias);
							pr.setHorario(horario);
							pr.setDataHiato(status.getData());
							pr.setTemporada(temporada);
							
							canal.conta(1);
							persistencia.salvarCentral(centralDeInformacoes);
							MensagemPrograma.programaAtualizado();
							new TelaListarTodosOsProgramas(null);
							telaEditarProgramaDeRealityShows.setVisible(false);
						} // end if
					} // end if 
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
