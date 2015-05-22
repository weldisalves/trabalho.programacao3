package test.model.pojo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trabalho.model.pojo.Professor;

public class ProfessorTest {

	Professor professor;
	
	@Before
	public void Inicializar_Variavel(){
		professor = new Professor("Weldis","123","Tecnologia");
	}
	
	@Test
	public void TestGetNome() throws Exception {
		assertEquals("Weldis",professor.getNome());
	}
	
	@Test
	public void TestSetNome() throws Exception{
		assertEquals("Weldis",professor.getNome());
		professor.setNome("Andrey");
		assertEquals("Andrey",professor.getNome());
	}
	
	@Test
	public void TestGetDepartamento() throws Exception {
		assertEquals("Tecnologia",professor.getDepartamento());
	}
	
	@Test
	public void TestSetDepartamento() throws Exception{
		assertEquals("Tecnologia",professor.getDepartamento());
		professor.setDepartamento("Desenvolvimento");
		assertEquals("Desenvolvimento",professor.getDepartamento());
	}
	
	@Test
    public void TestGetCpf() throws Exception{
    	assertEquals("123",professor.getCpf());
    }

}
