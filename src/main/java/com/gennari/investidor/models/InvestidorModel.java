/* Projeto API-INVESTIDOR
* Classe InvestidorModel, criada em 12/07/2023
* Lucas Gennari do Nascimento
*/

package com.gennari.investidor.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
/*ATENÇÃO:
 * Nesse projeto estou sempre colocando nome das tabelas no plural
 * e colunas no singular
 **/
@Table(name="investidores")
public class InvestidorModel extends RepresentationModel<InvestidorModel> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID investidorId;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String perfil;

    private LocalDateTime criadoEm;

    private LocalDateTime atualizadoEm;


    public UUID getInvestidorId() {
        return investidorId;
    }

    public void setInvestidorId(UUID investidorId) {
        this.investidorId = investidorId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
