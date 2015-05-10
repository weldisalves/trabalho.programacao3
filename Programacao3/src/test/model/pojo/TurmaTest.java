package test.model.pojo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trabalho.model.pojo.Turma;

public class TurmaTest {

	Turma turma;
	
	@Before
	public void Inicializar_Variavel(){
		turma = new Turma("2015",1,"ceunes","13:00",50);
	}
	
	@Test
	public void TestGetAno() throws Exception {
		assertEquals("2015",turma.getAno());
	}
	
	@Test
	public void TestSetAno() throws Exception{
		assertEquals("2015",turma.getAno());
		turma.setAno("2016");
		assertEquals("2016",turma.getAno());
	}
	
	@Test
	public void TestGetPeriodo() throws Exception {
		assertEquals(1,turma.getPeriodo());
	}
	
	@Test
	public void TestSetPeriodo() throws Exception{
		assertEquals(1,turma.getPeriodo());
		turma.setPeriodo(2);
		assertEquals(2,turma.getPeriodo());
	}
	
	@Test
	public void TestGetLocal() throws Exception {
		assertEquals("ceunes",turma.getLocal());
	}
	
	@Test
	public void TestSetLocal() throws Exception{
		assertEquals("ceunes",turma.getLocal());
		turma.setLocal("republica");
		assertEquals("republica",turma.getLocal());
	}
	
	@Test
	public void TestGetHorario() throws Exception {
		assertEquals("13:00",turma.getHorario());
	}
	
	@Test
	public void TestSetHorario() throws Exception{
		assertEquals("13:00",turma.getHorario());
		turma.setHorario("14:40");
		assertEquals("14:40",turma.getHorario());
	}
	
	@Test
	public void TestGetNumeroDeVagas() throws Exception {
		assertEquals(50,turma.getNumeroDeVagas());
	}
	
	@Test
	public void TestSetNumeroDeVagas() throws Exception{
		assertEquals(50,turma.getNumeroDeVagas());
		turma.setNumeroDeVagas(100);
		assertEquals(100,turma.getNumeroDeVagas());
	}

}
