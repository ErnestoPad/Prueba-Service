package com.prueba.adapter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.application.service.SolicitudesManagementService;
import com.prueba.domain.model.credit_requests;
import com.prueba.exceptions.ClienteNotFoundEception;

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
	    public void registrarSolicitud(@RequestBody credit_requests solicitudDto) {
		   try {
			solicitudesService.registrarSolicitud(solicitudDto);
		} catch (ClienteNotFoundEception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }


}
