package application;

import entity.Programa;
import enuns.TipoDeCanal;
import model.CentralDeInformacoes;
import model.Persistencia;
import tela.TelaDeCadastroDeUsuario;
import tela.TelaDeLogin;

public class Main {

	public static void main(String[] args) {

		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
		for(Programa p : centralDeInformacoes.getTodasAsAgendas()) {
			System.out.println(p);
		}

		if (centralDeInformacoes.getTodosOsUsuarios().size() > 0) {
			new TelaDeLogin(null);
		} else {
			new TelaDeCadastroDeUsuario(null);
		}
	}
}

/*
 * DayOfWeek[] dias = new DayOfWeek[6]; DayOfWeek day = null;
 * 
 * Scanner leitor = new Scanner(System.in);
 * System.out.println("Informe os dias da semana separada por vírgula:"); String
 * diasDaSemana[] = leitor.nextLine().split(", ");
 * 
 * for (int i = 0; i < diasDaSemana.length; i++) {
 * 
 * switch (diasDaSemana[i].toLowerCase() ) {
 * 
 * case "segunda": day = DayOfWeek.of(1); dias[i] = day; break; case "terça":
 * day = DayOfWeek.of(2); dias[i] = day; break; case "quarta": day =
 * DayOfWeek.of(3); dias[i] = day; break; case "quinta": day = DayOfWeek.of(4);
 * dias[i] = day; break; case "sexta": day = DayOfWeek.of(5); dias[i] = day;
 * break; case "sabado": day = DayOfWeek.of(6); dias[i] = day; break; case
 * "domingo": day = DayOfWeek.of(7); dias[i] = day; break; } }
 * 
 * for (DayOfWeek diasDa : dias) { System.out.println(diasDa.name()); }
 * 
 * leitor.close();
 */