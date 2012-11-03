package br.com.mubi.usuario;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.mubi.util.DAOFactory;

public class UsuarioRN {
	private UsuarioDAO usuarioDAO;
	
	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}
	
	public Usuario carregar(Integer codigo) {
		Usuario usuario;
		usuario =  this.usuarioDAO.carregar(codigo);
		return usuario;
	}
	
	public Usuario buscarPorLogin(String login) {
		Usuario usuario;
		usuario = this.usuarioDAO.buscarPorLogin(login);
		return usuario;
	}
	
	public void salvar(Usuario usuario) {
		Integer codigo = usuario.getCodigo();
		DAOFactory.beginTransaction();
		if (codigo == null || codigo == 0) {
			usuario.getPermissao().add("ROLE_USUARIO");
			usuario.getPermissao().add("ROLE_ADMINISTRADOR");
			this.usuarioDAO.salvar(usuario);
		} else {
			usuario.getPermissao();
			this.usuarioDAO.atualizar(usuario);
		}
		DAOFactory.commitTransaction();
	}
	
	public void excluir(Usuario usuario) {
		DAOFactory.beginTransaction();
		this.usuarioDAO.excluir(usuario);
		DAOFactory.commitTransaction();
		
	}
	
	public List<Usuario> listar() {
		List<Usuario> usuarios;
		usuarios =  this.usuarioDAO.listar();
		return usuarios;
	}
	
	public boolean validarCamposObrigatorios(Usuario usuario, FacesContext context) {
		boolean validacaoOk = true;
		
		if(usuario.getNome().isEmpty()) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Nome obrigat�rio", null));
			validacaoOk = false;
		}
		if(usuario.getNascimento() == null) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Data de Nascimento obrigat�ria", null));
			validacaoOk = false;
		}
		if(usuario.getLogin().isEmpty()) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Usu�rio obrigat�rio", null));
			validacaoOk = false;
		}
		if(usuario.getSenha().isEmpty()) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Senha obrigat�ria", null));
			validacaoOk = false;
		}
		if(usuario.getEmail().isEmpty()) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "E-Mail obrigat�rio", null));
			validacaoOk = false;
		}
		
		return validacaoOk;
	}
}
