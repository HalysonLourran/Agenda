package entity;

import enuns.TipoDeCanal;

public class Canal implements Comparable<Canal> {

	private String nome;
	private TipoDeCanal tipoDoCanal;
	private String linkOuCanal;
	private long id;
	private int contador = 0;
	

	public Canal(String nome, TipoDeCanal tipoDoCanal, String canalOuLink) {
		this.nome = nome;
		this.tipoDoCanal = tipoDoCanal;
		this.linkOuCanal = canalOuLink;
		this.id = System.currentTimeMillis();
	}

	public String toString() {
		return "Canal: " + this.nome + "\n" + "Tipo Do Canal: " + this.tipoDoCanal + "\n"
				+ "Link Ou Numero Do Canal: " + this.linkOuCanal + "\n" + "ID: " + this.id;
	}
	
	public void conta(int number) {
		contador += number;
	}

	public boolean equals(Canal canal) {
		if (canal.getNome().equals(nome)) {
			return true;
		}
		return false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoDeCanal getTipoDoCanal() {
		return tipoDoCanal;
	}

	public void setTipoDoCanal(TipoDeCanal tipoDoCanal) {
		this.tipoDoCanal = tipoDoCanal;
	}

	public String getLinkOuCanal() {
		return linkOuCanal;
	}

	public void setLinkOuCanal(String linkOuCanal) {
		this.linkOuCanal = linkOuCanal;
	}

	public long getId() {
		return id;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	@Override
	public int compareTo(Canal canal) {
		return nome.compareTo(canal.getNome());
	}
}
