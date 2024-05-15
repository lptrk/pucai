package dev.lptrk.pucai.dao;

import dev.lptrk.pucai.model.NicotineConsumptionEty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NicotineConsumptionRepository extends JpaRepository<NicotineConsumptionEty, Long>{
    List<NicotineConsumptionEty> findAllByConsumptionDate(Date consumptionDate);
}
