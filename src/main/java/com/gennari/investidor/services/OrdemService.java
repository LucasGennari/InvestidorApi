/* Projeto API-INVESTIDOR
 * Classe OrdemService, criada em 28/07/2023
 * Lucas Gennari do Nascimento
 */
package com.gennari.investidor.services;

import com.gennari.investidor.dto.OrdemRecordDTO;
import com.gennari.investidor.models.AcaoModel;
import com.gennari.investidor.models.InvestidorModel;
import com.gennari.investidor.models.OrdemModel;
import com.gennari.investidor.repositories.OrdemRepository;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrdemService {

    final OrdemRepository ordemRepository;
    final AcaoService acaoService;
    final InvestidorService investidorService;


    public OrdemService(OrdemRepository ordemRepository, AcaoService acaoService, InvestidorService investidorService) {
        this.ordemRepository = ordemRepository;
        this.acaoService = acaoService;
        this.investidorService = investidorService;
    }

    public OrdemModel create(UUID investidorId, UUID acaoId, OrdemRecordDTO ordemRecordDTO){

        var investidor = investidorService.findById(investidorId);
        var acao = acaoService.findById(acaoId);

        if(investidor.isEmpty() || acao.isEmpty()){
            return null;
        }

        var ordemModel = new OrdemModel();
        var investidorModel = investidor.get();
        var acaoModel = acao.get();

        BeanUtils.copyProperties(ordemRecordDTO, ordemModel);
        ordemModel.setInvestidorModel(investidorModel);
        ordemModel.setAcaoModel(acaoModel);
        ordemModel.setCriadoEm(LocalDateTime.now(ZoneId.of("UTC")));

        return ordemModel;
    }

    @Transactional
    public OrdemModel save(OrdemModel ordemModel){
        return ordemRepository.save(ordemModel);
    }

    public List<OrdemModel> findAll(){
        return ordemRepository.findAll();
    }


}
