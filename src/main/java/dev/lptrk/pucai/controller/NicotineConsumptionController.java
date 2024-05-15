package dev.lptrk.pucai.controller;

import dev.lptrk.pucai.model.NicotineConsumptionEty;
import dev.lptrk.pucai.service.impl.NicotineConsumptionServiceImpl;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/nicotine-consumptions")
@AllArgsConstructor
public class NicotineConsumptionController {
    private final NicotineConsumptionServiceImpl nicotineConsumptionService;

    @GetMapping
    public ResponseEntity<List<NicotineConsumptionEty>> findAll() {
        return ResponseEntity.ok(nicotineConsumptionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NicotineConsumptionEty> findById(@PathVariable Long id) {
        return ResponseEntity.ok(nicotineConsumptionService.findById(id));
    }

    @GetMapping("/{consumptionDate}")
    public ResponseEntity<List<NicotineConsumptionEty>> findAllByConsumptionDate(@PathVariable Date consumptionDate) {
        return ResponseEntity.ok(nicotineConsumptionService.findAllByConsumptionDate(consumptionDate));
    }

    @PostMapping
    public ResponseEntity<NicotineConsumptionEty> save(NicotineConsumptionEty nicotineConsumptionEty) {
        return ResponseEntity.ok(nicotineConsumptionService.save(nicotineConsumptionEty));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NicotineConsumptionEty> updateById(@PathVariable Long id, @RequestBody NicotineConsumptionEty nicotineConsumptionEty) {
        return ResponseEntity.ok(nicotineConsumptionService.updateById(id, nicotineConsumptionEty));
    }

}
