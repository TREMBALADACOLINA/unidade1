package pooprimeiraunidade;

import util.Tema;

public class PadraoFacade {
	//abstrair/esconde o código por tras da interface grafica
	public void iniciaJanela(){
		Tema.changeWindows();
		TelaInicial t = new TelaInicial();		
		t.setVisible(true);
	}

	
	
	
}
