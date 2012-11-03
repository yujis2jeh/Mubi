package br.com.mubi.review;

import br.com.mubi.util.DAOFactory;

public class FilmeRN {
	private Filme filme;
	private FilmeDAO filmeDAO;
	private boolean continuacao;
	
	public FilmeRN() {
		setFilme(new Filme());
		filmeDAO = DAOFactory.criarFilmeDAO();
	}
	
	public boolean continuarInclusao(){
		if(filme.getAnoLancamento() == 0 || filme.getClassificacao().isEmpty() || filme.getDirecao().isEmpty() || filme.getDuracao() == 0 || filme.getGenero().isEmpty() || filme.getProdutora().isEmpty()
				|| filme.getTituloBrasil().isEmpty() || filme.getTituloOriginal().isEmpty()){
			return continuacao;
		} else {
			return continuacao = true;
		}
	}
	
	public void salvarReview() {
		DAOFactory.beginTransaction();
		filmeDAO.salvar(filme);
		DAOFactory.commitTransaction();
	}
	
	public void voltar(){
		continuacao = false;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public boolean isContinuacao() {
		return continuacao;
	}

	public void setContinuacao(boolean continuacao) {
		this.continuacao = continuacao;
	}

}
