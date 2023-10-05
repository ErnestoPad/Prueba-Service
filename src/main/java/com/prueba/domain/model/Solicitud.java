package com.prueba.domain.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Entity
@Table(name = "solicitudes")
public class Solicitud implements Serializable{
	@Id
	 String idSolicitud;
	 String idCredito;
	 String curp;
	 String tipoSolicitudStr;
	 String idStatus;
	 float capitalDispersado;
	 float monto;
	 float tasa;
	 int plazo;
	 String frecuencia;
	 Timestamp fechaSolicitud;
}
