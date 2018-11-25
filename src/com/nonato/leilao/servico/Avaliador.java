package com.nonato.leilao.servico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.nonato.leilao.dominio.Lance;
import com.nonato.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorLance = Double.NEGATIVE_INFINITY;
	private double menorLance = Double.POSITIVE_INFINITY;
	private List<Lance> maioresLances;

	public void avalia(Leilao leilao) {
		if (leilao.getLances().size() == 0) {
			throw new RuntimeException("Não é possível avaliar um leilão sem lances!");
		}
		for (Lance lance : leilao.getLances()) {
			if (lance.getValor() > maiorLance)
				maiorLance = lance.getValor();
			if (lance.getValor() < menorLance)
				menorLance = lance.getValor();
		}

		maioresLances = new ArrayList<Lance>(leilao.getLances());
		Collections.sort(maioresLances, new Comparator<Lance>() {

			public int compare(Lance o1, Lance o2) {
				if (o1.getValor() < o2.getValor())
					return 1;
				if (o1.getValor() > o2.getValor())
					return -1;
				return 0;
			}
		});

		maioresLances = maioresLances.subList(0, maioresLances.size() > 3 ? 3 : maioresLances.size());

	}

	public double getMaiorLance() {
		return maiorLance;
	}

	public double getMenorLance() {
		return menorLance;
	}

	public List<Lance> getMaioresLances() {
		return maioresLances;
	}

}
