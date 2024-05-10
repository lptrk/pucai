package dev.lptrk.pucai.service;

import dev.lptrk.pucai.model.MealEty;

import java.util.List;

public interface MealsService {
    List<MealEty> findAll();
    MealEty findById(Long id);
    MealEty updateById(Long id, MealEty mealEty);
    void deleteById(Long id);
    MealEty save(MealEty mealEty);
}
