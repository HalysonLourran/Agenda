package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import janelas.JanelaPadrao;
import model.AdicionarJLabel;
import model.SorteioDeTelaImagens;
import model.Util;
import ouvinte.OuvinteTelaDeLogin;

public class TelaDeLogin extends JanelaPadrao {

	OuvinteTelaDeLogin ouvinte = new OuvinteTelaDeLogin(this);

	private JTextField campoEmail;
	private JPasswordField campoSenha;
	private JButton buttonProseguir;
	private JButton buttonEsqueciSenha;
	private ImageIcon iconButton;
	

	public TelaDeLogin(String titulo) {
		super(titulo, "TELA DE LOGIN");
		adicionarTitulo();
		adicionarJLabel();
		adicionarJTextFiled();
		adicionarButtonProseguir();
		adicionarButtonEsqueciSenha();
		adicionarImagem();
		setVisible(true);
	}

	private void adicionarTitulo() {
		ImageIcon icon = new ImageIcon("src/Imagens/cats-removebg-preview.png");
		JLabel jLabel = new JLabel("TELA DE LOGIN", icon, JLabel.CENTER);
		jLabel.setBounds(0, 0, 700, 70);
		jLabel.setFont(Util.fontTitulo);
		jLabel.setOpaque(true);
		jLabel.setBackground(new Color(46, 139, 87));
		jLabel.setForeground(Color.WHITE);
	}

	private void adicionarJLabel() {

		AdicionarJLabel email = new AdicionarJLabel();
		add(email.adicionarJLabel("Email:", 30, 130, 95, 30));

		AdicionarJLabel senha01 = new AdicionarJLabel();
		add(senha01.adicionarJLabel("Senha:", 30, 230, 95, 30));
	}

	private void adicionarJTextFiled() {

		campoEmail = new JTextField();
		campoEmail.setBounds(130, 130, 200, 30);
		add(campoEmail);

		campoSenha = new JPasswordField();
		campoSenha.setBounds(130, 230, 200, 30);
		add(campoSenha);
	}

	private void adicionarButtonProseguir() {
		
		iconButton = new ImageIcon("icones/iconeProsseguir.png");
		buttonProseguir = new JButton("Prosseguir", iconButton);
		buttonProseguir.setBounds(500, 400, 160, 35);
		buttonProseguir.addActionListener(proseguir());
		buttonProseguir.setFont(Util.font);
		buttonProseguir.setBackground(new Color(46, 139, 87));
		buttonProseguir.setForeground(Color.WHITE);
		add(buttonProseguir);
		

	}

	public ActionListener proseguir() {
		return new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
			}
		};
	}

	public void adicionarButtonEsqueciSenha() {
		iconButton = new ImageIcon("icones/IconeEsqueciSenha.png");
		buttonEsqueciSenha = new JButton("Esqueci Senha", iconButton);
		buttonEsqueciSenha.setBounds(30, 400, 200, 35);
		buttonEsqueciSenha.setBackground(new Color(46, 139, 87));
		buttonEsqueciSenha.setForeground(Color.WHITE);
		buttonEsqueciSenha.setFont(Util.font);
		buttonEsqueciSenha.addActionListener(senha());
		add(buttonEsqueciSenha);

	}

	public ActionListener senha() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedSenha(e);
			}
		};
	}

	public void adicionarImagem() {

		SorteioDeTelaImagens sorteioDeTelaImagens = new SorteioDeTelaImagens();

		JLabel imagem = new JLabel();
		imagem.setIcon(new ImageIcon(sorteioDeTelaImagens.sorteioDeTela()));
		imagem.setBounds(0, 30, 700, 500);
		add(imagem);
	}

	public JTextField getCampoEmail() {
		return campoEmail;
	}

	public JPasswordField getCampoSenha() {
		return campoSenha;
	}

	public JButton getButtonProseguir() {
		return buttonProseguir;
	}

	public JButton getButtonEsqueciSenha() {
		return buttonEsqueciSenha;
	}



}
