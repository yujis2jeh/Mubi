package br.com.mubi.review;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FilmeBean {
	
	private List<ClassificacaoEtaria> imagens;
	private Filme filme;
	
	public FilmeBean() {
		carregarImagensClassificacao();
		setFilme(new Filme());
	}
	
	public void carregarImagensClassificacao() {
		imagens = new ArrayList<ClassificacaoEtaria>();
		imagens.add(new ClassificacaoEtaria("Livre", "classificacaoLivre.png"));
		imagens.add(new ClassificacaoEtaria("Maior de 10 anos", "classificacao10.png"));
		imagens.add(new ClassificacaoEtaria("Maior de 12 anos", "classificacao12.png"));
		imagens.add(new ClassificacaoEtaria("Maior de 14 anos", "classificacao14.png"));
		imagens.add(new ClassificacaoEtaria("Maior de 16 anos", "classificacao16.png"));
		imagens.add(new ClassificacaoEtaria("Maior de 18 anos", "classificacao18.png"));
	}

	public List<ClassificacaoEtaria> getImagens() {
		return imagens;
	}

	public void setImagens(List<ClassificacaoEtaria> imagens) {
		this.imagens = imagens;
	}
	
	public void validarContinuacao(){
		
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	
}
