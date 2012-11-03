package br.com.mubi.review;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class FilmeBean {
	
	private List<ClassificacaoEtaria> classificacao;
	private FilmeRN filmeRN;
	
	public FilmeBean() {
		carregarImagensClassificacao();
		setFilmeRN(new FilmeRN());
	}
	
	public void carregarImagensClassificacao() {
		classificacao = new ArrayList<ClassificacaoEtaria>();
		classificacao.add(new ClassificacaoEtaria("Livre", "classificacaoLivre.png"));
		classificacao.add(new ClassificacaoEtaria("Maior de 10 anos", "classificacao10.png"));
		classificacao.add(new ClassificacaoEtaria("Maior de 12 anos", "classificacao12.png"));
		classificacao.add(new ClassificacaoEtaria("Maior de 14 anos", "classificacao14.png"));
		classificacao.add(new ClassificacaoEtaria("Maior de 16 anos", "classificacao16.png"));
		classificacao.add(new ClassificacaoEtaria("Maior de 18 anos", "classificacao18.png"));
	}

	
	public void validarContinuacao() {
		boolean continuaInclusao;
		continuaInclusao = filmeRN.continuarInclusao();
		if(!continuaInclusao){
			FacesContext facesContext = FacesContext.getCurrentInstance();
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Favor preencher todos os campos.", null);
			facesContext.addMessage(null, facesMessage);
		}
	}
	
	public void salvarReview() {
		filmeRN.salvarReview();
	}

	public List<ClassificacaoEtaria> getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(List<ClassificacaoEtaria> classificacao) {
		this.classificacao = classificacao;
	}

	public FilmeRN getFilmeRN() {
		return filmeRN;
	}

	public void setFilmeRN(FilmeRN filmeRN) {
		this.filmeRN = filmeRN;
	}	
	
}
