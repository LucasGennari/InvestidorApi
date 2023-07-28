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



    public OrdemController(OrdemService ordemService) {
        this.ordemService = ordemService;

    }

    @PostMapping("/ordens/{investidorId}/{acaoId}")
    public ResponseEntity<Object> saveOrdem(@PathVariable UUID investidorId,
                                                @PathVariable UUID acaoId,
                                                @RequestBody @Valid OrdemRecordDTO ordemRecordDTO){

              var ordemModel = ordemService.create(investidorId, acaoId, ordemRecordDTO);

              if(ordemModel == null){

                  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Investidor ou ação inexistente");
              } else{

                  return ResponseEntity.status(HttpStatus.OK).body(ordemService.save(ordemModel));
              }

        }



    @GetMapping("/ordens")
    public ResponseEntity<List<OrdemModel>> getAllOrdens(){
        return ResponseEntity.status(HttpStatus.OK).body(ordemService.findAll());
    }

}
