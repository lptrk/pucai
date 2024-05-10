package dev.lptrk.pucai.controller;

import dev.lptrk.pucai.model.MealEty;
import dev.lptrk.pucai.service.impl.MealsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/meals")
public class MealsController {
    private final MealsServiceImpl mealsService;

    public MealsController(MealsServiceImpl mealsService) {
        this.mealsService = mealsService;
    }

    @GetMapping
    public ResponseEntity<List<MealEty>> findAll() {
        return ResponseEntity.ok(mealsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MealEty> findById(@PathVariable Long id) {
        return ResponseEntity.ok(mealsService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<MealEty>> findMealsByName(@RequestParam(required = false) String name) {
        if (name != null) {
            List<MealEty> meals = mealsService.findAllByMealName(name);
            return ResponseEntity.ok(meals);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<MealEty>> findMealsByIngredient(@RequestParam String ingredient) {
        List<MealEty> meals = mealsService.findAllByIngredientsContaining(ingredient);
        return ResponseEntity.ok(meals);
    }

    @GetMapping("/")
    public ResponseEntity<List<MealEty>> findMealsByIngredients(@RequestParam List<String> ingredients) {
        List<MealEty> meals = mealsService.findAllByIngredientsIn(ingredients);
        return ResponseEntity.ok(meals);
    }

    @PostMapping
    public ResponseEntity<MealEty> save(@RequestBody MealEty mealEty) {
        return ResponseEntity.ok(mealsService.save(mealEty));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MealEty> updateById(@PathVariable Long id, @RequestBody MealEty mealEty) {
        return ResponseEntity.ok(mealsService.updateById(id, mealEty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(Long id) {
        mealsService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
