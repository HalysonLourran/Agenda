package ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entity.Usuario;
import model.CentralDeInformacoes;
import model.Persistencia;
import personalizedMessage.MensagemException;
import personalizedMessage.MensagemUsuario;
import tela.TelaAgendaDePrograma;
import tela.TelaCadastroDeProgramaContinuo;
import tela.TelaCadastroDeProgramaDeRealityShows;
import tela.TelaCadastroDeProgramaSeriesRegulares;
import tela.TelaDeCadastroDeCanal;
import tela.TelaDeMenu;
import tela.TelaEnviarEmail;
import tela.TelaGerarPDF;
import tela.TelaListarTodosOsCanal;
import tela.TelaListarTodosOsProgramas;

public class OuvinteTelaDeMenu implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	private TelaDeMenu telaDeMenu;

	public TelaDeMenu getTelaDeMenu() {
		return telaDeMenu;
	}

	public OuvinteTelaDeMenu(TelaDeMenu tela) {
		this.telaDeMenu = tela;
	}

	public void actionPerformed(ActionEvent clique) {

		String comando = clique.getActionCommand();
		if (comando.equals("Cadastrar Canal")) {
			
			telaDeMenu.dispose();
			new TelaDeCadastroDeCanal(null);

		} else if (comando.equals("Listar Canal")) {
			
			telaDeMenu.dispose();
			new TelaListarTodosOsCanal(null);
	
		} else if (comando.equals("Cadastrar Programas")) {

			String[] opercao = { "Programa Séries Regulares", "Programa De RealityShows", "Programa Continuo" };
			String entrada = (String) JOptionPane.showInputDialog(null, "Qual Tipo De Programa Você Deseja Cadastrar: ",
					"", JOptionPane.WARNING_MESSAGE, null, opercao, opercao[0]);
			if (opercao[0] == entrada) {
				
				telaDeMenu.dispose();
				new TelaCadastroDeProgramaSeriesRegulares(null);
				
			} else if (opercao[1] == entrada) {
				
				telaDeMenu.dispose();
                new TelaCadastroDeProgramaDeRealityShows(null);
			
			} else {
				
				telaDeMenu.dispose();
				new TelaCadastroDeProgramaContinuo(null);
				
			}
					
		} else if (comando.equals("Listar Programas")) {
			
			telaDeMenu.setVisible(false);
			new TelaListarTodosOsProgramas(null);
			
		} else if (comando.equals("Gerar PDF")) {
			
			telaDeMenu.dispose();
			new TelaGerarPDF(null);
			
		} else if(comando.equals("Minha Agenda")) {
			
			telaDeMenu.dispose();
			new TelaAgendaDePrograma(null);
			

		} else if(comando.equals("Enviar Minha Agenda Por Email")) {
			
			telaDeMenu.dispose();
			new TelaEnviarEmail(null);
			
		} else if(comando.equals("Sair")) {
			System.exit(0);	
		}
	}

	public void actionPerformedExcluir(ActionEvent clique) {

		try {

			String nome = JOptionPane.showInputDialog("informe o nome:");
			Usuario usuario = centralDeInformacoes.recuperarUsuario(nome);

			if (usuario != null) {
				centralDeInformacoes.excluirUsuario(usuario);
				centralDeInformacoes.excluirAgendaSemUsuario();
				MensagemUsuario.usuarioExcluir();
				persistencia.salvarCentral(centralDeInformacoes);
				System.exit(0);
			} else {
				MensagemUsuario.usuarioNaoEncontrado();
			}

		} catch (NullPointerException e) {
			MensagemException.nullPointerException(e);
		}
	}
}
