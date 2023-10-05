package com.prueba.domain.model;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActulizarStatusSolicitud implements Serializable {
	 String idSolicitud;
	 String idEstatus;
	 Timestamp fecha;
}
	