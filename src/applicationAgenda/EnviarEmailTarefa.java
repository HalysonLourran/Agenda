package applicationAgenda;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import enuns.StatusDeExebicao;
import model.CentralDeInformacoes;
import model.Mensageiro;
import model.Persistencia;
import personalizedMessage.MensagemException;

public class EnviarEmailTarefa extends TimerTask {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	@SuppressWarnings("static-access")
	@Override
	public void run() {

		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("hh:m");
		String hora = formatar.format(date);
		StatusDeExebicao status = StatusDeExebicao.EXIBICAO;

		try {
			for (int i = 0; i < centralDeInformacoes.getTodasAsAgendas().size(); i++) {

				if (status.equals(centralDeInformacoes.getTodasAsAgendas().get(i).getStatusDeExebicao().EXIBICAO)
						&& hora.equals(centralDeInformacoes.getTodasAsAgendas().get(i).getHorario())) {

					Mensageiro.enviarProgramacaoDeHoje("Vai começar",
							centralDeInformacoes.getTodosOsUsuarios().get(0).getEmail(),
							"Prepare sua Pipoca" + "\n" + centralDeInformacoes.getTodasAsAgendas().get(i).toString());	
				} // end if
			} // end for
		} catch (Exception e) {
           MensagemException.exception(e);
		}
	} // end void run
} // end class
