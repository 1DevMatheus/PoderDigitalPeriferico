package com.podergital.pdp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuarios")
public class UsuariosModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Insira seu nome")
	@Size(max = 35)
	private String nome;
	
	@NotNull(message = "Insira sua senha")
	@Size(max = 144)
	private String senha;
	
	private String foto;
	

	@OneToMany(mappedBy =  "titulo", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("titulo")
	private List<PostagemModel> titulo;
	

	public List<PostagemModel> getPostagens() {
		return titulo;
	}

	public void setPostagens(List<PostagemModel> postagens) {
		this.titulo = postagens;
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
	
	

}
