/* Projeto API-INVESTIDOR
 * Classe AcaoModel, criada em 12/07/2023
 * Lucas Gennari do Nascimento
 */

package com.gennari.investidor.models;


import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
/*ATENÇÃO:
 * Nesse projeto estou sempre colocando nome das tabelas no plural
 * e colunas no singular
 **/
@Table(name="acoes")
public class AcaoModel extends RepresentationModel<AcaoModel> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID acaoId;
    private String nome;
    private String sigla;
    private String cnpj;

    private BigDecimal precoAtual;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public UUID getAcaoId() {
        return acaoId;
    }

    public void setAcaoId(UUID acaoId) {
        this.acaoId = acaoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public BigDecimal getPrecoAtual() {
        return precoAtual;
    }

    public void setPrecoAtual(BigDecimal precoAtual) {
        this.precoAtual = precoAtual;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadaEm) {
        this.atualizadoEm = atualizadaEm;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }
}
