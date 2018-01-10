package com.algaworks.repository;

import java.util.Date;

import javax.inject.Inject;

import br.com.algawork.util.NegocioException;
import br.com.algaworks.model.Lancamento;

public class CadastroLancamentos {
	
	@Inject
	private Lancamentos lancamentos;

	public CadastroLancamentos(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}

	public void salvar(Lancamento lancamento) throws NegocioException {
		if (lancamento.getDataPagamento() != null && lancamento.getDataPagamento().after(new Date())) {
			throw new NegocioException("Data de pagamento não pode ser uma data futura.");
		}
		this.lancamentos.adicionar(lancamento);
	}

}
