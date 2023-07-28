/* Projeto API-INVESTIDOR
 * Classe OrdemModel, criada em 14/07/2023
 * Lucas Gennari do Nascimento
 */
package com.gennari.investidor.models;

import com.gennari.investidor.dto.AcaoRecordDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="ordens")
public class OrdemModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ordemId;

    private String status;
    private String tipo;
    private BigDecimal preco;
    private LocalDateTime criadoEm;


    @ManyToOne
    @JoinColumn(name = "investidor_id")
    private InvestidorModel investidorModel;

    @ManyToOne
    @JoinColumn(name = "acao_id")
    private AcaoModel acaoModel;

    private LocalDateTime atualizadoEm;

    public UUID getOrdemId() {
        return ordemId;
    }

    public void setOrdemId(UUID ordemId) {
        this.ordemId = ordemId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public InvestidorModel getInvestidorModel() {
        return investidorModel;
    }

    public void setInvestidorModel(InvestidorModel investidorModel) {
        this.investidorModel = investidorModel;
    }

    public AcaoModel getAcaoModel() {
        return acaoModel;
    }

    public void setAcaoModel(AcaoModel acaoModel) {
        this.acaoModel = acaoModel;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
