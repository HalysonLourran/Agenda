package ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entity.Programa;
import entity.ProgramaContinuo;
import entity.ProgramaDeRealityShows;
import entity.ProgramaSeriesRegulares;
import entity.Usuario;
import enuns.TipoDePrograma;
import model.CentralDeInformacoes;
import model.Persistencia;
import personalizedMessage.MensagemAgenda;
import personalizedMessage.MensagemException;
import personalizedMessage.MensagemPrograma;
import tela.TelaDeMenu;
import tela.TelaEditarCadastroDeProgramaSeriesRegulares;
import tela.TelaEditarProgramaContinuo;
import tela.TelaEditarProgramaDeRealityShows;
import tela.TelaListarTodosOsProgramas;

public class OuvinteTelaListarTodosOsProgramas implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	private TelaListarTodosOsProgramas telaListarTodosOsProgrmas;

	public TelaListarTodosOsProgramas getTelaListarTodosOsProgrmas() {
		return telaListarTodosOsProgrmas;
	}

	public OuvinteTelaListarTodosOsProgramas(TelaListarTodosOsProgramas tela) {
		this.telaListarTodosOsProgrmas = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		telaListarTodosOsProgrmas.setVisible(false);
		new TelaDeMenu(null);
	}

	public void actionPerformedExcluir(ActionEvent e) {

		try {
			long id = Long.parseLong(JOptionPane.showInputDialog("Informe o ID do Programa"));
			Programa programaDeTV = centralDeInformacoes.recuperarProgramaDeTVporId(id);

			if (programaDeTV != null) {
				centralDeInformacoes.excluirPrograma(programaDeTV);
				persistencia.salvarCentral(centralDeInformacoes);
				MensagemPrograma.programaExcluidoComSucesso();
				telaListarTodosOsProgrmas.setVisible(false);
				new TelaListarTodosOsProgramas(null);
			} else {
				MensagemPrograma.programaNaoEncontradoComEsteID();
			} // end else
		} catch (Exception erro) {
			MensagemException.numberFormatException(erro);
		} // end catch
	} // end actionPerformed

	public void actionPerformedAtualizar(ActionEvent e) {

		try {
			long id = Long
					.parseLong(JOptionPane.showInputDialog(telaListarTodosOsProgrmas, "Informe o ID do Programa"));
			Programa programaDeTV = centralDeInformacoes.recuperarProgramaDeTVporId(id);

			if (programaDeTV != null) {

				if (programaDeTV.getTipoDePrograma().equals(TipoDePrograma.PROGRAMAS_CONTINUOS)) {
					new TelaEditarProgramaContinuo(null, (ProgramaContinuo) programaDeTV);
					telaListarTodosOsProgrmas.setVisible(false);
				} else if (programaDeTV.getTipoDePrograma().equals(TipoDePrograma.SERIES_REGULARES)) {
					new TelaEditarCadastroDeProgramaSeriesRegulares(null, (ProgramaSeriesRegulares) programaDeTV);
					telaListarTodosOsProgrmas.setVisible(false);
				} else {
					new TelaEditarProgramaDeRealityShows(null, (ProgramaDeRealityShows) programaDeTV);
					telaListarTodosOsProgrmas.setVisible(false);
				} // end else

			} else {
				MensagemPrograma.programaNaoEncontradoComEsteID();
			} // end else
		} catch (NumberFormatException erro) {
			MensagemException.numberFormatException(erro);
		} // end catch
	} // end actionPerformed

	public void actionPerformedDetalhar(ActionEvent e) {

		try {
			long id = Long.parseLong(JOptionPane.showInputDialog("Informe o ID do Programa"));
			Programa programaDeTV = centralDeInformacoes.recuperarProgramaDeTVporId(id);

			if (programaDeTV != null) {
				MensagemPrograma.detalharPrograma(programaDeTV);
			} else {
				MensagemPrograma.programaNaoEncontradoComEsteID();
			} // end else
		} catch (Exception erro) {
			MensagemException.numberFormatException(erro);
		} // end catch
	} // end actionPerformed

	public void actionPerformedAdicionarNaAgenda(ActionEvent e) {

		try {

			long id = Long.parseLong(JOptionPane.showInputDialog("Informe o ID do Programa"));

			Programa programaDeTV = centralDeInformacoes.recuperarProgramaDeTVporId(id);
			
			Usuario usuario = centralDeInformacoes.recuperarUsuario(centralDeInformacoes.getTodosOsUsuarios().get(0).getNome());

			if (programaDeTV != null) {
				
				for (int i = 0; i < centralDeInformacoes.getTodasAsAgendas().size(); i++) {
					if(centralDeInformacoes.getTodasAsAgendas().get(i).getId() == programaDeTV.getId()) {
						MensagemAgenda.programaJaExisteNaSuaAgenda();
					} // end if
				} // end for

				if (centralDeInformacoes.AdicionarAgenda(programaDeTV)) {
					
					usuario.setMinhaAgenda(centralDeInformacoes.getTodasAsAgendas());
 
					persistencia.salvarCentral(centralDeInformacoes);
					MensagemAgenda.adicionarNaMinhaAgenda();

				} // end if
			} else {
				MensagemPrograma.programaNaoEncontradoComEsteID();
			} // end else
		} catch (NumberFormatException erro) {
			MensagemException.numberFormatException(erro);
		} // end catch
	} // end actionPErformed

}