package test.model.pojo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trabalho.model.pojo.Disciplina;

public class DisciplinaTest {
	
	Disciplina disciplina;
	
	@Before
	public void Inicializar_Variavel(){
		disciplina = new Disciplina("poo","polimorfismo",100);
	}
	
	@Test
	public void TestGetNome() throws Exception {
		assertEquals("poo",disciplina.getNome());
	}
	
	@Test
	public void TestSetNome() throws Exception{
		assertEquals("poo",disciplina.getNome());
		disciplina.setNome("Prog 3");
		assertEquals("Prog 3",disciplina.getNome());
	}
	
	@Test
	public void TestGetEmenta() throws Exception {
		assertEquals("polimorfismo",disciplina.getEmenta());
	}
	
	@Test
	public void TestSetEmenta() throws Exception{
		assertEquals("polimorfismo",disciplina.getEmenta());
		disciplina.setEmenta("Tipos genéricos");
		assertEquals("Tipos genéricos",disciplina.getEmenta());
	}
	
	@Test
	public void TestGetCargaHoraria() throws Exception {
		assertEquals(100,disciplina.getCargaHoraria());
	}
	
	@Test
	public void TestSetCargaHoraria() throws Exception{
		assertEquals(100,disciplina.getCargaHoraria());
		disciplina.setCargaHoraria(120);
		assertEquals(120,disciplina.getCargaHoraria());
	}

}
