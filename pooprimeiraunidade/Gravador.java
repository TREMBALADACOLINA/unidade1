package pooprimeiraunidade;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Gravador {
	
	public void gravar(String nome, String texto) throws IOException{
		FileWriter fw = new FileWriter(nome+".txt");
		BufferedWriter bf = new BufferedWriter(fw);
		bf.write(texto);
		bf.close();
	}

}
