package ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entity.Canal;
import model.CentralDeInformacoes;
import model.Persistencia;
import personalizedMessage.MensagemCanal;
import personalizedMessage.MensagemException;
import tela.TelaDeMenu;
import tela.TelaEditarCadastroDeCanal;
import tela.TelaListarTodosOsCanal;

public class OuvinteTelaDeListarCanal implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	private TelaListarTodosOsCanal telaDeListarCanal;

	public TelaListarTodosOsCanal getTelaDeListarCanal() {
		return telaDeListarCanal;
	}

	public OuvinteTelaDeListarCanal(TelaListarTodosOsCanal tela) {
		this.telaDeListarCanal = tela;
	}

	public void actionPerformed(ActionEvent e) {
		new TelaDeMenu(null);
		telaDeListarCanal.setVisible(false);
	}

	public void actionPerformedExcluir(ActionEvent e) {
		try {
			String nome = JOptionPane.showInputDialog("Informe o nome do Canal: ");
			Canal canal = centralDeInformacoes.recuperarCanal(nome);
			if (canal != null) {
				centralDeInformacoes.excluirCanal(canal);
				MensagemCanal.canalExcluido();
				persistencia.salvarCentral(centralDeInformacoes);
				telaDeListarCanal.setVisible(false);
				new TelaListarTodosOsCanal(null);
			} else {
				MensagemCanal.canalNaoEncontardo();
			}
		} catch (NumberFormatException erro) {
			MensagemException.numberFormatException(erro);
		}
	}

	public void actionPerformedAtualizar(ActionEvent e) {

		String nome = JOptionPane.showInputDialog("Informe o nome do Canal: ");
		Canal canal = centralDeInformacoes.recuperarCanal(nome);
		if (canal != null) {
			new TelaEditarCadastroDeCanal(null, canal);
			telaDeListarCanal.setVisible(false);
		} else {
			MensagemCanal.canalNaoEncontardo();
		}

	}

	public void actionPerformedDetalhar(ActionEvent e) {

		String nome = JOptionPane.showInputDialog("Nome Do Canal");
		Canal canal = centralDeInformacoes.recuperarCanal(nome);

		if (canal != null) {
			MensagemCanal.detalharCanal(canal);
		} else {
			MensagemCanal.canalNaoEncontardo();
		}
	}
}
