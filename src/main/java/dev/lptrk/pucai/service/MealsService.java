package dev.lptrk.pucai.service;

import dev.lptrk.pucai.model.MealEty;

import java.util.List;

public interface MealsService {
    public List<MealEty> findAll();
    public MealEty findById(Long id);
    public MealEty updateById(Long id, MealEty mealEty);
    public void deleteById(Long id);
    public MealEty save(MealEty mealEty);
}
