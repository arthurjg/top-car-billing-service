package com.topcarservice.coreapi.infra.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topcarservice.coreapi.infra.db.entities.PagamentoDBEntity;

public interface PagamentoRepository extends JpaRepository<PagamentoDBEntity, Long> {

}
