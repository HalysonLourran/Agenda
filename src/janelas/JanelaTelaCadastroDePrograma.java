package janelas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import entity.Canal;
import model.AdicionarJLabel;
import model.CentralDeInformacoes;
import model.Persistencia;
import model.Util;

public class JanelaTelaCadastroDePrograma extends JFrame {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	public JanelaTelaCadastroDePrograma(String titulo) {

		setTitle("Agenda de Séries");
		setSize(900, 700); 
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tituloDaTela();
		listarPrograma();
		adicionarJLabel();
		setResizable(false);
	}

	public void tituloDaTela() {

		ImageIcon icon = new ImageIcon("icones/IconeLogo.png");
		JLabel jLabel = new JLabel("CADASTRO DE PROGRAMA", icon, JLabel.CENTER);
		jLabel.setBounds(0, 0, 900, 70);
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
				JOptionPane.showMessageDialog(null, "Isso não é um site");
			}
		});
		add(jLabel);
	}

	private void listarPrograma() {

		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("ID");
		modelo.addColumn("Nome");
		modelo.addColumn("Tipo De Canal");
		modelo.addColumn("Link Ou Número Do Canal");

		List<Canal> canais = centralDeInformacoes.getTodosOsCanais();

		Collections.sort(canais);

		Object[] linhas = new Object[canais.size()];
		for (Canal canal : canais) {
			Object[] linha = new Object[4];
			linha[0] = canal.getId();
			linha[1] = canal.getNome();
			linha[2] = canal.getTipoDoCanal();
			linha[3] = canal.getLinkOuCanal();
			modelo.addRow(linha);
		}

		JTable tabela = new JTable(modelo);
		tabela.setBackground(Color.green);
		JScrollPane painelTabela = new JScrollPane(tabela);
		painelTabela.setBounds(40, 100, 800, 190);
		add(painelTabela);
	}

	private void adicionarJLabel() {

		AdicionarJLabel nome = new AdicionarJLabel();
		add(nome.adicionarJLabel("Nome Do Programa:", 40, 300, 240, 30));

		AdicionarJLabel idDoCanal = new AdicionarJLabel();
		add(idDoCanal.adicionarJLabel("ID Do Canal:", 40, 350, 240, 30));

		AdicionarJLabel diasDaSemana = new AdicionarJLabel();
		add(diasDaSemana.adicionarJLabel("Dia/s Do Programa:", 40, 400, 240, 30));

		AdicionarJLabel horarioDoPrograma = new AdicionarJLabel();
		add(horarioDoPrograma.adicionarJLabel("Horario Do Programa:", 40, 450, 240, 30));
	}

}
