package br.com.mubi.review;

public class ClassificacaoEtaria {

	private String tipo;
	private String classificacao;
	
	public ClassificacaoEtaria(String tipo, String classiicacao){
		setTipo(tipo);
		setImagem(classiicacao);
	}

	public String getImagem() {
		return classificacao;
	}

	public void setImagem(String imagem) {
		this.classificacao = imagem;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
