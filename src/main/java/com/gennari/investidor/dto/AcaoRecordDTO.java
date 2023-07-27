/* Projeto API-INVESTIDOR
 * Record AcaoRecordDTO, criada em 13/07/2023
 * Lucas Gennari do Nascimento
 */
package com.gennari.investidor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record AcaoRecordDTO(@NotBlank String nome,
                            @NotBlank String sigla,
                            @NotBlank String cnpj,
                            @NotNull BigDecimal precoAtual) {
}
