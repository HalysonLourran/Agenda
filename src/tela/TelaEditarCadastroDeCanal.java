package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entity.Canal;
import janelas.JanelaPadrao;
import model.AdicionarJLabel;
import model.SorteioDeTelaImagens;
import model.Util;
import ouvinte.OuvinteTelaEditarCadastroDeCanal;

public class TelaEditarCadastroDeCanal extends JanelaPadrao {

	OuvinteTelaEditarCadastroDeCanal ouvinte = new OuvinteTelaEditarCadastroDeCanal(this);

	private JTextField campoNome;
	private JTextField campoFormaDeAssistir;
	private JTextField campoNumeroOuLink;
	private JTextField campoid;
	private JButton buttonSalvar;
	private JButton buttonVoltar;
	private Canal canal;
	private ImageIcon iconButtons;

	public TelaEditarCadastroDeCanal(String titulo, Canal canal) {
		super(titulo, "CADASTRAMENTO DE CANAL");
		this.canal = canal;
		adicionarJLabel();
		adicionarJTextFiled();
		adicionarJButtonsalvar();
		adicionarJButtonVoltar();
		adicionarImagem();
		setVisible(true);
	}

	private void adicionarJLabel() {
		
		AdicionarJLabel nomeDeCanal = new AdicionarJLabel();
		add(nomeDeCanal.adicionarJLabel("Nome Do Canal:", 30, 100, 250, 30));
		
		AdicionarJLabel FormaDeAssistir = new AdicionarJLabel();
		add(FormaDeAssistir.adicionarJLabel("Link Ou Número Do Canal:", 30, 180, 250, 30));
	}

	private void adicionarJTextFiled() {

		campoNome = new JTextField();
		campoNome.setBounds(300, 100, 200, 30);
		campoNome.setText(this.canal.getNome());
		add(campoNome);

		campoNumeroOuLink = new JTextField();
		campoNumeroOuLink.setBounds(300, 180, 200, 30);
		campoNumeroOuLink.setText(this.canal.getLinkOuCanal());
		add(campoNumeroOuLink);

		campoid = new JTextField();
		campoid.setText(String.valueOf(this.canal.getId()));
	}

	public void adicionarJButtonsalvar() {
		iconButtons = new ImageIcon("icones/IconeSalvar.png");
		buttonSalvar = new JButton("Salvar",iconButtons);
		buttonSalvar.setBounds(540, 390, 130, 30);
		buttonSalvar.addActionListener(salvar());
		buttonSalvar.setBackground(new Color(46, 139, 87));
		buttonSalvar.setForeground(Color.WHITE);
		buttonSalvar.setFont(Util.font);
		add(buttonSalvar);

	}

	public ActionListener salvar() {
		return new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
			}
		};
	}

	public void adicionarJButtonVoltar() {
		iconButtons = new ImageIcon("icones/IconeVoltar.png");
		buttonVoltar = new JButton("Voltar",iconButtons);
		buttonVoltar.setBounds(30, 390, 130, 33);
		buttonVoltar.addActionListener(voltar());
		buttonVoltar.setBackground(new Color(46, 139, 87));
		buttonVoltar.setForeground(Color.WHITE);
		buttonVoltar.setFont(Util.font);
		add(buttonVoltar);
	}

	public ActionListener voltar() {
		return new ActionListener() {

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

	public JTextField getCampoNome() {
		return campoNome;
	}

	public JTextField getCampoFormaDeAssistir() {
		return campoFormaDeAssistir;
	}

	public JTextField getCampoNumeroOuLink() {
		return campoNumeroOuLink;
	}

	public JButton getButtonSalvar() {
		return buttonSalvar;
	}

	public JButton getButtonVoltar() {
		return buttonVoltar;
	}

	public JTextField getCampoid() {
		return campoid;
	}

	public void setCampoid(JTextField campoid) {
		this.campoid = campoid;
	}
}
