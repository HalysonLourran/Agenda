package entity;

import java.time.DayOfWeek;
import java.util.Date;

import enuns.StatusDeExebicao;
import enuns.TipoDePrograma;

public class ProgramaContinuo extends Programa{

	private String nomeDosApresentadoroes;
	
	public ProgramaContinuo () {
		
	}
	
	public ProgramaContinuo(String nome, String nomeApresentador, StatusDeExebicao status, Canal canal, 
			DayOfWeek[] dias, String horario, Date data) {
		
		this.setTipoDePrograma(TipoDePrograma.PROGRAMAS_CONTINUOS);
		this.setNome(nome);
		this.nomeDosApresentadoroes = nomeApresentador;
		this.setStatusDeExebicao(status);
		this.setCanal(canal);
		this.setDiasDaSemana(dias);
		this.setHorario(horario);
		this.setDataHiato(data);
		this.setId(System.currentTimeMillis());
	}
	
	public String toString() {
		return "Tipo De Programa: " + this.getTipoDePrograma() + "\n" + 
	      "Nome Do Programa: " + this.getNome() + "\n" + "Apresentador: " + this.nomeDosApresentadoroes + 
	      "\n" +"Status De Exebição: " + this.getStatusDeExebicao() + "\n" + "Canal: " + this.getCanal() + "\n" + "Dia/s Da Semana/s: " + this.getDiasDaSemana() + "\n" +
	      "Data :" + this.getDataHiato() + "\n" + "ID: " + this.getId();
	}

	public String getNomeDosApresentadores() {
		return nomeDosApresentadoroes;
	}

	public void setNomeDoApresentador(String nomeDosApresentadores) {
		this.nomeDosApresentadoroes = nomeDosApresentadores;
	}
}
