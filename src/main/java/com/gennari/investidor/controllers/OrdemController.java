/* Projeto API-INVESTIDOR
 * Classe OrdemController, criada em 28/07/2023
 * Lucas Gennari do Nascimento
 */
package com.gennari.investidor.controllers;

import com.gennari.investidor.dto.OrdemRecordDTO;
import com.gennari.investidor.models.AcaoModel;
import com.gennari.investidor.models.InvestidorModel;
import com.gennari.investidor.models.OrdemModel;
import com.gennari.investidor.services.AcaoService;
import com.gennari.investidor.services.InvestidorService;
import com.gennari.investidor.services.OrdemService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class OrdemController {

    final OrdemService ordemService;
    final InvestidorService investidorService;
    final AcaoService acaoService;


    public OrdemController(OrdemService ordemService, InvestidorService investidorService, AcaoService acaoService) {
        this.ordemService = ordemService;
        this.investidorService = investidorService;
        this.acaoService = acaoService;
    }

    @PostMapping("/ordens/{investidorId}/{acaoId}")
    public ResponseEntity<Object> saveOrdem(@PathVariable UUID investidorId,
                                                @PathVariable UUID acaoId,
                                                @RequestBody @Valid OrdemRecordDTO ordemRecordDTO){
        Optional<InvestidorModel> investidor = investidorService.findById(investidorId);
        Optional<AcaoModel> acao = acaoService.findById(acaoId);
        if(investidor.isEmpty() && acao.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Investidor ou ação não encontrada");

        } else{
              var ordemModel = new OrdemModel();
              var investidorModel = investidor.get();
              var acaoModel = acao.get();

              BeanUtils.copyProperties(ordemRecordDTO, ordemModel);

              ordemModel.setInvestidorModel(investidorModel);
              ordemModel.setAcaoModel(acaoModel);
              ordemModel.setCriadoEm(LocalDateTime.now(ZoneId.of("UTC")));

              return ResponseEntity.status(HttpStatus.OK).body(ordemService.save(ordemModel));

        }

    }

    @GetMapping
    public ResponseEntity<List<OrdemModel>> getAllOrdens(){
        return ResponseEntity.status(HttpStatus.OK).body(ordemService.findAll());
    }

}
