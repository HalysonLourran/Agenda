package personalizedMessage;

import java.util.Date;

import javax.swing.JOptionPane;

import entity.Programa;

public class MensagemAgenda {
	
	public static void adicionarNaMinhaAgenda() {
		JOptionPane.showMessageDialog(null, "Programa adicionado na sua Agenda com sucesso");
	}
	
	public static void removerDaMinhaAgenda() {
		JOptionPane.showMessageDialog(null, "Programa removido com sucesso");
	}
	
	public static void programaNaoEncontrada() {
		JOptionPane.showMessageDialog(null, "programa não encontrado");
	}
	
	public static void detalhar(Programa programaDeTV) {
		JOptionPane.showMessageDialog(null, programaDeTV.toString());
	}
	
	public static void hiatoHoje(Date date, Programa programaDeTV) {
		JOptionPane.showMessageDialog(null, "Existe um programa seu em Hiato " + date + " você pode mudar o status para em andamento. " 
				+ programaDeTV);
	}
	
	public static void programaJaExisteNaSuaAgenda() {
		JOptionPane.showMessageDialog(null, "Esse Programa já existe na sua Agenda!");
	}

}
