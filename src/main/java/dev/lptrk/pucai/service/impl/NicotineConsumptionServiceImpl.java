package dev.lptrk.pucai.service.impl;

import dev.lptrk.pucai.dao.NicotineConsumptionRepository;
import dev.lptrk.pucai.model.NicotineConsumptionEty;
import dev.lptrk.pucai.service.NicotineConsumptionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class NicotineConsumptionServiceImpl implements NicotineConsumptionService {
    private final NicotineConsumptionRepository nicotineConsumptionRepository;

    @Override
    public List<NicotineConsumptionEty> findAll() {
        return this.nicotineConsumptionRepository.findAll();
    }

    @Override
    public List<NicotineConsumptionEty> findAllByConsumptionDate(Date consumptionDate) {
        return this.nicotineConsumptionRepository.findAllByConsumptionDate(consumptionDate);
    }

    @Override
    public NicotineConsumptionEty findById(Long id) {
        return this.nicotineConsumptionRepository.findById(id).orElse(null);
    }

    @Override
    public NicotineConsumptionEty updateById(Long id, NicotineConsumptionEty nicotineConsumptionEty) {
        NicotineConsumptionEty consumptionToUpdate = this.nicotineConsumptionRepository.findById(id).orElse(null);
        if (consumptionToUpdate == null) {
            return null;
        }
        consumptionToUpdate.setConsumptionType(nicotineConsumptionEty.getConsumptionType());
        consumptionToUpdate.setConsumptionDate(nicotineConsumptionEty.getConsumptionDate());
        consumptionToUpdate.setAmount(nicotineConsumptionEty.getAmount());
        return this.nicotineConsumptionRepository.save(consumptionToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        this.nicotineConsumptionRepository.deleteById(id);
    }

    @Override
    public NicotineConsumptionEty save(NicotineConsumptionEty nicotineConsumptionEty) {
        return this.nicotineConsumptionRepository.save(nicotineConsumptionEty);
    }
}
