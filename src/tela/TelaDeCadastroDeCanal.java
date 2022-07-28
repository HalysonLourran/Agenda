package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

import janelas.JanelaPadrao;
import model.AdicionarJLabel;
import model.SorteioDeTelaImagens;
import model.Util;
import ouvinte.OuvinteTelaDeCadastroDeCanal;

public class TelaDeCadastroDeCanal extends JanelaPadrao {

	OuvinteTelaDeCadastroDeCanal ouvinte = new OuvinteTelaDeCadastroDeCanal(this);

	private JTextField campoNome;
	private JTextField campoLinkNumero;
	private JButton buttonVoltar;
	private JButton buttonSalvar;
	private ImageIcon iconButtons;

	public TelaDeCadastroDeCanal(String titulo) {
		super(titulo,"CADASTRAMENTO DE CANAL");
		adicionarJLabel();
		adicionarJTextField();
		adicionarJButtonVoltar();
		adicionarJButtonSalvar();
		adicionarImagem();
		setVisible(true);
	}

	private void adicionarJLabel() {
		
		AdicionarJLabel nomeDeCanal = new AdicionarJLabel();
		add(nomeDeCanal.adicionarJLabel("Nome Do Canal:", 30, 100, 250, 30));
		
		AdicionarJLabel FormaDeAssistir = new AdicionarJLabel();
		add(FormaDeAssistir.adicionarJLabel("Link Ou Número Do Canal:", 30, 180, 250, 30));
	}

	private void adicionarJTextField() {

		campoNome = new JTextField();
		campoNome.setBounds(300, 100, 200, 30);
		add(campoNome);

		campoLinkNumero = new JFormattedTextField();
		campoLinkNumero.setBounds(300, 180, 200, 30);
		add(campoLinkNumero);
	}

	private void adicionarJButtonVoltar() {
		iconButtons = new ImageIcon("icones/IconeVoltar.png");
		buttonVoltar = new JButton("Voltar",iconButtons);
		buttonVoltar.setBounds(30, 400, 130, 33);
		buttonVoltar.addActionListener(voltar());
		buttonVoltar.setBackground(new Color(46,139,87));
		buttonVoltar.setForeground(Color.WHITE);
		buttonVoltar.setFont(Util.font);
		add(buttonVoltar);
	}

	public ActionListener voltar() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
			}
		};
	}

	private void adicionarJButtonSalvar() {
		iconButtons = new ImageIcon("icones/IconeSalvar.png");
		buttonSalvar = new JButton("Salvar",iconButtons);
		buttonSalvar.setBounds(550, 400, 130, 33);
		buttonSalvar.addActionListener(salvar());
		buttonSalvar.setBackground(new Color(46,139,87));
		buttonSalvar.setForeground(Color.WHITE);
		buttonSalvar.setFont(Util.font);
		add(buttonSalvar);
	}

	public ActionListener salvar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedsalvar(e);
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

	public JTextField getCampoLinkNumero() {
		return campoLinkNumero;
	}

	public JButton getButtonVoltar() {
		return buttonVoltar;
	}

	public JButton getButtonSalvar() {
		return buttonSalvar;
	}
}
