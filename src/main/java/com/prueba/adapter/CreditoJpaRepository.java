package com.prueba.adapter;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.domain.model.Credito;
import com.prueba.domain.repository.CreditoRepository;

public interface CreditoJpaRepository extends JpaRepository<Credito, Long>,CreditoRepository {

}
