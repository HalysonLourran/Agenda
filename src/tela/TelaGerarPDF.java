package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import janelas.JanelaPadrao;
import model.SorteioDeTelaImagens;
import model.Util;
import ouvinte.OuvinteTelaGerarPDF;

public class TelaGerarPDF extends JanelaPadrao {

	OuvinteTelaGerarPDF ouvinte = new OuvinteTelaGerarPDF(this);

	private JButton buttonGerarPDF;
	private JButton buttonVoltar;
	private ImageIcon iconButtons;

	public TelaGerarPDF(String titulo) {
		super(titulo, "TELA DE PDF");
		adicionarJButtonPDF();
		adicionarJButtonVoltar();
		adicionarImagem();
		setVisible(true);
	}

	private void adicionarJButtonPDF() {
		iconButtons = new ImageIcon("icones/IconePDF.png");
		buttonGerarPDF = new JButton("Gerar PDF De Todos Os Programas",iconButtons);
		buttonGerarPDF.setBounds(200, 200, 400, 30);
		buttonGerarPDF.addActionListener(gerarPDF());
		buttonGerarPDF.addActionListener(gerarPDF());
		buttonGerarPDF.setBackground(new Color(46, 139, 87));
		buttonGerarPDF.setForeground(Color.WHITE);
		buttonGerarPDF.setFont(Util.font);
		add(buttonGerarPDF);
	}

	public ActionListener gerarPDF() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedGerarPDF(e);
			}
		};
	}

	private void adicionarJButtonVoltar() {
		iconButtons = new ImageIcon("icones/IconeVoltar.png");
		buttonVoltar = new JButton("Voltar",iconButtons);
		buttonVoltar.setBounds(30, 400, 130, 33);
		buttonVoltar.addActionListener(voltar());
		buttonVoltar.setBackground(new Color(46, 139, 87));
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
	
	public void adicionarImagem() {

		SorteioDeTelaImagens sorteioDeTelaImagens = new SorteioDeTelaImagens();

		JLabel imagem = new JLabel();
		imagem.setIcon(new ImageIcon(sorteioDeTelaImagens.sorteioDeTela()));
		imagem.setBounds(0, 30, 700, 500);
		add(imagem);
	}

	public JButton getButtonGerarPDF() {
		return buttonGerarPDF;
	}
}
