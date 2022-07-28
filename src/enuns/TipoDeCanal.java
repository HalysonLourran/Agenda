package enuns;

public enum TipoDeCanal {

	 CANAL_ABERTO_DE_TELEVISAO("canal aberto de televisão"),
	 BROADCASTING_ABERTO_NA_INTERNET("broadcasting aberto na internet"),
	 PACOTE_DE_ASSINATURA("pacote de assinatura"),
	 ASSINATURA_INDIVIDUAL_DE_TELEVISAO("assinatura individual de televisão"), 
	 ASSINATURA_INDIVIDUAL_DE_BROADCASTING("assinatura individual de broadcasting");
	
	public String valor;
	TipoDeCanal(String string) {
		this.valor = string;
	}
}
