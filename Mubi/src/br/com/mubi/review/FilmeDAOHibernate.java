package br.com.mubi.review;

import java.util.List;

import org.hibernate.Session;

public class FilmeDAOHibernate implements FilmeDAO {
	
	private Session session;
	public void setSession(Session session){
		this.session = session;
	}

	public void salvar(Filme filme) {
		this.session.save(filme);
	}

	public void atualizar(Filme filme) {
		this.session.update(filme);
	}

	public void excluir(Filme filme) {
		this.session.delete(filme);
	}

	public Filme carregar() {
		return (Filme) this.session.createCriteria(Filme.class).uniqueResult();
		
	}

	@SuppressWarnings("unchecked")
	public List<Filme> listar() {
		return (List<Filme>) this.session.createCriteria(Filme.class).list();
	}

}
