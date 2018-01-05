package br.com.algaworks.bean;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.algaworks.model.Pessoa;

public class PessoasBean {
	private EntityManager manager;

	public void Pessoa(EntityManager manager) { 
		this.manager = manager; }

	public Pessoa porId(Long id) {
		return manager.find(Pessoa.class, id);
	}

	public List<Pessoa> todas() {
		TypedQuery<Pessoa> query = manager.createQuery("from Pessoa", Pessoa.class);
		return query.getResultList();
	}

}
