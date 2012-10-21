package br.com.mubi.review;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Filme {
	
	private long id;
	private String tituloBrasil;
	private String tituloOriginal;
	private int anoLancamento;
	private int duracao;
	private String genero;
	private String classificacao;
	private String produtora;
	private String direcao;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTituloBrasil() {
		return tituloBrasil;
	}
	public void setTituloBrasil(String tituloBrasil) {
		this.tituloBrasil = tituloBrasil;
	}
	public String getTituloOriginal() {
		return tituloOriginal;
	}
	public void setTituloOriginal(String tituloOriginal) {
		this.tituloOriginal = tituloOriginal;
	}
	public int getAnoLancamento() {
		return anoLancamento;
	}
	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public String getProdutora() {
		return produtora;
	}
	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}
	public String getDirecao() {
		return direcao;
	}
	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}
	
}
