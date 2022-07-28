package model;

import entity.Usuario;

public class ValidacaoDeCadastroDeUsuario {

	public void validarEmail(Usuario usuario) throws Exception {

		if (!usuario.getEmail().contains("@")) {
			throw new Exception("Seu Email não tem o @");
		}

		if (!usuario.getEmail().contains(".com")) {
			throw new Exception("Seu Email não tem o .com");
		}
	}

	public void validarSenha(Usuario usuario) throws Exception {

		if (!temLetraMaiuscula(usuario.getSenha())) {
			throw new Exception("As senhas tem que ter uma ou mais caracter com letras Maiúsculas");
		}

		if (!temLetraMinuscula(usuario.getSenha())) {
			throw new Exception("As senhas tem que ter uma ou mais caracter com letras Minúsculas");
		}

		if (usuario.getSenha().contains(" ")) {
			throw new Exception("Sua senha não pode ter espaço em branco.");
		}
	}
	
	public void validarNome(Usuario usuario) throws Exception {
		
		if(isNumber(usuario)) {
			throw new Exception("Não é permitido nome de usuário com apenas número.");
		}
		
	}
	
	public boolean isNumber(Usuario usuario) {

		try {
			Integer.parseInt(usuario.getNome());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean temLetraMaiuscula(String senha) {

		for (int i = 0; i < senha.length(); i++) {
			if (Character.isUpperCase(senha.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	public boolean temLetraMinuscula(String senha) {

		for (int i = 0; i < senha.length(); i++) {
			if (Character.isLowerCase(senha.charAt(i))) {
				return true;
			}
		}
		return false;
	}
}
