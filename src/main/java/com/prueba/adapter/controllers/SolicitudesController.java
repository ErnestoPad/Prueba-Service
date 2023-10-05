package com.prueba.adapter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.application.service.SolicitudesManagementService;
import com.prueba.domain.model.ActulizarStatusSolicitud;
import com.prueba.domain.model.Credito;
import com.prueba.domain.model.credit_requests;
import com.prueba.exceptions.ClienteNotFoundEception;
import com.prueba.exceptions.SolicitudNotFoundExcepetion;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/solicitudes")
@Api(tags = "Solicitudes")
public class SolicitudesController {
	
	@Autowired
	SolicitudesManagementService solicitudesService;
	
	   @PostMapping
	    @ApiOperation(value = "Registrar una nueva solicitud")
	    public ResponseEntity<Object> registrarSolicitud(@RequestBody credit_requests solicitudDto) {
		   try {
			solicitudesService.registrarSolicitud(solicitudDto);
			return new ResponseEntity<>(solicitudDto, HttpStatusCode.valueOf(200));
		} catch (ClienteNotFoundEception e) {
			return new ResponseEntity<>(HttpStatusCode.valueOf(401));
		}
	    }
	   @PostMapping
	    @ApiOperation(value = "Dispersar una solicitud")
	    public ResponseEntity<Object> DispersarSolicitud(@RequestBody Credito credito) {
		   try {
			solicitudesService.dispersarCredito(credito);
			return new ResponseEntity<>(credito, HttpStatusCode.valueOf(200));
		} catch (SolicitudNotFoundExcepetion e) {
			return new ResponseEntity<>(HttpStatusCode.valueOf(401));

		}
	    }
	   @PostMapping
	    @ApiOperation(value = "Actualizar una solicitud")
	    public ResponseEntity<Object> actualizarEstatus(@RequestBody ActulizarStatusSolicitud atalizacion) {
		   try {
			solicitudesService.actualizarSolicitudEstatus(atalizacion);
			return new ResponseEntity<>(atalizacion, HttpStatusCode.valueOf(200));
		} catch (SolicitudNotFoundExcepetion e) {
			return new ResponseEntity<>(HttpStatusCode.valueOf(401));
		}
	    }
}
