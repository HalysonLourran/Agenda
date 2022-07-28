package ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entity.Canal;
import enuns.TipoDeCanal;
import model.CentralDeInformacoes;
import model.Persistencia;
import model.ValidacaoDeCadastroDeCanal;
import personalizedMessage.MensagemCanal;
import personalizedMessage.MensagemException;
import tela.TelaDeCadastroDeCanal;
import tela.TelaDeMenu;

public class OuvinteTelaDeCadastroDeCanal implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	private TelaDeCadastroDeCanal telaDeCadastroDeCanal;

	public TelaDeCadastroDeCanal getTelaDeCadastroDeCanal() {
		return telaDeCadastroDeCanal;
	}

	public OuvinteTelaDeCadastroDeCanal(TelaDeCadastroDeCanal tela) {
		this.telaDeCadastroDeCanal = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		telaDeCadastroDeCanal.dispose();
		new TelaDeMenu(null);

	} // end actionPerformed

	public void actionPerformedsalvar(ActionEvent e) {

		String nome = telaDeCadastroDeCanal.getCampoNome().getText();
		String canalOuLink = telaDeCadastroDeCanal.getCampoLinkNumero().getText();

		String[] status = { "canal aberto de televisão", "broadcasting aberto na internet", "pacote de assinatura",
				"assinatura individual de televisão", "assinatura individual de broadcasting" };
		String entradaStatus = (String) JOptionPane.showInputDialog(null, "Status De Exebição: ", "",
				JOptionPane.WARNING_MESSAGE, null, status, status[0]);

		TipoDeCanal exebicao = null;

		if (status[0] == entradaStatus) {
			exebicao = TipoDeCanal.CANAL_ABERTO_DE_TELEVISAO;
		} else if (status[1] == entradaStatus) {
			exebicao = TipoDeCanal.BROADCASTING_ABERTO_NA_INTERNET;
		} else if (status[2] == entradaStatus) {
			exebicao = TipoDeCanal.PACOTE_DE_ASSINATURA;
		} else if (status[3] == entradaStatus) {
			exebicao = TipoDeCanal.ASSINATURA_INDIVIDUAL_DE_TELEVISAO;
		} else {
			exebicao = TipoDeCanal.ASSINATURA_INDIVIDUAL_DE_BROADCASTING;
		} // end else

		Canal canal = new Canal(nome, exebicao, canalOuLink);
		ValidacaoDeCadastroDeCanal cadastroDeCanal = new ValidacaoDeCadastroDeCanal();
		
		try {

			if (canal.getTipoDoCanal().equals(TipoDeCanal.ASSINATURA_INDIVIDUAL_DE_TELEVISAO)
					|| canal.getTipoDoCanal().equals(TipoDeCanal.CANAL_ABERTO_DE_TELEVISAO)) {

				cadastroDeCanal.testeCanal(canal);
				
			} else {
				cadastroDeCanal.testeCanalLink(canal);
			} // end else
			
			cadastroDeCanal.campoVazio(canal);

			centralDeInformacoes.salvarCanal(canal);
			persistencia.salvarCentral(centralDeInformacoes);
			MensagemCanal.canalSalvo();
			telaDeCadastroDeCanal.dispose();
			new TelaDeCadastroDeCanal(null);
			
		} catch (Exception erro) {
			MensagemException.exception(erro);
		} // catch
	} // end if
} // end class
