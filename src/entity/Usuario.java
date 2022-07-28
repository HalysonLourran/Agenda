package entity;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nome;
	private String email;
	private String senha;
	private long id;
	private List<Programa> minhaAgenda = new ArrayList<>();

	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.id = System.currentTimeMillis();
	}

	public String toString() {
		return "Nome: " + this.nome + " Email: " + this.email + " Senha: " + this.senha + " ID: " + this.id +
				"Minha Agenda: " + this.minhaAgenda;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Programa> getMinhaAgenda() {
		return minhaAgenda;
	}

	public void setMinhaAgenda(List<Programa> minhaAgenda) {
		this.minhaAgenda = minhaAgenda;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
}
