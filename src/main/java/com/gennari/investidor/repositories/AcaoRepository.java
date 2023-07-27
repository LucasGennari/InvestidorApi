package com.gennari.investidor.repositories;

import com.gennari.investidor.models.AcaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AcaoRepository extends JpaRepository<AcaoModel, UUID> {
}
