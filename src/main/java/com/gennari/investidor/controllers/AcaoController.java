/* Projeto API-INVESTIDOR
 * Classe AcaoController, criada em 27/07/2023
 * Lucas Gennari do Nascimento
 */
package com.gennari.investidor.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import com.gennari.investidor.dto.AcaoRecordDTO;
import com.gennari.investidor.models.AcaoModel;
import com.gennari.investidor.services.AcaoService;
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
@RequestMapping("/acoes")
public class AcaoController {

    final AcaoService acaoService;


    public AcaoController(AcaoService acaoService) {
        this.acaoService = acaoService;
    }

    @PostMapping
    public ResponseEntity<AcaoModel> saveAcao(@RequestBody @Valid AcaoRecordDTO acaoRecordDTO){
        var acaoModel = new AcaoModel();
        BeanUtils.copyProperties(acaoRecordDTO, acaoModel);
        acaoModel.setCriadoEm(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(acaoService.save(acaoModel));
    }

    @GetMapping
    public ResponseEntity<List<AcaoModel>> getAllAcoes(){
        List<AcaoModel> acaoList = acaoService.findAll();
        if(!acaoList.isEmpty()){
            for(AcaoModel acao : acaoList){
                UUID id = acao.getAcaoId();
                acao.add(linkTo(methodOn(AcaoController.class).getOneAcao(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(acaoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneAcao(@PathVariable(value="id") UUID id){
        Optional<AcaoModel> acao = acaoService.findById(id);
        if(acao.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ação inexistente");
        }
        acao.get().add(linkTo(methodOn(AcaoController.class).getAllAcoes()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(acao.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAcao(@PathVariable(value="id") UUID id,
                                                   @RequestBody AcaoRecordDTO acaoRecordDTO){
        Optional<AcaoModel> acao = acaoService.findById(id);
        if(acao.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ação inexistente");

        }
        var acaoModel = acao.get();
        BeanUtils.copyProperties(acaoRecordDTO, acaoModel);
        acaoModel.setAtualizadoEm(LocalDateTime.now(ZoneId.of("UTC")));

        //return ResponseEntity.status(HttpStatus.OK).body(investidorModel);
        return ResponseEntity.status(HttpStatus.OK).body(acaoService.save(acaoModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAcao(@PathVariable(value="id") UUID id){
        Optional<AcaoModel> acao = acaoService.findById(id);
        if(acao.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ação inexistente");

        }
        acaoService.delete(acao.get());
        return ResponseEntity.status(HttpStatus.OK).body("Ação deletada");
    }
}
