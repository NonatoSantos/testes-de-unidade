package com.nonato.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;

	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}

	public void propoe(Lance lance) {
		Integer total = 0;
		for (Lance lanc : lances) {
			total = quantidadeLancePorUsuario(lance, total, lanc);

		}
		if (lances.isEmpty() || !lances.get(lances.size() - 1).getUsuario().equals(lance.getUsuario()) && total < 5)
			lances.add(lance);
	}

	private Integer quantidadeLancePorUsuario(Lance lance, Integer total, Lance lanc) {
		if (lanc.getUsuario().equals(lance.getUsuario()))
			total++;
		return total;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

}
