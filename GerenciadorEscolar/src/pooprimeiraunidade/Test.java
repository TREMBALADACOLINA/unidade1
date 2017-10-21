package pooprimeiraunidade;
import static org.junit.Assert.*;

import org.junit.Before;

public class Test {

	Gerente g;
	
	@Before
	public void setUp(){
		g = new Gerente();
	}
	@org.junit.Test
	public void test() throws Exception {
		Aluno a = new Aluno("123","Alex","alex@alex");
		g.cadastrarAluno(a);
		assertEquals(1, Gerente.getAlunos().size());
		
		assertTrue(a == g.buscaAluno("123"));
	}

}
