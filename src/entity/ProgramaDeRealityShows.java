package entity;

import java.time.DayOfWeek;
import java.util.Date;

import enuns.StatusDeExebicao;
import enuns.TipoDePrograma;

public class ProgramaDeRealityShows extends Programa {

	private String nomeDosApresentadores;
	private String temporada;

	public ProgramaDeRealityShows(String nome, String apresentador, StatusDeExebicao exebicao, Canal canal,
			DayOfWeek[] dias, String horario, Date data, String temporada) {

		this.setTipoDePrograma(TipoDePrograma.REALITY_SHOWS);
		this.setNome(nome);
		this.nomeDosApresentadores = apresentador;
		this.setStatusDeExebicao(exebicao);
		this.setCanal(canal);
		this.setDiasDaSemana(dias);
		this.setHorario(horario);
		this.setDataHiato(data);
		this.temporada = temporada;
		this.setId(System.currentTimeMillis());
	}

	@Override
	public String toString() {
		return "Tipo De Programa: " + this.getTipoDePrograma() + "\n" + "Nome Do Programa: " + this.getNome() + "\n"
				+ "Apresentador: " + this.getNomeDosApresentadores() + "\n" + "Status De Exebição: "
				+ this.getStatusDeExebicao() + "\n" + "Canal: " + this.getCanal() + "\n" + "Dias Da Semana: "
				+ this.getDiasDaSemana() + "\n" + "Horario: " + this.getHorario() + "Data: " + this.getDataHiato() + "\n"
				+ "Temporada: " + this.getTemporada() + "\n" + "ID: " + this.getId();
	}

	public String getNomeDosApresentadores() {
		return nomeDosApresentadores;
	}

	public void setNomeDosApresentadores(String nomeDosApresentadores) {
		this.nomeDosApresentadores = nomeDosApresentadores;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
}
