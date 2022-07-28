package ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CentralDeInformacoes;
import model.GeradorDeRelatorio;
import model.Persistencia;
import personalizedMessage.MensagemPDF;
import tela.TelaDeMenu;
import tela.TelaGerarPDF;

public class OuvinteTelaGerarPDF implements ActionListener {

	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	
	public TelaGerarPDF telaGerarPDF;
	
	public TelaGerarPDF getTelaGerarPDF() {
		return telaGerarPDF;
	}
	
	public OuvinteTelaGerarPDF(TelaGerarPDF tela) {
		this.telaGerarPDF = tela;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		
		telaGerarPDF.dispose();
		new TelaDeMenu(null);
	}

	public void actionPerformedGerarPDF(ActionEvent e) {
		GeradorDeRelatorio.obterProgramacaoDeUmCanal(centralDeInformacoes.getTodosOsProgramas());
		MensagemPDF.PDFCriado();
	}
}
