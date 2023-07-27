package com.gennari.investidor.services;

import com.gennari.investidor.models.AcaoModel;
import com.gennari.investidor.repositories.AcaoRepository;
import org.springframework.stereotype.Service;

@Service
public class AcaoService {
    final AcaoRepository acaoRepository;

    public AcaoService(AcaoRepository acaoRepository) {
        this.acaoRepository = acaoRepository;
    }

    public AcaoModel save(AcaoModel acaoModel){
        return acaoRepository.save(acaoModel);
    }

}
