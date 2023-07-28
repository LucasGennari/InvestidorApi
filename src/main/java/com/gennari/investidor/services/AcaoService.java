/* Projeto API-INVESTIDOR
 * Classe AcaoService, criada em 13/07/2023
 * Lucas Gennari do Nascimento
 */
package com.gennari.investidor.services;

import com.gennari.investidor.models.AcaoModel;
import com.gennari.investidor.repositories.AcaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AcaoService {
    final AcaoRepository acaoRepository;

    public AcaoService(AcaoRepository acaoRepository) {
        this.acaoRepository = acaoRepository;
    }

    @Transactional
    public AcaoModel save(AcaoModel acaoModel){
        return acaoRepository.save(acaoModel);
    }
    public List<AcaoModel> findAll(){
        return acaoRepository.findAll();
    }

    public Optional<AcaoModel> findById(UUID id){
        return acaoRepository.findById(id);
    }

    public void delete(AcaoModel acaoModel){
        acaoRepository.delete(acaoModel);
    }

}
