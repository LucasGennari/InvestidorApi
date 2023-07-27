package com.gennari.investidor.services;

import com.gennari.investidor.models.InvestidorModel;
import com.gennari.investidor.repositories.InvestidorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InvestidorService {

    final InvestidorRepository investidorRepository;

    public InvestidorService(InvestidorRepository investidorRepository) {
        this.investidorRepository = investidorRepository;
    }

    @Transactional
    public InvestidorModel save(InvestidorModel investidorModel) {
        return investidorRepository.save(investidorModel);
    }

    public List<InvestidorModel> findAll() {
        return investidorRepository.findAll();
    }

    public Optional<InvestidorModel> findById(UUID id) {
        return investidorRepository.findById(id);
    }

    public void delete(InvestidorModel investidorModel) {
        investidorRepository.delete(investidorModel);
    }
}
