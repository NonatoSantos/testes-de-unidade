package com.nonato.leilao.servico;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.nonato.leilao.dominio.Leilao;

public class AvaliadorTest {

	@Test(expected = RuntimeException.class)
	public void testaLeilaoSemLances() {

		Leilao leilao = new Leilao("Smartphone Galaxy A8");
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertTrue(leilao.getLances().size()==0);

	}

}
