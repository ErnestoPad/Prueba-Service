package com.prueba.application.usercases;

import org.springframework.stereotype.Service;

import com.prueba.domain.model.Solicitud;
import com.prueba.domain.model.credit_requests;
import com.prueba.exceptions.ClienteNotFoundEception;
import com.prueba.exceptions.SolicitudNotFoundExcepetion;
import com.prueba.domain.model.ActulizarStatusSolicitud;
import com.prueba.domain.model.Credito;


@Service
public interface SolicitudService {
	public credit_requests registrarSolicitud(credit_requests solicitudPeticion) throws ClienteNotFoundEception;
	public credit_requests actualizarSolicitudEstatus(ActulizarStatusSolicitud solicitudPeticion) throws SolicitudNotFoundExcepetion;
	public Credito dispersarCredito(Credito credito) throws SolicitudNotFoundExcepetion;

}
