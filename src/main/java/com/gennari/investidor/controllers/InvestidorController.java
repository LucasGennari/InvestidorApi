/* Projeto API-INVESTIDOR
 * Classe InvestidorController, criada em 12/07/2023
 * Lucas Gennari do Nascimento
 */

package com.gennari.investidor.controllers;

import com.gennari.investidor.dto.InvestidorRecordDTO;
import com.gennari.investidor.models.InvestidorModel;
import com.gennari.investidor.repositories.InvestidorRepository;
import com.gennari.investidor.services.InvestidorService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/investidores")
public class InvestidorController {

   final InvestidorService investidorService;

    public InvestidorController(InvestidorService investidorService) {
        this.investidorService = investidorService;
    }


    @PostMapping
    public ResponseEntity<InvestidorModel> saveInvestidor(@RequestBody @Valid InvestidorRecordDTO investidorDTO){
        var investidorModel = new InvestidorModel();
        BeanUtils.copyProperties(investidorDTO, investidorModel);
        investidorModel.setCriadoEm(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(investidorService.save(investidorModel));
    }


    @GetMapping
    public ResponseEntity<List<InvestidorModel>> getAllInvestidores(){
        return ResponseEntity.status(HttpStatus.OK).body(investidorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneInvestidor(@PathVariable(value="id") UUID id){
        Optional<InvestidorModel> investidor = investidorService.findById(id);
        if(investidor.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Investidor inexistente");

        }
        return ResponseEntity.status(HttpStatus.OK).body(investidor.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateInvestidor(@PathVariable(value="id") UUID id,
                                                   @RequestBody InvestidorRecordDTO investidorRecordDTO){
        Optional<InvestidorModel> investidor = investidorService.findById(id);
        if(investidor.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Investidor inexistente");

        }
        //System.out.println(investidor.get().getNome());
        var investidorModel = investidor.get();
        BeanUtils.copyProperties(investidorRecordDTO, investidorModel);
        investidorModel.setAtualizadoEm(LocalDateTime.now(ZoneId.of("UTC")));

        //return ResponseEntity.status(HttpStatus.OK).body(investidorModel);
        return ResponseEntity.status(HttpStatus.OK).body(investidorService.save(investidorModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteInvestidor(@PathVariable(value="id") UUID id){
        Optional<InvestidorModel> investidor = investidorService.findById(id);
        if(investidor.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Investidor inexistente");

        }
        investidorService.delete(investidor.get());
        return ResponseEntity.status(HttpStatus.OK).body("Investidor deletado");
    }
}
