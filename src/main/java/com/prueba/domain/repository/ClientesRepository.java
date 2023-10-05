package com.prueba.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.prueba.domain.model.Clientes;

public interface ClientesRepository {
	List<Clientes> obtenerCliente( String nombre,String apellido_paterno,  String apellido_materno);

}
