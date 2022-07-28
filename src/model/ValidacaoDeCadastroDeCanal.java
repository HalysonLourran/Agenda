package model;

import entity.Canal;

public class ValidacaoDeCadastroDeCanal {
	
	public void campoVazio(Canal canal) throws Exception {
		if(canal.getNome().isBlank() || canal.getLinkOuCanal().isBlank()) {
			throw new Exception("Existe campo/s vazio/s!");
		}
	}
	
	public void testeCanal(Canal canal) throws Exception {
		if(!isCanalDeTelevisao(canal)) {
			throw new Exception("Canal de Televisão se deve colocar número do canal");
		}
	}
	
	public void testeCanalLink(Canal canal) throws Exception {
		
		if(!canal.getLinkOuCanal().contains("www.")) {
			throw new Exception("Esse Tipo De Canal Não Pode ter número. Deve ter link!");
		}
		
		if(!canal.getLinkOuCanal().contains(".com")) {
			throw new Exception("Esse Tipo De Canal Não Pode ter número. Deve ter link!");
		}
	}
	
	public boolean isCanalDeTelevisao(Canal canal) {

		try {
			Integer.parseInt(canal.getLinkOuCanal());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
