/* Projeto API-INVESTIDOR
 * Classe OrdemService, criada em 28/07/2023
 * Lucas Gennari do Nascimento
 */
package com.gennari.investidor.services;

import com.gennari.investidor.models.OrdemModel;
import com.gennari.investidor.repositories.OrdemRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemService {

    final OrdemRepository ordemRepository;


    public OrdemService(OrdemRepository ordemRepository) {
        this.ordemRepository = ordemRepository;
    }

    @Transactional
    public OrdemModel save(OrdemModel ordemModel){
        return ordemRepository.save(ordemModel);
    }

    public List<OrdemModel> findAll(){
        return ordemRepository.findAll();
    }


}
