package br.com.mubi.review;

import java.util.List;

public interface FilmeDAO {
	public void salvar(Filme filme);
	public void atualizar(Filme filme);
	public void excluir(Filme filme);
	public Filme carregar();
	public List<Filme> listar();
}
