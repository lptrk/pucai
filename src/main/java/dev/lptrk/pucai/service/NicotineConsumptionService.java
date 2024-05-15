package dev.lptrk.pucai.service;

import dev.lptrk.pucai.model.NicotineConsumptionEty;

import java.util.Date;
import java.util.List;

public interface NicotineConsumptionService {
    List<NicotineConsumptionEty> findAll();
    List<NicotineConsumptionEty> findAllByConsumptionDate(Date consumptionDate);
    NicotineConsumptionEty findById(Long id);
    NicotineConsumptionEty save(NicotineConsumptionEty nicotineConsumptionEty);
    NicotineConsumptionEty updateById(Long id, NicotineConsumptionEty nicotineConsumptionEty);
    void deleteById(Long id);

}
