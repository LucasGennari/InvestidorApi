/* Projeto API-INVESTIDOR
 * Record InvestidorRecordDto, criada em 12/07/2023
 * Lucas Gennari do Nascimento
 */

package com.gennari.investidor.dto;

import jakarta.validation.constraints.NotBlank;


import java.time.LocalDateTime;
import java.util.UUID;


public record InvestidorRecordDTO(@NotBlank String nome, @NotBlank String sobrenome,
                                  String cpf, String perfil) {

}
