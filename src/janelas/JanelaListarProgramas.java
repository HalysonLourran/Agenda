package janelas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.Util;

public class JanelaListarProgramas extends JFrame {

	public JanelaListarProgramas(String titulo) {

		setTitle("Agenda de S�ries");
		setSize(1200, 700);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addTema();
		tituloDaTela();
		setResizable(false);
	}

	private void addTema() {
		try {
			// AQUI VOCE SETA O NOME DA CLASSE REFERENTE A CADA TEMA !
			String tema = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";

			// AQUI VC SETA O LOOK AND FEEL
			UIManager.setLookAndFeel(tema);
		} catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException
				| ClassNotFoundException e) {
			System.out.println("Erro LAF : " + e.getMessage());
		}
	}

	public void tituloDaTela() {

		ImageIcon icon = new ImageIcon("icones/IconeLogo.png");
		JLabel jLabel = new JLabel("CADASTRO DE PROGRAMA", icon, JLabel.CENTER);
		jLabel.setBounds(0, 0, 1200, 70);
		jLabel.setFont(Util.fontTitulo);
		jLabel.setOpaque(true);
		jLabel.setBackground(new Color(46, 139, 87));
		jLabel.setForeground(Color.WHITE);
		jLabel.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {

			}

			public void mouseExited(MouseEvent e) {
				jLabel.setBackground(new Color(46, 139, 87));
				jLabel.repaint();
				Cursor c = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(c);
			}

			public void mouseEntered(MouseEvent e) {
				jLabel.setBackground(Color.RED);
				jLabel.repaint();
				Cursor c = new Cursor(Cursor.HAND_CURSOR);
				setCursor(c);
			}

			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Isso n�o � um site");
			}
		});
		add(jLabel);
	}
}
