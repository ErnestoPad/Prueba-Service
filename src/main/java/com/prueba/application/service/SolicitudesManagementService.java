package com.prueba.application.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.adapter.CreditoJpaRepository;
import com.prueba.adapter.ClientesJpaRepository;
import com.prueba.adapter.HistorialJpaRepository;
import com.prueba.application.usercases.NotificacionService;
import com.prueba.application.usercases.SolicitudService;
import com.prueba.domain.model.Solicitud;
import com.prueba.domain.model.credit_requests;
import com.prueba.domain.repository.SolicitudesRepository;
import com.prueba.exceptions.ClienteNotFoundEception;
import com.prueba.exceptions.SolicitudNotFoundExcepetion;
import com.prueba.domain.model.*;

@Service
public class SolicitudesManagementService implements SolicitudService {
	@Autowired
	SolicitudesRepository solicitudesRepo;

	@Autowired
	NotificacionService notificaciones;

	@Autowired
	HistorialJpaRepository historialRepo;

	@Autowired
	ClientesJpaRepository clienteRepo;

	@Autowired
	CreditoJpaRepository creditoRepo;

	@Override
	public credit_requests registrarSolicitud(credit_requests peticion) throws ClienteNotFoundEception {
		if (clienteRepo.obtenerCliente(peticion.getNombre(), peticion.getApellido_paterno(), peticion.getApellido_materno()) != null) {
			solicitudesRepo.registrarSolicitud(peticion);
				notificaciones.enviarNotificacion(true, peticion.getIdSolicitud());
				credit_request_log historial = new credit_request_log();
				historial.setFecha(new Timestamp(System.currentTimeMillis()));
				historial.setIdSolicitud(peticion.getIdSolicitud());
				historial.setIdEstatus("NEW");
				historialRepo.save(historial);
				return peticion;
			} else {
				return null;
			}
		
	}

	@Override
	public credit_requests actualizarSolicitudEstatus(ActulizarStatusSolicitud actualizacion)
			throws SolicitudNotFoundExcepetion {
		List<credit_requests> solicitud = solicitudesRepo.findByIdSolicitud(actualizacion.getIdSolicitud());
		if (solicitud != null) {
			solicitudesRepo.cambiarStatus(actualizacion.getIdSolicitud(), actualizacion.getIdEstatus());
			credit_request_log historial = new credit_request_log();
			historial.setFecha(new Timestamp(System.currentTimeMillis()));
			historial.setIdSolicitud(actualizacion.getIdSolicitud());
			historial.setIdEstatus(actualizacion.getIdEstatus());
			historialRepo.save(historial);
			notificaciones.enviarNotificacion(false, actualizacion.getIdSolicitud());
			return solicitud.get(0);
		} else {
			throw new SolicitudNotFoundExcepetion();
		}
	}

	@Override
	public Credito dispersarCredito(Credito credito) throws SolicitudNotFoundExcepetion {
		List<credit_requests> solicitud = solicitudesRepo.findByIdSolicitud(credito.getIdSolicitud());
		if (solicitud != null) {
			creditoRepo.save(credito);
			solicitudesRepo.cambiarStatus(credito.getIdSolicitud(), "DSP");
			if (historialRepo.error(credito.getIdSolicitud()) != null) {
				credit_request_log historial = new credit_request_log();
				historial.setFecha(new Timestamp(System.currentTimeMillis()));
				historial.setIdSolicitud(credito.getIdSolicitud());
				historial.setIdEstatus("DSP");
				historialRepo.save(historial);
				notificaciones.enviarNotificacion(false, credito.getIdSolicitud());
			} else {
				solicitud = solicitudesRepo.findByIdSolicitud(credito.getIdSolicitud());

			}
			return credito;
		} else {
			throw new SolicitudNotFoundExcepetion();
		}
	}

}
