package dev.lptrk.pucai.dao;

import dev.lptrk.pucai.model.MealEty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealsRepository extends JpaRepository<MealEty, Long> {

}
