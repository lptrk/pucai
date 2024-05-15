package dev.lptrk.pucai.service.impl;

import dev.lptrk.pucai.dao.PucaiRepository;
import dev.lptrk.pucai.model.PucaiEty;
import dev.lptrk.pucai.service.PucaiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class PucaiServiceImpl implements PucaiService {

    private final PucaiRepository pucaiRepository;

    @Override
    public List<PucaiEty> findAll() {
        return this.pucaiRepository.findAll();
    }

    @Override
    public List<PucaiEty> findAllByDateAfter(LocalDate date) {
        return this.pucaiRepository.findAllByDateAfter(date);
    }

    @Override
    public PucaiEty findById(Long id) {
        return this.pucaiRepository.findById(id).orElse(null);
    }

    @Override
    public PucaiEty save(PucaiEty pucaiEty) {
        return this.pucaiRepository.save(pucaiEty);
    }

    @Override
    public PucaiEty updateById(Long id, PucaiEty pucaiEty) {
        var pucaiToUpdate = this.pucaiRepository.findById(id).orElse(null);
        pucaiToUpdate = pucaiEty;
        return this.pucaiRepository.save(pucaiToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        this.pucaiRepository.deleteById(id);
    }
}
