package com.nonato.leilao.servico;

import com.nonato.leilao.dominio.Lance;
import com.nonato.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorLance = Double.NEGATIVE_INFINITY;
	private double menorLance = Double.POSITIVE_INFINITY;

	public void avalia(Leilao leilao) {
		for (Lance lance : leilao.getLances()) {
			if (lance.getValor() > maiorLance)
				maiorLance = lance.getValor();
			else if (lance.getValor() < menorLance)
				menorLance = lance.getValor();
		}

	}

	public double getMaiorLance() {
		return maiorLance;
	}

	public double getMenorLance() {
		return menorLance;
	}
	

}
