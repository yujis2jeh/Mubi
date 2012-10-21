package br.com.mubi.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.mubi.review.Filme;
import br.com.mubi.usuario.Usuario;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure();
		cfg.addAnnotatedClass(Usuario.class);
		cfg.addAnnotatedClass(Filme.class);
		return cfg.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
