package br.com.mubi.usuario;

import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;

@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean {
	private Usuario usuario;
	private String confirmaSenha;
	private List<Usuario> lista;
	private String destinoSalvar;
	private boolean areaSenha;
	
	public String novo() {
		this.destinoSalvar = "login";
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "cadastroUsuario";
	}
	
	public String editar() {
		this.destinoSalvar = "principal";
		UsuarioRN usuarioRN = new UsuarioRN();
		HttpServletRequest request = 
				(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		this.usuario = usuarioRN.buscarPorLogin(request.getRemoteUser());
		this.confirmaSenha = this.usuario.getSenha();
		return "atualizacaoConta";
	}
	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();		
		String senha = this.usuario.getSenha();
		
		if (!senha.equals(this.confirmaSenha)) {
			FacesMessage facesMessage = new FacesMessage("A senha n�o foi confirmada corretamente.");
			facesMessage.setSeverity(FacesMessage.SEVERITY_WARN);
			context.addMessage(null, facesMessage);
			return null;
		}
		

		UsuarioRN usuarioRN = new UsuarioRN();
		
		if(usuarioRN.validarCamposObrigatorios(this.usuario, context)) {
			try {
				usuarioRN.salvar(this.usuario);		
				return this.destinoSalvar;
			} catch (ConstraintViolationException exception) {
				FacesMessage message = new FacesMessage("O usu�rio j� existe.");
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				context.addMessage(null, message);
				return null;
			}
		}else {
			return null;
		}
	}
	
	public String excluir() {
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.excluir(this.usuario);
		this.lista = null;
		return null;
	}
	
	public String ativar() {
		if (this.usuario.isAtivo())
			this.usuario.setAtivo(false);
		else
			this.usuario.setAtivo(true);
		
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		return null;
	}
	
	public List<Usuario> getLista() {
		if (this.lista == null) {
			UsuarioRN usuarioRN = new UsuarioRN();
			this.lista = usuarioRN.listar();
		}
		return this.lista;
	}
	
	public String atribuiPermissao(Usuario usuario, String permissao) {
		this.usuario = usuario;
		Set<String> permissoes = this.usuario.getPermissao();
		if (permissoes.contains(permissao)) {
			permissoes.remove(permissao);
		} else {
			permissoes.add(permissao);
		}
		return null;
	}
	
	public void habilitarAreaSenha() {
		if(this.areaSenha) {
			this.areaSenha = false;
		} else {
			this.areaSenha = true;
		}
		
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	public String getDestinoSalvar() {
		return destinoSalvar;
	}
	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public boolean isAreaSenha() {
		return areaSenha;
	}

	public void setAreaSenha(boolean areaSenha) {
		this.areaSenha = areaSenha;
	}
}
