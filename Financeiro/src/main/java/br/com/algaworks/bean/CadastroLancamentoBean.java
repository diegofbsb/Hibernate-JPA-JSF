package br.com.algaworks.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.repository.CadastroLancamentos;
import com.algaworks.repository.Lancamentos;
import com.algaworks.repository.Pessoas;

import br.com.algawork.util.JpaUtil;
import br.com.algawork.util.NegocioException;
import br.com.algaworks.model.Lancamento;
import br.com.algaworks.model.Pessoa;
import br.com.algaworks.model.TipoLancamento;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean {

	private static final long serialVersionUID = 1L;

	private Lancamento lancamento = new Lancamento();

	private List<Pessoa> todasPessoas;

	public void prepararCadastro() {
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			Pessoas pessoas = new Pessoas(manager);
			this.todasPessoas = pessoas.todas();
		} finally {
			manager.close();
		}
	}

	public void salvar() {
		 EntityManager manager = JpaUtil.getEntityManager();
		 EntityTransaction trx = manager.getTransaction();
		 FacesContext context = FacesContext.getCurrentInstance();
		 try {
		 trx.begin();
		 CadastroLancamentos cadastro = new CadastroLancamentos(new
		 Lancamentos(manager));
		 cadastro.salvar(this.lancamento);
		 this.lancamento = new Lancamento();
		 context.addMessage(null, new FacesMessage("Lançamento salvo com sucesso!"));
		 trx.commit();
		 } catch (NegocioException e) {
		 trx.rollback();
		 FacesMessage mensagem = new FacesMessage(e.getMessage());
		 mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
		 context.addMessage(null, mensagem);
		 } finally {
		 manager.close();
		 }
	}

	public List<Pessoa> getTodasPessoas() {
		return this.todasPessoas;
	}

	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

}
