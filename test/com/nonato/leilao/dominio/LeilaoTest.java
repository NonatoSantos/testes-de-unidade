package com.nonato.leilao.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nonato.leilao.servico.Avaliador;

public class LeilaoTest {

	@Test
	public void testaLances() {
		Usuario nonato = new Usuario("Nonato");
		Usuario leide = new Usuario("Leide");
		Usuario grazy = new Usuario("Grazielly");
		Leilao leilao = new Leilao("Leilão Lote 20");
		leilao.propoe(new Lance(nonato, 500.00));
		leilao.propoe(new Lance(leide, 498.00));
		leilao.propoe(new Lance(grazy, 499.80));
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(leiloeiro.getMaiorLance(), 500.00, 0.00001);
		assertEquals(leiloeiro.getMenorLance(), 498.0, 0.00001);
		assertEquals(nonato.getNome(),"Nonato");
		

	}

}
