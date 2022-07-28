package model;

import java.util.ArrayList;
import java.util.List;

import entity.Canal;
import entity.Programa;
import entity.Usuario;

public class CentralDeInformacoes {

	private List<Programa> todosOsProgramas = new ArrayList<Programa>();
	private List<Canal> todosOsCanais = new ArrayList<Canal>();
	private List<Usuario> todosOsUsuarios = new ArrayList<Usuario>();
	private List<Programa> todasAsAgendas = new ArrayList<>();

	public boolean adicionarProgramaDeTV(Programa programa) {
		Programa programas = this.recuperarProgramaDeTVporId(programa.getId());

		if (programas != null) {
			return false;
		}
		this.todosOsProgramas.add(programa);
		return true;
	}

	public Programa recuperarProgramaDeTVporId(long id) {
		for (int i = 0; i < todosOsProgramas.size(); i++) {
			if (todosOsProgramas.get(i).getId() == id) {
				return todosOsProgramas.get(i);
			}
		}
		return null;
	}

	public boolean excluirPrograma(Programa programa) {
		if (todosOsProgramas.contains(programa)) {
			todosOsProgramas.remove(programa);
			return true;
		}
		return false;
	}

	public void salvarCanal(Canal canal) throws Exception {
		Canal canalNome = this.recuperarCanal(canal.getNome());
		if (canalNome != null) {
			throw new Exception("Já Existe Um Canal Com Este Nome!");
		}
		todosOsCanais.add(canal);
	}

	public Canal recuperarCanal(String nome) {
		for (int i = 0; i < todosOsCanais.size(); i++) {
			if (todosOsCanais.get(i).getNome().equals(nome)) {
				return todosOsCanais.get(i);
			}
		}
		return null;
	}

	public boolean excluirCanal(Canal canal) {
		if (todosOsCanais.contains(canal)) {
			todosOsCanais.remove(canal);
			return true;
		}
		return false;
	}

	public Canal recuperarCanalId(long id) {
		for (int i = 0; i < todosOsCanais.size(); i++) {
			if (todosOsCanais.get(i).getId() == id) {
				return todosOsCanais.get(i);
			}
		}
		return null;
	}

	public boolean salvarUsuario(Usuario usuario) {
		for (int i = 0; i < todosOsUsuarios.size(); i++) {
			if (todosOsUsuarios.get(i).getNome().equals(usuario.getNome())) {
				return false;
			}
		}
		todosOsUsuarios.add(usuario);
		return true;
	}

	public Usuario recuperarUsuario(String nome) {
		for (int i = 0; i < todosOsUsuarios.size(); i++) {
			if (todosOsUsuarios.get(i).getNome().equals(nome)) {
				return todosOsUsuarios.get(i);
			}
		}
		return null;
	}

	public boolean excluirUsuario(Usuario usuario) {
		if (todosOsUsuarios.contains(usuario)) {
			todosOsUsuarios.remove(usuario);
			return true;
		}
		return false;
	}

	public boolean isLogin(String email, String senha) {
		for (int i = 0; i < todosOsUsuarios.size(); i++) {
			if (todosOsUsuarios.get(i).getEmail().equals(email) && todosOsUsuarios.get(i).getSenha().equals(senha)) {
				return true;
			}
		}
		return false;
	}

	public boolean AdicionarAgenda(Programa programaDeTV) {
		for (int i = 0; i < todasAsAgendas.size(); i++) {
			if (todasAsAgendas.get(i).getId() == programaDeTV.getId()) {
				return false;
			}
		}
		todasAsAgendas.add(programaDeTV);
		return true;
	}

	public boolean excluirAgenda(Programa programaDeTV) {
		if (todasAsAgendas.contains(programaDeTV)) {
			todasAsAgendas.remove(programaDeTV);
			return true;
		}
		return false;
	}

	public Programa recuperarAgenda(long id) {
		for (int i = 0; i < todasAsAgendas.size(); i++) {
			if (todasAsAgendas.get(i).getId() == id) {
				return todasAsAgendas.get(i);
			}
		}
		return null;
	}

	public void excluirAgendaSemUsuario() {
		for (int i = 0; i < todasAsAgendas.size(); i++) {
			if (todasAsAgendas.get(i) != null) {
				todasAsAgendas.remove(i);
			}
		}
	}

	public List<Canal> getTodosOsCanais() {
		return todosOsCanais;
	}

	public void setTodosOsCanais(ArrayList<Canal> todosOsCanais) {
		this.todosOsCanais = todosOsCanais;
	}

	public List<Usuario> getTodosOsUsuarios() {
		return todosOsUsuarios;
	}

	public void setTodosOsUsuarios(ArrayList<Usuario> todosOsUsuarios) {
		this.todosOsUsuarios = todosOsUsuarios;
	}

	public List<Programa> getTodasAsAgendas() {
		return todasAsAgendas;
	}

	public void setTodasAsAgendas(List<Programa> todasAsAgendas) {
		this.todasAsAgendas = todasAsAgendas;
	}

	public List<Programa> getTodosOsProgramas() {
		return todosOsProgramas;
	}

	public void setTodosOsProgramasSeriesRegulares(List<Programa> todosOsProgramas) {
		this.todosOsProgramas = todosOsProgramas;
	}
}