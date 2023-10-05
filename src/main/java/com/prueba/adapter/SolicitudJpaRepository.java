package com.prueba.adapter;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.domain.model.Solicitud;
import com.prueba.domain.model.credit_requests;
import com.prueba.domain.repository.SolicitudesRepository;


public interface SolicitudJpaRepository extends JpaRepository<credit_requests, String>, SolicitudesRepository {
    List<credit_requests> findByIdSolicitud(String idSolicitud);
    
    default void registrarSolicitud(credit_requests sol) {
    	this.save(sol);
    }

	@Override
	@Modifying
	@Query("UPDATE credit_requests s SET s.idStatus = 'DISP' WHERE s.idSolicitud = :idSolicitud")
	void dispersarSolicitud(@Param("idSolicitud") Integer idSolicitud);

	@Override
	@Modifying
	@Query("UPDATE credit_requests s SET s.idStatus = :idStatus WHERE s.idSolicitud = :idSolicitud")
	void cambiarStatus(@Param("idSolicitud") String solicitudId, @Param("idStatus") String idStatus);

}
