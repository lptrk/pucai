package dev.lptrk.pucai.controller;

import dev.lptrk.pucai.model.PucaiEty;
import dev.lptrk.pucai.service.impl.PucaiServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/pucais")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class PucaiController {

    private final PucaiServiceImpl pucaiService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<PucaiEty>> findAll() {
        return ResponseEntity.ok(this.pucaiService.findAll());
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/last-year")
    public ResponseEntity<List<PucaiEty>> findAllFromLastYear() {
        return ResponseEntity.ok(this.pucaiService.findAllByDateAfter(LocalDateTime.now().minusYears(1).toLocalDate()));
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/last-month")
    public ResponseEntity<List<PucaiEty>> findAllFromLastMonth() {
        return ResponseEntity.ok(this.pucaiService.findAllByDateAfter(LocalDateTime.now().minusMonths(1).toLocalDate()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/last-week")
    public ResponseEntity<List<PucaiEty>> findAllFromLastWeek() {
        return ResponseEntity.ok(this.pucaiService.findAllByDateAfter(LocalDateTime.now().minusWeeks(1).toLocalDate()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/last-day")
    public ResponseEntity<List<PucaiEty>> findAllFromLastDay() {
        return ResponseEntity.ok(this.pucaiService.findAllByDateAfter(LocalDateTime.now().minusDays(1).toLocalDate()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<PucaiEty> save(@RequestBody PucaiEty pucaiEty) {
        return ResponseEntity.ok(this.pucaiService.save(pucaiEty));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public ResponseEntity<PucaiEty> updateById(@PathVariable Long id,@RequestBody PucaiEty pucaiEty) {
        return ResponseEntity.ok(this.pucaiService.updateById(id, pucaiEty));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.pucaiService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
