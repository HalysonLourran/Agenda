package personalizedMessage;

import javax.swing.JOptionPane;

public class MensagemException {
	//Exception
	public static void exception(Exception e) {
		JOptionPane.showMessageDialog(null, "Erro. " + e.getMessage());
	}

	// NumberFormatException
	public static void numberFormatException(Exception erro) {
		JOptionPane.showMessageDialog(null, "Erro." + erro.getMessage());
	}
	// NullPointerException
	public static void nullPointerException(NullPointerException e) {
		JOptionPane.showMessageDialog(null, "Erro." + e.getMessage());
	}
}
