package test.model.pojo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trabalho.model.pojo.Atividade;

public class AtividadeTest {

	Atividade atividade;
	Atividade atividade2;
	Atividade atividade3;

    
    @Before
    public void Inicializar_Variavel(){
    	atividade = new Atividade("att 5");
    	atividade2 = new Atividade("att6","prova","12/12/12",10.0);
    	atividade3 = new Atividade();

    }
    
    @Test
    public void TestGetNomeVazio() throws Exception{
        assertEquals(null,atividade3.getNome());

    }
    
    @Test
    public void TestGetTipoVazio() throws Exception{
        assertEquals(null,atividade3.getTipo());

    }
    
    @Test
    public void TestGetDataVazio() throws Exception{
        assertEquals(null,atividade3.getData());

    }
    
    @Test
    public void TestGetValorVazio() throws Exception{
    	assertEquals(0.0,(double)atividade3.getValor(),0.01);
    }
    
    @Test
    public void TestGetValor() throws Exception{
    	assertEquals(10.0,atividade2.getValor(),0.01);
    }
    
    @Test
    public void TestGetNome() throws Exception{
        assertEquals("att 5",atividade.getNome());

    }
    
    @Test
    public void TestGetTipo() throws Exception{
    	assertEquals("prova",atividade2.getTipo());
    }
    
    @Test
    public void TestGetData() throws Exception{
    	assertEquals("12/12/12",atividade2.getData());
    }
    
    @Test
    public void TestSetNome() throws Exception{
    	assertEquals("att 5",atividade.getNome());
    	atividade.setNome("xxt");
    	assertEquals("xxt",atividade.getNome());
    	
    }
    
    @Test
    public void TestSetData() throws Exception{
    	assertEquals(null,atividade.getData());
    	atividade.setData("10/10/10");
    	assertEquals("10/10/10",atividade.getData());
    	
    }
    
    @Test
    public void TestSetTipo() throws Exception{
    	assertEquals(null,atividade.getTipo());
    	atividade.setTipo("prova");
    	assertEquals("prova",atividade.getTipo());
    	
    }
    
    @Test
    public void TestSetValor() throws Exception{
    	assertEquals(0.0,atividade.getValor(),0.01);
    	atividade.setValor(8.0);
    	assertEquals(8.0,atividade.getValor(),0.01);
    }

}
