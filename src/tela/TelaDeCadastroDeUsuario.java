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
import ouvinte.OuvinteTelaDeCadastroDeUsuario;


public class TelaDeCadastroDeUsuario extends JanelaPadrao {
	
	OuvinteTelaDeCadastroDeUsuario ouvinte = new OuvinteTelaDeCadastroDeUsuario(this);
	
	private JTextField campoNome;
	private JTextField campoEmail;
	private JPasswordField campoSenha01;
	private JPasswordField campoSenha02;
	private JButton buttonSalvar;
	private ImageIcon iconButtons;

	public TelaDeCadastroDeUsuario(String titulo) {
		super(titulo, "CADASTRAMENTO DO USUÁRIO");
		adicionarJLabel();
		adicionarJTextFiled();
		buttonSalvar();
		adicionarImagem();
		setVisible(true);
	}
	
	private void adicionarJLabel() {
		
		AdicionarJLabel nome = new AdicionarJLabel();
		add(nome.adicionarJLabel("Nome:", 30, 90, 95, 30));
		
		AdicionarJLabel email = new AdicionarJLabel();
		add(email.adicionarJLabel("Email:", 30, 160, 95, 30));
		
		AdicionarJLabel senha01 = new AdicionarJLabel();
		add(senha01.adicionarJLabel("Senha:",30, 230, 95, 30));
		
		AdicionarJLabel senha02 = new AdicionarJLabel();
		add(senha02.adicionarJLabel("Senha:", 30, 300, 95, 30));
	}
	
	private void adicionarJTextFiled() {
		
		campoNome = new JTextField();
		campoNome.setBounds(130, 90, 250, 30);
		add(campoNome);
		
		campoEmail =  new JTextField();
		campoEmail.setBounds(130, 160, 250, 30);
		add(campoEmail);
		
		campoSenha01 = new JPasswordField();
		campoSenha01.setBounds(130, 230, 200, 30);
		add(campoSenha01);
		
		campoSenha02 = new JPasswordField();
		campoSenha02.setBounds(130, 300, 200, 30);
		add(campoSenha02);
	}
	
	private void buttonSalvar() {
		iconButtons = new ImageIcon("icones/IconeSalvar.png");
		buttonSalvar = new JButton("Salvar",iconButtons);
		buttonSalvar.setBounds(520, 400, 130, 35);
		buttonSalvar.setBackground(new Color(46,139,87));
		buttonSalvar.setForeground(Color.WHITE);
		buttonSalvar.setFont(Util.font);
		buttonSalvar.addActionListener(salvar());
		add(buttonSalvar);
	}
	
	public ActionListener salvar() {
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
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
	
	public JTextField getCampoNome() {
		return campoNome;
	}

	public JTextField getCampoEmail() {
		return campoEmail;
	}

	public JPasswordField getCampoSenha01() {
		return campoSenha01;
	}

	public JPasswordField getCampoSenha02() {
		return campoSenha02;
	}

	public JButton getButtonSalvar() {
		return buttonSalvar;
	}
}
