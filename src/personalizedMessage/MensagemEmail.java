package personalizedMessage;

import javax.swing.JOptionPane;

public class MensagemEmail {

	// E-mail
	public static void emailEnviadoUsuario() {
		JOptionPane.showMessageDialog(null, "Email enviada com sucesso!");
	}

	public static void emailErro() {
		JOptionPane.showConfirmDialog(null, "Houve Algum erro");
	}
}
