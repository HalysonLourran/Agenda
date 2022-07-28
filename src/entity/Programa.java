package entity;

import java.time.DayOfWeek;
import java.util.Date;

import enuns.StatusDeExebicao;
import enuns.TipoDePrograma;

public abstract class Programa {

	private String nome;
	private long id;
	private Canal canal;
	private String horario;
	private TipoDePrograma tipoDePrograma;
	private StatusDeExebicao statusDeExebicao;
	private Date dataHiato;
	private DayOfWeek [] diasDaSemana;

	public abstract String toString();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public long getId() {
		return id;
	}
	
	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public void setId(long id) {
		this.id = id;
	}

	public StatusDeExebicao getStatusDeExebicao() {
		return statusDeExebicao;
	}

	public void setStatusDeExebicao(StatusDeExebicao statusDeExebicao) {
		this.statusDeExebicao = statusDeExebicao;
	}

	public Date getDataHiato() {
		return dataHiato;
	}

	public void setDataHiato(Date dataHiato) {
		this.dataHiato = dataHiato;
	}

	public TipoDePrograma getTipoDePrograma() {
		return tipoDePrograma;
	}

	public void setTipoDePrograma(TipoDePrograma tipoDePrograma) {
		this.tipoDePrograma = tipoDePrograma;
	}

	public DayOfWeek[] getDiasDaSemana() {
		return diasDaSemana;
	}

	public void setDiasDaSemana(DayOfWeek[] diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
	}
}
