package com.prueba.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.prueba.domain.model.*;

@Repository
public interface SolicitudesRepository {
	
	void registrarSolicitud(credit_requests sol);

	void dispersarSolicitud(Integer idSolicitud);


	void cambiarStatus(String idSolicitud, String nuevoEstatus);


	List<credit_requests> findByIdSolicitud(String idSolicitud);

}
