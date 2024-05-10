package dev.lptrk.pucai.dao;

import dev.lptrk.pucai.model.MealEty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealsRepository extends JpaRepository<MealEty, Long> {
    List<MealEty> findAllByMealName(String mealName);

    List<MealEty> findAllByIngredientsContaining(String ingredient);


    List<MealEty> findAllByIngredientsIn(List<String> ingredients);
}
