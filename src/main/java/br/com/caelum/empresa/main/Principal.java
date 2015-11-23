package br.com.caelum.empresa.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.caelum.empresa.modelo.Funcionario;

public class Principal {
	public static void main(String[] args) {
		Calendar dataNascimento = new GregorianCalendar(1990, 5, 11);
		Funcionario funcionario = new Funcionario("Jhol", 25, dataNascimento);
	
		System.out.println(funcionario);
	}
}
