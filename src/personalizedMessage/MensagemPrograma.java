package personalizedMessage;

import javax.swing.JOptionPane;

import entity.Programa;

public class MensagemPrograma {

	public static void programaSalvo() {
		JOptionPane.showMessageDialog(null, "Programa Salvo Com Sucesso!");
	}

	public static void programaNaoEncontradoComEsteID() {
		JOptionPane.showMessageDialog(null, "Programa não encontrado com este ID!");
	}

	public static void programaExcluidoComSucesso() {
		JOptionPane.showMessageDialog(null, "Programa excluido com sucesso!");
	}

	public static void detalharPrograma(Programa programa) {
		JOptionPane.showMessageDialog(null, programa.toString());
	}
	
	public static void programaAtualizado() {
		JOptionPane.showMessageDialog(null, "Programa Atualizado com sucesso!");
	}
}
