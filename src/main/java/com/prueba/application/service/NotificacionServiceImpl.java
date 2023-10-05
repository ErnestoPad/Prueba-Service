package com.prueba.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.application.usercases.NotificacionService;
import com.prueba.adapter.*;

@Service
public class NotificacionServiceImpl implements NotificacionService {

	@Autowired
	EmailService email;
	
	int Solicitud;

	final String mensajeNuevo = "Se ah registrado la solicitud: " + Solicitud;
	final String mensajeCambio = "Se ah modificacio el estatus de la solicitud" + Solicitud + " la solicitud: ";
	final String mensajeDispersado="Se ah dispersado la solicitud: "+Solicitud+ "Ah recibido una comision";

	@Override
	public void enviarNotificacion(boolean nueva, String idSolicitud) {
		if(nueva)
		email.enviarCorreo("", mensajeNuevo);
		else
			email.enviarCorreo("", mensajeCambio);
	}

}
