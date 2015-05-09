package test.model.pojo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trabalho.model.pojo.Aluno;

public class AlunoTest {

	Aluno aluno;
    
    @Before
    public void Inicializar_Variavel(){
        aluno = new Aluno("Guilherme","123");
    }
    
    @Test
    public void TestGetNome() throws Exception{
        assertEquals("Guilherme",aluno.getNome());
    }
    
    @Test
    public void TestGetCpf() throws Exception{
    	assertEquals("123",aluno.getCpf());
    }
    
    @Test
    public void TestSetNome() throws Exception{
    	assertEquals("Guilherme",aluno.getNome());
    	aluno.setNome("Weldis");
    	assertEquals("Weldis",aluno.getNome());
    }

}
