package br.com.algaworks.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class MinhaCidadeBean {
	private String nome;
	private String cidadeNatal;
	private List<String> todasCidades;

	public MinhaCidadeBean() {
		this.todasCidades = new ArrayList<>();
		this.todasCidades.add("Uberlândia-MG");
		this.todasCidades.add("Uberaba-MG");
		this.todasCidades.add("Belo Horizonte-MG");
		this.todasCidades.add("São Paulo-SP");
		this.todasCidades.add("Campinas-SP");
		this.todasCidades.add("São José dos Campos-SP");
		this.todasCidades.add("Rio de Janeiro-RJ");
		this.todasCidades.add("Goiânia-GO");
		this.todasCidades.add("Fortaleza-CE");
		this.todasCidades.add("Porto Velho-RO");
	}

	public String getCidadeNatal() {
		return cidadeNatal;
	}

	public void setCidadeNatal(String cidadeNatal) {
		this.cidadeNatal = cidadeNatal;
	}

	public List<String> getTodasCidades() {
		return todasCidades;
	}

	public void cadastrar() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro efetuado.",
				"Cliente " + this.nome + " cadastrado com sucesso.");
		context.addMessage(null, mensagem);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
