package model;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AdicionarJLabel extends JLabel {
	
	public JLabel adicionarJLabel(String nomeCampo, int x, int y, int z, int w) {
		
		JLabel nome = new JLabel(nomeCampo);
		nome.setBounds(x, y, z, w);
		nome.setFont(Util.font);
	    nome.setOpaque(true);
		nome.setBackground(new Color(46,139,87));
		nome.setForeground(Color.WHITE);
		
		nome.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				nome.setBackground(new Color(46, 139, 87));
				nome.repaint();
				Cursor c = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(c);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				nome.setBackground(Color.RED);
				nome.repaint();
				Cursor c = new Cursor(Cursor.HAND_CURSOR);
				setCursor(c);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Preencha os Campos");
			}
		});
		return (JLabel) add(nome);	
	}
}
