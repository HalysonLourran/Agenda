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
import tela.TelaEditarCadastroDeProgramaSeriesRegulares;
import tela.TelaListarTodosOsProgramas;

public class OuvinteTelaEditarCadastroDeProgramaSeriesRegulares implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	private TelaEditarCadastroDeProgramaSeriesRegulares telaCadastroDePrograma;

	public TelaEditarCadastroDeProgramaSeriesRegulares getTelaCadastroDePrograma() {
		return telaCadastroDePrograma;
	}

	public OuvinteTelaEditarCadastroDeProgramaSeriesRegulares(TelaEditarCadastroDeProgramaSeriesRegulares tela) {
		this.telaCadastroDePrograma = tela;
	}

	public void actionPerformed(ActionEvent e) {
		new TelaListarTodosOsProgramas(null);
		telaCadastroDePrograma.setVisible(false);
	} // end action

	public void actionPerformedSalvar(ActionEvent e) {

		try {

			String nome = telaCadastroDePrograma.getCampoNomeDoPrograma().getText();
			long id = Long.parseLong(telaCadastroDePrograma.getCampoIDCanal().getText());
			String horario = telaCadastroDePrograma.getCampoHorario().getText();
			String genero = telaCadastroDePrograma.getCampoGenero().getText();
			String temporada = telaCadastroDePrograma.getCampoTemporada().getText();
			String diasDaSemana[] = telaCadastroDePrograma.getCampoDiasDaSemana().getText().split(", ");
			long idPrograma = Long.parseLong(telaCadastroDePrograma.getCampoID().getText());
			
			if (nome.isBlank() || horario.isBlank() || genero.isBlank() || temporada.isBlank()) {
				MensagemUsuario.usuarioCampoVazio();
			} else {

				Canal canal = centralDeInformacoes.recuperarCanalId(id);

				if (canal != null) {

					StatusHiato status = new StatusHiato();
					StatusDeExebicao statusFinal = status.statusDeExebicao();
					EstiloSeriesRegulares estilo = status.estiloSeriesRegulares();
					DayOfWeek dias[] = DiasDaSemana.dias(diasDaSemana);
					
					ProgramaSeriesRegulares programa = (ProgramaSeriesRegulares) centralDeInformacoes
							.recuperarProgramaDeTVporId(idPrograma);

					if (programa instanceof ProgramaSeriesRegulares) {
						ProgramaSeriesRegulares ps = (ProgramaSeriesRegulares) programa;

						ps.setNome(nome);
						ps.setStatusDeExebicao(statusFinal);
						ps.setCanal(canal);
						ps.setDiasDaSemana(dias);
						ps.setHorario(horario);
						ps.setDataHiato(status.getData());
						ps.setTemparada(temporada);
						ps.setGenero(genero);
						ps.setEstilo(estilo);
  
						canal.conta(1);
						centralDeInformacoes.adicionarProgramaDeTV(programa);
						persistencia.salvarCentral(centralDeInformacoes);
						MensagemPrograma.programaSalvo();
						new TelaListarTodosOsProgramas(null);
						telaCadastroDePrograma.setVisible(false);
					}
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
}
// end class
