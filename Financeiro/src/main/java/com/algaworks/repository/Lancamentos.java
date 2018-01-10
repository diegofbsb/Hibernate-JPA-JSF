package com.algaworks.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.hibernate.service.spi.InjectService;

import br.com.algaworks.model.Lancamento;

public class Lancamentos {
	private EntityManager manager;

	@Inject
	public Lancamentos(EntityManager manager) {
		this.manager = manager;
	}

	public List<Lancamento> todos() {
		TypedQuery<Lancamento> query = manager.createQuery("from Lancamento", Lancamento.class);
		return query.getResultList();
	}

	public void adicionar(Lancamento lancamento) {
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		this.manager.persist(lancamento);
		trx.commit();

	}

}
