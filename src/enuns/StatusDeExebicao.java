package enuns;

public enum StatusDeExebicao {
	EXIBICAO("Exibição"), 
	HIATO("Hiato"),
	FINALIZADO("Finalizado"),
	CANCELADO("Cancelado");	
	
	public String status;
	StatusDeExebicao(String status) {
		this.status = status;
	}
}
