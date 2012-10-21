package br.com.mubi.usuario;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;

import br.com.mubi.review.Filme;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private Integer codigo;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "email")
	private String email;
	
	@NaturalId
	@Column(name = "login")
	private String login;
	
	@Column(name = "senha")
	private String senha;
	
	@Column(name = "nascimento")
	@Temporal(value = TemporalType.DATE)
	private Date nascimento;
	
	@Column(name = "ativo")
	private boolean ativo;
	
	@ElementCollection(targetClass = String.class)
	@JoinTable(
		name = "usuario_permissao", 
		uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario","permissao"})},
	    joinColumns = @JoinColumn(name = "usuario"))
	@Column(name = "permissao", length=50)
	private Set<String> permissao = new HashSet<String>();
	
	@OneToMany(mappedBy="usuario", targetEntity=Filme.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	List<Filme> filme;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public Set<String> getPermissao() {
		return permissao;
	}
	public void setPermissao(Set<String> permissao) {
		this.permissao = permissao;
	}
	public List<Filme> getFilme() {
		return filme;
	}
	public void setFilme(List<Filme> filme) {
		this.filme = filme;
	}
		
}
