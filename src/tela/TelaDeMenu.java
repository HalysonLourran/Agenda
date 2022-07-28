package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import applicationAgenda.EnviarEmailTarefa;
import applicationAgenda.Hiato;
import janelas.JanelaPadrao;
import model.SorteioDeTelaImagens;
import model.Util;
import ouvinte.OuvinteTelaDeMenu;

public class TelaDeMenu extends JanelaPadrao {

	OuvinteTelaDeMenu ouvinte = new OuvinteTelaDeMenu(this);

	private JButton buttonExcluir;
	private JMenuBar jMenuBar;
	private ImageIcon iconButtons;

	public TelaDeMenu(String titulo) {
		super(titulo, "TELA DE MENU");
		excluirUsuario();
		adicionarMenu();
		tarefa();
		adicionarImagem();
		setVisible(true);
	}

	public void tarefa() {

		Timer timer = new Timer();
		EnviarEmailTarefa emailTarefa = new EnviarEmailTarefa();
		timer.scheduleAtFixedRate(emailTarefa, 0, 100000);

		Hiato hiato = new Hiato();
		Thread thread = new Thread(hiato);
		thread.start();
	}

	private void excluirUsuario() {
		iconButtons = new ImageIcon("icones/IconeExcluir.png");
		buttonExcluir = new JButton("Excluir Usuário",iconButtons);
		buttonExcluir.setBounds(480, 370, 210, 30);
		buttonExcluir.setFont(Util.font);
		buttonExcluir.setBackground(new Color(46, 139, 87));
		buttonExcluir.setForeground(Color.WHITE);
		buttonExcluir.addActionListener(excluir());
		add(buttonExcluir);
	}

	public ActionListener excluir() {
		return new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedExcluir(e);
			}
		};
	}

	private void adicionarMenu() {

		jMenuBar = new JMenuBar();
		setJMenuBar(jMenuBar);

		JMenu menuOp = new JMenu("Opçoes");
		menuOp.setFont(Util.font);
		menuOp.setOpaque(true);
		menuOp.setBackground(new Color(46, 139, 87));
		menuOp.setForeground(new Color(46, 139, 87));
		jMenuBar.add(menuOp);

		JMenuItem cadastroDeCanal = new JMenuItem("Cadastrar Canal");
		cadastroDeCanal.setFont(Util.font);
		cadastroDeCanal.setBackground(new Color(60, 179, 113));
		cadastroDeCanal.setForeground(Color.WHITE);
		menuOp.add(cadastroDeCanal);
		cadastroDeCanal.addActionListener(ouvinte);

		JMenuItem listarCanal = new JMenuItem("Listar Canal");
		menuOp.add(listarCanal);
		listarCanal.setFont(Util.font);
		listarCanal.setBackground(new Color(46, 139, 87));
		listarCanal.setForeground(Color.WHITE);
		listarCanal.addActionListener(ouvinte);

		JMenuItem cadastrarPrograma = new JMenuItem("Cadastrar Programas");
		menuOp.add(cadastrarPrograma);
		cadastrarPrograma.setFont(Util.font);
		cadastrarPrograma.setBackground(new Color(60, 179, 113));
		cadastrarPrograma.setForeground(Color.WHITE);
		cadastrarPrograma.addActionListener(ouvinte);

		JMenuItem listarPrograma = new JMenuItem("Listar Programas");
		menuOp.add(listarPrograma);
		listarPrograma.setFont(Util.font);
		listarPrograma.setBackground(new Color(46, 139, 87));
		listarPrograma.setForeground(Color.WHITE);
		listarPrograma.addActionListener(ouvinte);

		JMenuItem gerarPDF = new JMenuItem("Gerar PDF");
		menuOp.add(gerarPDF);
		gerarPDF.setFont(Util.font);
		gerarPDF.setBackground(new Color(60, 179, 113));
		gerarPDF.setForeground(Color.WHITE);
		gerarPDF.addActionListener(ouvinte);

		JMenuItem agenda = new JMenuItem("Minha Agenda");
		menuOp.add(agenda);
		agenda.setFont(Util.font);
		agenda.setBackground(new Color(60, 179, 113));
		agenda.setForeground(Color.WHITE);
		agenda.addActionListener(ouvinte);

		JMenuItem email = new JMenuItem("Enviar Minha Agenda Por Email");
		menuOp.add(email);
		email.setFont(Util.font);
		email.setBackground(new Color(46, 139, 87));
		email.setForeground(Color.WHITE);
		email.addActionListener(ouvinte);
		
		JMenuItem sair = new JMenuItem("Sair");
		menuOp.add(sair);
		sair.setFont(Util.font);
		sair.setBackground(new Color(46, 139, 87));
		sair.setForeground(Color.WHITE);
		sair.addActionListener(ouvinte);

	}
	
	public void adicionarImagem() {

		SorteioDeTelaImagens sorteioDeTelaImagens = new SorteioDeTelaImagens();

		JLabel imagem = new JLabel();
		imagem.setIcon(new ImageIcon(sorteioDeTelaImagens.sorteioDeTela()));
		imagem.setBounds(0, 30, 700, 500);
		add(imagem);
	}

	public JButton getButtonExcluir() {
		return buttonExcluir;
	}
}
