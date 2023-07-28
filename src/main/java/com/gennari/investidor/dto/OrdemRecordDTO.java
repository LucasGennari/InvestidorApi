/* Projeto API-INVESTIDOR
 * Record OrdemRecordDTO, criada em 27/07/2023
 * Lucas Gennari do Nascimento
 */
package com.gennari.investidor.dto;

import com.gennari.investidor.models.AcaoModel;
import com.gennari.investidor.models.InvestidorModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record OrdemRecordDTO(@NotBlank String status,
                             @NotBlank String tipo,
                             @NotNull BigDecimal preco
                             ) {

}
