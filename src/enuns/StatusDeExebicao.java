package enuns;

public enum StatusDeExebicao {
	EXIBICAO("Exibi��o"), 
	HIATO("Hiato"),
	FINALIZADO("Finalizado"),
	CANCELADO("Cancelado");	
	
	public String status;
	StatusDeExebicao(String status) {
		this.status = status;
	}
}
