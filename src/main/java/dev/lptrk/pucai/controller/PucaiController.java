package dev.lptrk.pucai.controller;

import dev.lptrk.pucai.model.PucaiEty;
import dev.lptrk.pucai.service.impl.PucaiServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController("api/v1/pucais")
@AllArgsConstructor
public class PucaiController {

    private final PucaiServiceImpl pucaiService;

    @GetMapping
    public ResponseEntity<List<PucaiEty>> findAll() {
        return ResponseEntity.ok(this.pucaiService.findAll());
    }

    @GetMapping("/last-year")
    public ResponseEntity<List<PucaiEty>> findAllFromLastYear() {
        return ResponseEntity.ok(this.pucaiService.findAllByDateAfter(LocalDateTime.now().minusYears(1).toLocalDate()));
    }

    @GetMapping("/last-month")
    public ResponseEntity<List<PucaiEty>> findAllFromLastMonth() {
        return ResponseEntity.ok(this.pucaiService.findAllByDateAfter(LocalDateTime.now().minusMonths(1).toLocalDate()));
    }

    @GetMapping("/last-week")
    public ResponseEntity<List<PucaiEty>> findAllFromLastWeek() {
        return ResponseEntity.ok(this.pucaiService.findAllByDateAfter(LocalDateTime.now().minusWeeks(1).toLocalDate()));
    }

    @GetMapping("/last-day")
    public ResponseEntity<List<PucaiEty>> findAllFromLastDay() {
        return ResponseEntity.ok(this.pucaiService.findAllByDateAfter(LocalDateTime.now().minusDays(1).toLocalDate()));
    }

    @PostMapping
    public ResponseEntity<PucaiEty> save(PucaiEty pucaiEty) {
        return ResponseEntity.ok(this.pucaiService.save(pucaiEty));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PucaiEty> updateById(Long id, PucaiEty pucaiEty) {
        return ResponseEntity.ok(this.pucaiService.updateById(id, pucaiEty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(Long id) {
        this.pucaiService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
