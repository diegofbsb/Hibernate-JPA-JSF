package br.com.algaworks.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.algaworks.repository.Lancamentos;

import br.com.algawork.util.JpaUtil;
import br.com.algaworks.model.Lancamento;


@ManagedBean
@ViewScoped
public class ConsultaLancamentosBean {

	private List<Lancamento> lancamentos;

	public void consultar() {


		 EntityManager manager = JpaUtil.getEntityManager();
		 TypedQuery<Lancamento> query = manager.createQuery("from Lancamento",
		 Lancamento.class);
		 this.lancamentos = query.getResultList();
		 manager.close();
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
}
