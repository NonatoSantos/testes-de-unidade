package com.nonato.leilao.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nonato.leilao.servico.Avaliador;

public class LeilaoTest {

	@Test
	public void testaMaiorLance() {
		Usuario nonato = new Usuario("Nonato");
		Usuario leide = new Usuario("Leide");
		Usuario grazy = new Usuario("Grazielly");
		Leilao leilao = new Leilao("Leilão Lote 20");
		leilao.propoe(new Lance(nonato, 500.00));
		leilao.propoe(new Lance(leide, 498.00));
		leilao.propoe(new Lance(grazy, 499.80));
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(500.00, leiloeiro.getMaiorLance(), 0.00001);
		assertNotEquals(500.00, leiloeiro.getMenorLance(), 0.00001);

	}

	@Test
	public void testaMenorLance() {
		Usuario nonato = new Usuario("Nonato");
		Usuario leide = new Usuario("Leide");
		Usuario grazy = new Usuario("Grazielly");
		Leilao leilao = new Leilao("Leilão Lote 20");
		leilao.propoe(new Lance(nonato, 500.00));
		leilao.propoe(new Lance(leide, 498.00));
		leilao.propoe(new Lance(grazy, 499.80));
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(498.0, leiloeiro.getMenorLance(), 0.00001);
		assertNotEquals(498.00, leiloeiro.getMaiorLance(), 0.00001);

	}

	@Test
	public void testaUsuarios() {
		Usuario nonato = new Usuario("Nonato");
		Usuario leide = new Usuario("Leide");
		Usuario grazy = new Usuario("Grazielly");

		assertEquals("Nonato", nonato.getNome());
		assertEquals("Leide", leide.getNome());
		assertEquals("Grazielly", grazy.getNome());

	}

}
