package dev.lptrk.pucai.service;

import dev.lptrk.pucai.model.PucaiEty;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public interface PucaiService {
    List<PucaiEty> findAll();
    List<PucaiEty> findAllByDateAfter(LocalDate date);
    PucaiEty findById(Long id);
    PucaiEty save(PucaiEty pucaiEty);
    PucaiEty updateById(Long id, PucaiEty pucaiEty);
    void deleteById(Long id);
}
