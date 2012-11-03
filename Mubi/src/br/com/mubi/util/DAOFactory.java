package br.com.mubi.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.mubi.review.FilmeDAO;
import br.com.mubi.review.FilmeDAOHibernate;
import br.com.mubi.usuario.UsuarioDAO;
import br.com.mubi.usuario.UsuarioDAOHibernate;

public class DAOFactory {
	private static Session session;
	private static Transaction transaction;
	
	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(getSession());
		return usuarioDAO;
	}
	
	public static FilmeDAO criarFilmeDAO() {
		FilmeDAOHibernate filmeDAO = new FilmeDAOHibernate();
		filmeDAO.setSession(getSession());
		return filmeDAO;
	}
	
	public static Session getSession() {
		if(session == null){
			session = HibernateUtil.getSessionFactory().openSession();
		} else {
			if(HibernateUtil.getSessionFactory().isClosed()) {
				session = HibernateUtil.getSessionFactory().openSession();
			}
		}
		return session; 
	}
	
	public static void beginTransaction(){
		transaction = session.beginTransaction();
	}
	
	public static void commitTransaction(){
		transaction.commit();
	}
	
	public static void closeSession() {
		session.close();
	}
}
