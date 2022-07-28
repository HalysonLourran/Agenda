package ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entity.Usuario;
import model.CentralDeInformacoes;
import model.Persistencia;
import model.ValidacaoDeCadastroDeUsuario;
import personalizedMessage.MensagemException;
import personalizedMessage.MensagemUsuario;
import tela.TelaDeCadastroDeUsuario;
import tela.TelaDeMenu;

public class OuvinteTelaDeCadastroDeUsuario implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	private TelaDeCadastroDeUsuario telaDeCadastroDeUsuario;

	public TelaDeCadastroDeUsuario getTelaDeCadastroDeUsuario() {
		return telaDeCadastroDeUsuario;
	}

	public OuvinteTelaDeCadastroDeUsuario(TelaDeCadastroDeUsuario tela) {
		this.telaDeCadastroDeUsuario = tela;
	}

	public void actionPerformed(ActionEvent e) {

		// salvarUsuario
		String nome = telaDeCadastroDeUsuario.getCampoNome().getText();
		String email = telaDeCadastroDeUsuario.getCampoEmail().getText();
		String senha01 = new String(telaDeCadastroDeUsuario.getCampoSenha01().getPassword());
		String senha02 = new String(telaDeCadastroDeUsuario.getCampoSenha02().getPassword());
		try {
			if (nome.isBlank() || email.isBlank() || senha01.isBlank() || senha02.isBlank()) {

				MensagemUsuario.usuarioCampoVazio();

			} else if (!senha01.equals(senha02)) {

				MensagemUsuario.usuarioSenhaErrada();

			} else {

				Usuario usuario = new Usuario(nome, email, senha01);
				ValidacaoDeCadastroDeUsuario validacao = new ValidacaoDeCadastroDeUsuario();
				
				validacao.validarSenha(usuario);
				validacao.validarEmail(usuario);
				validacao.validarNome(usuario);

				if (centralDeInformacoes.salvarUsuario(usuario)) {
					
					persistencia.salvarCentral(centralDeInformacoes);
					MensagemUsuario.usuarioSalvo();
					new TelaDeMenu(null);
					telaDeCadastroDeUsuario.setVisible(false);

				} else {
					MensagemUsuario.usuarioErro();
				} // end else
			} // end else
		} catch (NullPointerException erro) {
			MensagemException.nullPointerException(erro);
		} catch (Exception e1) {
		    MensagemException.exception(e1);
		} // end catch
	} // end actionPerformed
} // end class
