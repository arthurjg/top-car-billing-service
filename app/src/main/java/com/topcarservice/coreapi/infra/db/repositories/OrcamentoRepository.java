package com.topcarservice.coreapi.infra.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topcarservice.coreapi.infra.db.entities.OrcamentoDBEntity;

public interface OrcamentoRepository extends JpaRepository<OrcamentoDBEntity, Long> {

}
