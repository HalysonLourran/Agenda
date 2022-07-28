package applicationAgenda;

import java.util.Calendar;
import java.util.Date;

import entity.Programa;
import enuns.StatusDeExebicao;
import model.CentralDeInformacoes;
import model.Persistencia;
import model.StatusHiato;
import personalizedMessage.MensagemAgenda;

public class Hiato implements Runnable {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	public Date getData(Date aDate) {
		
		final Calendar myCalendar = Calendar.getInstance();
		myCalendar.setTime(aDate);
		myCalendar.set(Calendar.HOUR_OF_DAY, 0);
		myCalendar.set(Calendar.MINUTE, 0);
		myCalendar.set(Calendar.SECOND, 0);
		myCalendar.set(Calendar.MILLISECOND, 0);
		return myCalendar.getTime();
	} // end Date

	@Override
	public void run() {
		
		Date hiato = new Date();

		for (int i = 0; i < centralDeInformacoes.getTodasAsAgendas().size(); i++) {
			
			if (getData(hiato).equals(centralDeInformacoes.getTodasAsAgendas().get(i).getDataHiato())  
					&& centralDeInformacoes.getTodasAsAgendas().get(i).getStatusDeExebicao().equals(StatusDeExebicao.HIATO)) {
				
				MensagemAgenda.hiatoHoje(hiato, centralDeInformacoes.getTodasAsAgendas().get(i));
				Programa p = centralDeInformacoes.getTodasAsAgendas().get(i);
				
				StatusHiato status = new StatusHiato();
				StatusDeExebicao statusFinal = status.statusDeExebicao();
				
				p.setStatusDeExebicao(statusFinal);
				if(status.getData() != null) {
					p.setDataHiato(status.getData());
				} // end if
				persistencia.salvarCentral(centralDeInformacoes);
			} // end if
		} // end for	
	} // end run
} // end class
