package com.prado.examen.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_marca")
public class Marca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_marca")
	private Integer codigo;
	@Column(name="nom_marca")
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "marca")
	private List<Silla> listaMarca;


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Silla> getListaMarca() {
		return listaMarca;
	}


	public void setListaMarca(List<Silla> listaMarca) {
		this.listaMarca = listaMarca;
	}
	
	
}