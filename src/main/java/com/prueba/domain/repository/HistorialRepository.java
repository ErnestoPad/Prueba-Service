package com.prueba.domain.repository;

import java.util.List;
import java.util.Optional;

import com.prueba.domain.model.credit_request_log;

public interface HistorialRepository {
	

	List<credit_request_log> error(String idSolicitud);

}
