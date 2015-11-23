package br.com.caelum.empresa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.caelum.empresa.modelo.Funcionario;
import br.com.caelum.empresa.modelo.Gasto;

public class TestaGasto {
	public static void main(String[] args) {
		Calendar dataNascimento = new GregorianCalendar(1990, 5, 11);
		Calendar dataNascimento2 = new GregorianCalendar(1982, 2, 23);
		Calendar dataNascimento3 = new GregorianCalendar(1974, 12, 6);
		
		Funcionario funcionario = new Funcionario("Jhonatan", 9, dataNascimento);
		Funcionario funcionario2 = new Funcionario("Alberto", 3, dataNascimento2);
		Funcionario funcionario3 = new Funcionario("Amarildo", 8, dataNascimento3);
		
		Calendar hoje = Calendar.getInstance();
		Gasto gasto = new Gasto(40, "taxi", funcionario, hoje, false);
		Gasto gasto2 = new Gasto(190, "motorista", funcionario2, hoje, true);
		Gasto gasto3 = new Gasto(1000, "choffer", funcionario3, hoje, true);
	
		System.out.println(gasto + "\n" + gasto2 + "\n" + gasto3);
	}
}
