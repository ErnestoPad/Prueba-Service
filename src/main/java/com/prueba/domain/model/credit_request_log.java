package com.prueba.domain.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "credit_request_log")
public class credit_request_log implements Serializable{
	@Id
	String idEstatus;
	String idSolicitud;
	Timestamp  fecha;
}
