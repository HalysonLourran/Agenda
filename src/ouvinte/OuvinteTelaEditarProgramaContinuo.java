package ouvinte;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;

import entity.Canal;
import entity.Programa;
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
import tela.TelaEditarProgramaContinuo;
import tela.TelaListarTodosOsProgramas;

public class OuvinteTelaEditarProgramaContinuo implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	private TelaEditarProgramaContinuo editarProgramaContinuo;

	public TelaEditarProgramaContinuo tela() {
		return editarProgramaContinuo;
	}

	public OuvinteTelaEditarProgramaContinuo(TelaEditarProgramaContinuo tela) {
		this.editarProgramaContinuo = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		new TelaListarTodosOsProgramas(null);
		editarProgramaContinuo.setVisible(false);
	}

	public void actionPerformedSalvar(ActionEvent e) {

		try {

			String nome = editarProgramaContinuo.getCampoNomeDoPrograma().getText();
			long id = Long.parseLong(editarProgramaContinuo.getCampoIDCanal().getText());
			String horario = editarProgramaContinuo.getCampoHorario().getText();
			String diasDaSemana[] = editarProgramaContinuo.getCampoDiasDaSemana().getText().split(", ");
			String apresentador = editarProgramaContinuo.getCampoApresentador().getText();
			long idPrograma = Long.parseLong(editarProgramaContinuo.getCampoID().getText());

			if (nome.isBlank() || horario.isBlank()) {
				MensagemUsuario.usuarioCampoVazio();
			} else {

				Canal canal = centralDeInformacoes.recuperarCanalId(id);

				if (canal != null) {

					StatusHiato status = new StatusHiato();
					StatusDeExebicao statusFinal = status.statusDeExebicao();
					DayOfWeek dias[] = DiasDaSemana.dias(diasDaSemana);

					Programa programa = centralDeInformacoes.recuperarProgramaDeTVporId(idPrograma);

					if (programa instanceof ProgramaContinuo) {
						ProgramaContinuo pc = (ProgramaContinuo) programa;

						if (programa != null) {

							pc.setNome(nome);
							pc.setNomeDoApresentador(apresentador);
							pc.setStatusDeExebicao(statusFinal);
							pc.setCanal(canal);
							pc.setDiasDaSemana(dias);
							pc.setHorario(horario);
							pc.setDataHiato(status.getData());
							
							canal.conta(1);
							persistencia.salvarCentral(centralDeInformacoes);
							MensagemPrograma.programaAtualizado();
							new TelaListarTodosOsProgramas(null);
							editarProgramaContinuo.setVisible(false);
						} // end if
					} else {
						MensagemCanal.canalNaoEncontardo();
					} // end else
				} // end if
			} // end else 
		} catch (NumberFormatException number) {
			MensagemException.numberFormatException(number);
		} catch (HeadlessException e1) {
			e1.printStackTrace();
		} // end catch
	}
}
