package model;

import java.util.Random;

public class SorteioDeTelaImagens {

	public String sorteioDeTela() {

		String imagens[] = {"FotosDeFundoGrande/FotosFundo1.png.jpg","FundoDeTela/pipocaFilme.jpeg","FundoDeTela/imagensDEFilmes.png", "FundoDeTela/foto01.png"};

		int numero = new Random().nextInt(3);
		String sorteio = imagens[numero];
		return sorteio;
	}

	public String sorteioDeTelasGrandes() {
		String imagensGrandes [] = {"FotosDeFundoGrande/Fotofundo.png.jpg","FotosDeFundoGrande/FotoFubdo(3).png.png",};
		
		int numero = new Random().nextInt(2);
		String sorteio = imagensGrandes[numero];
		return sorteio;

	}
	
	
	
	// Cadastros de programas, listar todos os programas
	
	
}
