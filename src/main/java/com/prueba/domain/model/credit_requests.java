package com.prueba.domain.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.Entity;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
@Entity
@Table(name = "credit_requests")
public class credit_requests implements Serializable{
	/**
	 * 
	 */
	 String promotor;
	 String empresa;
	@Id
	 String idSolicitud;
	String idStatus;
	 String nombre;
	 String apellido_materno;
	 String apellido_paterno;
}
