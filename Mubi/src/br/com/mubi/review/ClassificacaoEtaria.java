package br.com.mubi.review;

public class ClassificacaoEtaria {

	private String tipo;
	private String imagem;
	
	public ClassificacaoEtaria(String tipo, String imagem){
		setTipo(tipo);
		setImagem(imagem);
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
