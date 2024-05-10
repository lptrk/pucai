package dev.lptrk.pucai.service.impl;

import dev.lptrk.pucai.dao.MealsRepository;
import dev.lptrk.pucai.model.MealEty;
import dev.lptrk.pucai.service.MealsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealsServiceImpl implements MealsService {
    private final MealsRepository mealsRepository;

    public MealsServiceImpl(MealsRepository mealsRepository) {
        this.mealsRepository = mealsRepository;
    }

    @Override
    public List<MealEty> findAll() {
        return mealsRepository.findAll();
    }

    @Override
    public List<MealEty> findAllByMealName(String mealName) {
        return mealsRepository.findAllByMealName(mealName);
    }

    @Override
    public List<MealEty> findAllByIngredientsContaining(String ingredient) {
        return mealsRepository.findAllByIngredientsContaining(ingredient);
    }

    @Override
    public List<MealEty> findAllByIngredientsIn(List<String> ingredients) {
        return mealsRepository.findAllByIngredientsIn(ingredients);
    }

    @Override
    public MealEty findById(Long id) {
        return mealsRepository.findById(id).orElse(null);
    }

    @Override
    public MealEty updateById(Long id, MealEty mealEty) {
        mealEty.setMealId(id);
        return mealsRepository.save(mealEty);
    }

    @Override
    public void deleteById(Long id) {
        mealsRepository.deleteById(id);
    }

    @Override
    public MealEty save(MealEty mealEty) {
        return mealsRepository.save(mealEty);
    }
}
