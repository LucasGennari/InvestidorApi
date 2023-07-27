package com.gennari.investidor.repositories;

import com.gennari.investidor.models.OrdemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrdemRepository extends JpaRepository<OrdemModel, UUID> {
}
