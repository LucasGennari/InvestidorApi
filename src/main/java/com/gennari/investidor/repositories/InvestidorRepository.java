/* Projeto API-INVESTIDOR
 * Interface InvestidorRepository, criada em 12/07/2023
 * Lucas Gennari do Nascimento
 */

package com.gennari.investidor.repositories;

import com.gennari.investidor.models.InvestidorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface InvestidorRepository extends JpaRepository<InvestidorModel, UUID> {


}
