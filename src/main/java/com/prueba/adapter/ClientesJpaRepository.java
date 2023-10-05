package com.prueba.adapter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prueba.domain.model.Clientes;
import com.prueba.domain.repository.ClientesRepository;

public interface ClientesJpaRepository extends JpaRepository<Clientes, String>, ClientesRepository{

	@Query("Select s from Clientes s where s.nombre=:nombre and s.apellido_paterno=:apellido_paterno and s.apellido_materno=:apellido_materno")
	List<Clientes> obtenerCliente(@Param("nombre") String nombre, @Param("apellido_paterno") String apellido_paterno,@Param("apellido_materno")  String apellido_materno);
}
