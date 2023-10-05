package com.prueba.domain.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Creditos")
public class Credito implements Serializable{
	 String idSolicitud;
	 @Id
	 String idCredito;
	 double montoDispersado;
	 double monto;
	 double tasa;
	 int plazo;
	 String frecuencia;
}
