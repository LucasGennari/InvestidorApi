package com.gennari.investidor.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record AcaoRecordDTO(@NotBlank String nome,
                            @NotBlank String sigla,
                            @NotBlank String cnpj,
                            @NotBlank BigDecimal precoAtual) {
}
