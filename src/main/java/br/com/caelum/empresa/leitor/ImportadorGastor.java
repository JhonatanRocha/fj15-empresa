package br.com.caelum.empresa.leitor;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import br.com.caelum.empresa.modelo.Funcionario;
import br.com.caelum.empresa.modelo.Gasto;

public class ImportadorGastor {
	
	private SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
	
	public List<Gasto> importa(InputStream entrada) throws ParseException {
		Scanner leitor = new Scanner(entrada);
		List<Gasto> gastos = new ArrayList<Gasto>();
		
		
		while (leitor.hasNextLine()) {
			String line = leitor.nextLine();
			String tipoGasto = line.substring(0, 6);
			String dataGastoTxt = line.substring(6, 14);
			String valorTxt = line.substring(14, 23);
			String matriculaTxt = line.substring(23, 26);
			String nome = line.substring(26, 56);
			String dataNascTxt = line.substring(56);
			
			double valor = Double.parseDouble(valorTxt);
			int matricula = Integer.parseInt(matriculaTxt);
			
			Calendar dataNascimento = convertDataTxtToCalendar(dataNascTxt);
			
			Calendar dataDespesa = convertDataTxtToCalendar(dataGastoTxt);
			
			Funcionario funcionario = new Funcionario(nome, matricula,
					dataNascimento);
			gastos.add(new Gasto(valor, tipoGasto, funcionario, dataDespesa));
		}
		return gastos;
	}

	private Calendar convertDataTxtToCalendar(String dataGastoTxt)
			throws ParseException {
		Calendar dataDespesa = Calendar.getInstance();
		dataDespesa.setTime(df.parse(dataGastoTxt));
		return dataDespesa;
	}
}
