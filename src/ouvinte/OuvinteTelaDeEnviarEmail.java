package ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CentralDeInformacoes;
import model.Mensageiro;
import model.Persistencia;
import personalizedMessage.MensagemEmail;
import personalizedMessage.MensagemUsuario;
import tela.TelaDeMenu;
import tela.TelaEnviarEmail;

public class OuvinteTelaDeEnviarEmail implements ActionListener {

	private TelaEnviarEmail telaEnviarEmail;

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral();

	public OuvinteTelaDeEnviarEmail(TelaEnviarEmail tela) {
		this.telaEnviarEmail = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void actionPerformedEnviar(ActionEvent e) {

		try {

			String email = telaEnviarEmail.getEmail().getText();
			String assunto = telaEnviarEmail.getAssunto().getText();
			String mensagem = telaEnviarEmail.getAreaMensagem().getText();

			if (!email.isBlank() || !assunto.isBlank() || !mensagem.isBlank()) {

				Mensageiro.enviarProgramacaoDeHoje(assunto, email, mensagem + central.getTodasAsAgendas().toString());

			}  else {
				MensagemUsuario.usuarioCampoVazio();
			}
			
		} catch (Exception erro) {
			MensagemEmail.emailErro();
		}
	}

	public void actionPerformedVoltar(ActionEvent e) {

		new TelaDeMenu(null);
		telaEnviarEmail.setVisible(false);

	}
}
