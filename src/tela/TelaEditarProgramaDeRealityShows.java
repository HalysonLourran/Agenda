package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import entity.ProgramaDeRealityShows;
import janelas.JanelaTelaCadastroDePrograma;
import model.AdicionarJLabel;
import model.CentralDeInformacoes;
import model.Persistencia;
import model.Util;
import ouvinte.OuvinteTelaEditarProgramaDeRealityShows;

public class TelaEditarProgramaDeRealityShows extends JanelaTelaCadastroDePrograma {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	OuvinteTelaEditarProgramaDeRealityShows ouvinte = new OuvinteTelaEditarProgramaDeRealityShows(this);

	private JTextField campoNomeDoPrograma;
	private JTextField campoIDCanal;
	private JTextField campoDiasDaSemana;
	private JTextField campoApresentador;
	private JTextField campoTemporada;
	private JFormattedTextField campoHorario;
	private JButton buttonVoltar;
	private JButton buttonSalvar;
	private ProgramaDeRealityShows programaDeRealityShows;
	private JTextField campoIDPrograma;
	private ImageIcon iconButtons;

	public TelaEditarProgramaDeRealityShows(String titulo, ProgramaDeRealityShows programaDeRealityShows) {
		super(titulo);
		this.programaDeRealityShows = programaDeRealityShows;
		adicionarTitulo();
		adicionarJLabel();
		adicionarJTextFild();
		adicionarButtonVoltar();
		adicionarButtonSalvar();
		setVisible(true);
	}

	private void adicionarTitulo() {

		ImageIcon icon = new ImageIcon("src/Imagens/cats-removebg-preview.png");
		JLabel jLabel = new JLabel("CADASTRO DE PROGRAMA", icon, JLabel.CENTER);
		jLabel.setBounds(0, 0, 900, 70);
		jLabel.setFont(Util.fontTitulo);
		jLabel.setOpaque(true);
		jLabel.setBackground(new Color(46, 139, 87));
		jLabel.setForeground(Color.WHITE);
		add(jLabel);
	}

	private void adicionarJLabel() {

		AdicionarJLabel nomeDoApresentador = new AdicionarJLabel();
		add(nomeDoApresentador.adicionarJLabel("Nome Do Apresentador:", 40, 500, 240, 30));

		AdicionarJLabel temporada = new AdicionarJLabel();
		add(temporada.adicionarJLabel("Temporada:", 40, 550, 240, 30));
	}

	private void adicionarJTextFild() {

		campoNomeDoPrograma = new JTextField();
		campoNomeDoPrograma.setBounds(300, 300, 200, 30);
		campoNomeDoPrograma.setText(this.programaDeRealityShows.getNome());
		add(campoNomeDoPrograma);

		campoIDCanal = new JTextField();
		campoIDCanal.setBounds(300, 350, 200, 30);
		campoIDCanal.setText(String.valueOf(this.programaDeRealityShows.getCanal().getId()));
		add(campoIDCanal);

		campoDiasDaSemana = new JTextField();
		campoDiasDaSemana.setBounds(300, 400, 200, 30);
		campoDiasDaSemana.setText(String.valueOf(this.programaDeRealityShows.getDiasDaSemana()));
		add(campoDiasDaSemana);

		try {
			campoHorario = new JFormattedTextField(new MaskFormatter("##:##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		campoHorario.setBounds(300, 450, 70, 30);
		campoHorario.setText(this.programaDeRealityShows.getHorario());
		add(campoHorario);

		campoApresentador = new JTextField();
		campoApresentador.setBounds(300, 500, 200, 30);
		campoApresentador.setText(this.programaDeRealityShows.getNomeDosApresentadores());
		add(campoApresentador);

		campoTemporada = new JTextField();
		campoTemporada.setBounds(300, 550, 200, 30);
		campoTemporada.setText(this.programaDeRealityShows.getTemporada());
		add(campoTemporada);

		campoIDPrograma = new JTextField();
		campoIDPrograma.setText(String.valueOf(this.programaDeRealityShows.getId()));
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
				ouvinte.actionPerformedSalvar(e);
			}
		};
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

	public JTextField getCampoTemporada() {
		return campoTemporada;
	}

	public JTextField getCampoIDPrograma() {
		return campoIDPrograma;
	}
}
