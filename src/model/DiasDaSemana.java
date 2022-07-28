package model;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class DiasDaSemana {
	
	public static DayOfWeek[] dias(String[] diasDaSemana) {
		
		DayOfWeek[] dias = new DayOfWeek[diasDaSemana.length];
		DayOfWeek day = null;
		String full_name = null;
		
		for (int i = 0; i < diasDaSemana.length; i++) {

			switch (diasDaSemana[i].toLowerCase()	) {

			case "segunda":
				day = DayOfWeek.MONDAY;
				full_name = day.getDisplayName(TextStyle.FULL,  Locale.getDefault());
				dias[i] = day;
				break;
			case "terça":
				day = DayOfWeek.TUESDAY;
				full_name = day.getDisplayName(TextStyle.FULL,  Locale.getDefault());
				dias[i] = day;
				break;
			case "quarta":
				day = DayOfWeek.WEDNESDAY;
				full_name = day.getDisplayName(TextStyle.FULL,  Locale.getDefault());
				dias[i] = day;
				break;
			case "quinta":
				day = DayOfWeek.THURSDAY;
				full_name = day.getDisplayName(TextStyle.FULL,  Locale.getDefault());
				dias[i] = day;
				break;
			case "sexta":
				day = DayOfWeek.FRIDAY;
				full_name = day.getDisplayName(TextStyle.FULL,  Locale.getDefault());
				dias[i] = day;
				break;
			case "sabado":
				day = DayOfWeek.SATURDAY;
				full_name = day.getDisplayName(TextStyle.FULL,  Locale.getDefault());
				dias[i] = day;
				break;
			case "domingo":	
				day = DayOfWeek.SUNDAY;
				full_name = day.getDisplayName(TextStyle.FULL,  Locale.getDefault());
				dias[i] = day;
				break;
			}
		}
		for(DayOfWeek dia: dias)
			System.out.println(dia);
		return dias;
	}
}
