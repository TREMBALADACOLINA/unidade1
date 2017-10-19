package pooprimeiraunidade;

public class PadraoFacade {
	//abstrair/esconde o código por tras da interface grafica
	public void iniciaJanela(){
		TelaInicial t = new TelaInicial();
		t.setVisible(true);
	}

}
