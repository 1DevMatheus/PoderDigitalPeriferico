package com.podergital.pdp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Declarando que criaremos a tabela de temas dentro do mysql

@Entity
@Table(name = "tb_temas")
public class TemaModel {

//Itens dentro da tabela temas do projeto

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Defina o tema de sua postagem!")
	@Size(min = 5, max = 66)
	private String tema;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
	
}
