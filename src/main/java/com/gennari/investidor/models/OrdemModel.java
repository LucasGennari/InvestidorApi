/* Projeto API-INVESTIDOR
 * Classe OrdemModel, criada em 14/07/2023
 * Lucas Gennari do Nascimento
 */
package com.gennari.investidor.models;

import com.gennari.investidor.dto.AcaoRecordDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="ordens")
public class OrdemModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ordemId;

    private String status;

    @ManyToOne
    @JoinColumn(name = "investidor_id")
    private InvestidorModel investidorModel;

    @ManyToOne
    @JoinColumn(name = "acao_id")
    private AcaoModel acaoModel;

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
}
