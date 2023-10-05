package com.prueba.adapter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prueba.domain.model.credit_request_log;
import com.prueba.domain.repository.HistorialRepository;

public interface HistorialJpaRepository extends JpaRepository<credit_request_log, String>, HistorialRepository {

	@Override
	@Query("SELECT s from credit_request_log s where s.idSolicitud= :idSolicitud and s.idEstatus='ERR'")
	List<credit_request_log> error(@Param("idSolicitud")String idSolicitud);
}
