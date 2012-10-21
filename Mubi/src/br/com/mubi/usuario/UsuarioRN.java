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
		return this.usuarioDAO.carregar(codigo);
	}
	
	public Usuario buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	}
	
	public void salvar(Usuario usuario) {
		Integer codigo = usuario.getCodigo();
		if (codigo == null || codigo == 0) {
			usuario.getPermissao().add("ROLE_USUARIO");
			usuario.getPermissao().add("ROLE_ADMINISTRADOR");
			this.usuarioDAO.salvar(usuario);
		} else {
			usuario.getPermissao();
			this.usuarioDAO.atualizar(usuario);
		}
	}
	
	public void excluir(Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
	}
	
	public List<Usuario> listar() {
		return this.usuarioDAO.listar();
	}
	
	public boolean validarCamposObrigatorios(Usuario usuario, FacesContext context) {
		boolean validacaoOk = true;
		
		if(usuario.getNome().isEmpty()) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Nome obrigatório", null));
			validacaoOk = false;
		}
		if(usuario.getNascimento() == null) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Data de Nascimento obrigatória", null));
			validacaoOk = false;
		}
		if(usuario.getLogin().isEmpty()) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuário obrigatório", null));
			validacaoOk = false;
		}
		if(usuario.getSenha().isEmpty()) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Senha obrigatória", null));
			validacaoOk = false;
		}
		if(usuario.getEmail().isEmpty()) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "E-Mail obrigatório", null));
			validacaoOk = false;
		}
		
		return validacaoOk;
	}
}
