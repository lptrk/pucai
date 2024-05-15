package dev.lptrk.pucai.dao;

import dev.lptrk.pucai.model.PucaiEty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PucaiRepository extends JpaRepository<PucaiEty, Long> {
    List<PucaiEty> findAllByDateAfter(LocalDate date);
}
