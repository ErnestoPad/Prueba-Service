package com.prueba.domain.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Entity
@Table(name = "Clientes")
public class Clientes implements Serializable{
	@Id
	 String curp;
	 String nombre;
	 String apellido_materno;
	 String apellido_paterno;
}
