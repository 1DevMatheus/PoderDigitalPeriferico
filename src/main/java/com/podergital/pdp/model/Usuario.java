package com.podergital.pdp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Insira seu nome")
	@Size(max = 35,message = "Insira seu nome!")
	private String nome;
	
	@NotNull(message = "Insira seu email!")
	@Email(message = "Insira um email valido!")
	private String usuario;
	
	@NotNull(message = "Insira sua senha")
	@Size(min = 8 ,max = 144)
	private String senha;
	
	@Size(max = 5000, message = "Faça o upload da sua foto")
	private String foto;

	@OneToMany(mappedBy =  "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<PostagemModel> postagens;
	

	public List<PostagemModel> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<PostagemModel> postagens) {
		this.postagens = postagens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	

}
