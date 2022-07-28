package personalizedMessage;

import javax.swing.JOptionPane;

import entity.Canal;

public class MensagemCanal {

	public static void canalOpcaoInvalida() {
		JOptionPane.showConfirmDialog(null, "Opção errada.");
	}

	public static void canalSalvo() {
		JOptionPane.showMessageDialog(null, "Canal Salvo Com Sucesso!");
	}

	public static void canalExcluido() {
		JOptionPane.showMessageDialog(null, "Canal Excluído Com Sucesso!");
	}

	public static void canalNaoEncontardo() {
		JOptionPane.showMessageDialog(null, "Canal Não Encontrado!");
	}

	public static void canalAtualizado() {
		JOptionPane.showMessageDialog(null, "Canal Atualizado Com Sucesso!");
	}

	public static void detalharCanal(Canal canal) {
		JOptionPane.showMessageDialog(null, canal.toString());
	}
}
