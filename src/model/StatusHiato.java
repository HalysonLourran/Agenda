package model;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import enuns.EstiloSeriesRegulares;
import enuns.StatusDeExebicao;

public class StatusHiato {

	private Date data;

	public StatusDeExebicao statusDeExebicao() {
		StatusDeExebicao exebicao = null;

		String[] status = { "Exibição", "Hiato", "Finalizado", "Cancelado" };
		String entradaStatus = (String) JOptionPane.showInputDialog(null, "Estilo:", "", JOptionPane.WARNING_MESSAGE,
				null, status, status[0]);

		if (status[0] == entradaStatus) {
			exebicao = StatusDeExebicao.EXIBICAO;
		} else if (status[1] == entradaStatus) {
			exebicao = StatusDeExebicao.HIATO;
			dateHiato();
		} else if (status[2] == entradaStatus) {
			exebicao = StatusDeExebicao.FINALIZADO;
		} else {
			exebicao = StatusDeExebicao.CANCELADO;
		} 
		return exebicao;
	}

	public Date dateHiato() {
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");

		try {
			data = formatar.parse(JOptionPane.showInputDialog("Data de exebição: Separe por barras /. "));
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return data;
	}

	public EstiloSeriesRegulares estiloSeriesRegulares() {
		
		EstiloSeriesRegulares estilo = null;

		String[] opercao = { "Live Action", "Animada" };
		
		String entrada = (String) JOptionPane.showInputDialog(null, "Estilo Dá Séries: ", "",
				JOptionPane.WARNING_MESSAGE, null, opercao, opercao[0]);

		if (opercao[0] == entrada) {
			estilo = EstiloSeriesRegulares.LIVI_ACTION;
		} else {
			estilo = EstiloSeriesRegulares.ANIMADA;
		}
		return estilo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
