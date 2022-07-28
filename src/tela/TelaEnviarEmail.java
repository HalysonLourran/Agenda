package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import janelas.JanelaPadrao;
import model.AdicionarJLabel;
import model.SorteioDeTelaImagens;
import model.Util;
import ouvinte.OuvinteTelaDeEnviarEmail;

public class TelaEnviarEmail extends JanelaPadrao {

	OuvinteTelaDeEnviarEmail ouvinte = new OuvinteTelaDeEnviarEmail(this);

	private JTextArea areaMensagem;
	private JTextField assunto;
	private JTextField email;
	private JButton enviar;
	private JButton voltar;
	private ImageIcon iconButtons;

	public TelaEnviarEmail(String titulo) {
		super(titulo, "ENVIAR EMAIL");
		adicionarJLabel();
		adicionarCampo();
		adicionarBotaoEnviar();
		adicionarBotaoVoltar();
		adicionarImagem();
		setVisible(true);
	}

	private void adicionarJLabel() {
		
		AdicionarJLabel assunto = new AdicionarJLabel();
		add(assunto.adicionarJLabel("Assunto", 20, 90, 130, 30));
		
		AdicionarJLabel email = new AdicionarJLabel();
		add(email.adicionarJLabel("Email", 20, 150, 130, 30));
		
		AdicionarJLabel mensagem = new AdicionarJLabel();
		add(mensagem.adicionarJLabel("Mensagem", 20, 230, 130, 30));
	}

	private void adicionarCampo() {

		assunto = new JTextField();
		assunto.setBounds(160, 90, 250, 30);
		add(assunto);

		email = new JTextField();
		email.setBounds(160, 150, 250, 30);
		add(email);

		areaMensagem = new JTextArea();
		JScrollPane painel = new JScrollPane(areaMensagem);
		painel.setBounds(160, 230, 250, 90);
		areaMensagem.setLineWrap(true);
		areaMensagem.setWrapStyleWord(true);
		add(painel);
	}

	private void adicionarBotaoEnviar() {
		iconButtons = new ImageIcon("icones/IconeEnviarEmail.png");
		enviar = new JButton("Enviar Email",iconButtons);
		enviar.setBounds(490, 400, 170, 33);
		enviar.addActionListener(enviar());
		enviar.setFont(Util.font);
		enviar.setBackground(new Color(46, 139, 87));
		enviar.setForeground(Color.WHITE);
		add(enviar);
	}

	public ActionListener enviar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedEnviar(e);
			}
		};
	}

	private void adicionarBotaoVoltar() {
		iconButtons = new ImageIcon("icones/IconeVoltar.png");
		voltar = new JButton("Voltar",iconButtons);
		voltar.setBounds(20, 400, 160, 33);
		voltar.addActionListener(voltar());
		voltar.setFont(Util.font);
		voltar.setBackground(new Color(46, 139, 87));
		voltar.setForeground(Color.WHITE);
		add(voltar);
	}

	public ActionListener voltar() {

		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedVoltar(e);
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

	public JTextField getEmail() {
		return email;
	}

	public JTextField getAssunto() {
		return assunto;
	}

	public JTextArea getAreaMensagem() {
		return areaMensagem;
	}

	public JButton getVoltar() {
		return voltar;
	}

	public JButton getEnviar() {
		return enviar;
	}
}
