package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import entity.Canal;
import janelas.JanelaTelaCadastroDePrograma;
import model.AdicionarJLabel;
import model.CentralDeInformacoes;
import model.Persistencia;
import model.SorteioDeTelaImagens;
import model.Util;
import ouvinte.OuvinteTelaDeCadastroDeProgramaContinuo;

public class TelaCadastroDeProgramaContinuo extends JanelaTelaCadastroDePrograma {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	OuvinteTelaDeCadastroDeProgramaContinuo ouvinte = new OuvinteTelaDeCadastroDeProgramaContinuo(this);

	private JTextField campoNomeDoPrograma;
	private JTextField campoIDCanal;
	private JTextField campoDiasDaSemana;
	private JTextField campoApresentador;
	private JFormattedTextField campoHorario;
	private JButton buttonVoltar;
	private JButton buttonSalvar;
	private ImageIcon iconButtons;

	public TelaCadastroDeProgramaContinuo(String titulo) {
		super(titulo);
		adicionarJLabel();
		adicionarJTextFild();
		adicionarButtonVoltar();
		adicionarButtonSalvar();
		adicionarImagem();
		setVisible(true);
	}

	private void adicionarJLabel() {

		AdicionarJLabel nomeDoApresentador = new AdicionarJLabel();
		add(nomeDoApresentador.adicionarJLabel("Nome Do Apresentador:", 40, 500, 240, 30));
	}

	private void adicionarJTextFild() {

		campoNomeDoPrograma = new JTextField();
		campoNomeDoPrograma.setBounds(300, 300, 200, 30);
		add(campoNomeDoPrograma);

		campoIDCanal = new JTextField();
		campoIDCanal.setBounds(300, 350, 200, 30);
		add(campoIDCanal);

		campoDiasDaSemana = new JTextField();
		campoDiasDaSemana.setBounds(300, 400, 200, 30);
		add(campoDiasDaSemana);

		try {
			campoHorario = new JFormattedTextField(new MaskFormatter("##:##"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		campoHorario.setBounds(300, 450, 70, 30);
		add(campoHorario);

		campoApresentador = new JTextField();
		campoApresentador.setBounds(300, 500, 200, 30);
		add(campoApresentador);

	}

	private void adicionarButtonVoltar() {
		iconButtons = new ImageIcon("icones/IconeVoltar.png");
		buttonVoltar = new JButton("Voltar",iconButtons);
		buttonVoltar.setBounds(40, 600, 130, 33);
		buttonVoltar.addActionListener(voltar());
		buttonVoltar.setBackground(new Color(46, 139, 87));
		buttonVoltar.setForeground(Color.WHITE);
		buttonVoltar.setFont(Util.font);
		add(buttonVoltar);

	}

	public ActionListener voltar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
			}
		};
	}

	private void adicionarButtonSalvar() {
		iconButtons = new ImageIcon("icones/IconeSalvar.png");
		buttonSalvar = new JButton("Salvar",iconButtons);
		buttonSalvar.setBounds(720, 600, 130, 33);
		buttonSalvar.addActionListener(salvar());
		buttonSalvar.setBackground(new Color(46, 139, 87));
		buttonSalvar.setForeground(Color.WHITE);
		buttonSalvar.setFont(Util.font);
		add(buttonSalvar);
	}

	public ActionListener salvar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ouvinte.actionPerformedSalvar(e);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		};
	}
	
	public void adicionarImagem() {

		SorteioDeTelaImagens sorteioDeTelaImagens = new SorteioDeTelaImagens();

		JLabel imagem = new JLabel();
		imagem.setIcon(new ImageIcon(sorteioDeTelaImagens.sorteioDeTelasGrandes()));
		imagem.setBounds(0, 30, 1200, 700);
		add(imagem);
	}

	public JTextField getCampoNomeDoPrograma() {
		return campoNomeDoPrograma;
	}

	public JTextField getCampoIDCanal() {
		return campoIDCanal;
	}

	public JTextField getCampoDiasDaSemana() {
		return campoDiasDaSemana;
	}

	public JFormattedTextField getCampoHorario() {
		return campoHorario;
	}

	public JButton getButtonVoltar() {
		return buttonVoltar;
	}

	public JButton getButtonSalvar() {
		return buttonSalvar;
	}

	public JTextField getCampoApresentador() {
		return campoApresentador;
	}

}