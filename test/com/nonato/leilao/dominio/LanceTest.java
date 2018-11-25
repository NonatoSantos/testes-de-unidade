package com.nonato.leilao.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class LanceTest {

	@Test
	public void test() {
		Leilao leilao = new Leilao("Notebook Dell I7");
		leilao.propoe(new Lance(new Usuario("Nonato"), 899.00));
		leilao.propoe(new Lance(new Usuario("Leide"), 918.00));
		
		assertEquals(2,leilao.getLances().size());
		assertEquals(918.00, leilao.getLances().get(1).getValor(),0.00001);
	}
	
	@Test
	public void testaNumeroLancesUsuario() {
		Leilao leilao = new Leilao("Notebook Dell I7");
		Usuario nonato = new Usuario("Nonato");
		leilao.propoe(new Lance(nonato, 899.00));
		//pela regra deve ser ignorado
		leilao.propoe(new Lance(nonato, 918.00));
		
		assertEquals(1,leilao.getLances().size());
		assertEquals(899.00, leilao.getLances().get(0).getValor(),0.00001);
	}
	
	@Test
	public void testaNumeroMaximosLancesUsuario() {
		Leilao leilao = new Leilao("Notebook Dell I7");
		Usuario nonato = new Usuario("Nonato");
		Usuario leide = new Usuario("Leide");
		Usuario grazy = new Usuario("Grazy");
		leilao.propoe(new Lance(nonato, 899.00));
		leilao.propoe(new Lance(leide, 889.00));
		leilao.propoe(new Lance(nonato, 890.00));
		leilao.propoe(new Lance(grazy, 809.00));
		leilao.propoe(new Lance(nonato, 799.00));
		leilao.propoe(new Lance(leide, 699.00));
		leilao.propoe(new Lance(nonato, 1899.00));
		leilao.propoe(new Lance(grazy, 999.00));
		leilao.propoe(new Lance(nonato, 918.00));
		leilao.propoe(new Lance(leide, 599.00));
		//pela regra deve ser ignorado
		leilao.propoe(new Lance(nonato, 559.00));
		
		assertEquals(10,leilao.getLances().size());
		assertEquals(899.00, leilao.getLances().get(0).getValor(),0.00001);
	}

}
