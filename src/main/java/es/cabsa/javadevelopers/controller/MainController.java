package es.cabsa.javadevelopers.controller;

import com.jungle.jungle.dto.Search;
import com.jungle.jungle.model.Animal;
import com.jungle.jungle.model.Food;
import com.jungle.jungle.services.AnimalService;
import com.jungle.jungle.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MainController {
  @Autowired
  private AnimalService animalService;

  @Autowired
  private FoodService foodService;

  @GetMapping("/animals")
  public Object getAllAnimals(){
    return animalService.getAll();
  }

  @GetMapping("/food")
  public Object getAllFood(){
    return foodService.getAll();
  }

  @PostMapping("/create-food")
  public Object createFood(@Valid @RequestBody Food food, BindingResult bindingResult){
    if (bindingResult.hasErrors()) return bindingResult.getAllErrors();

    if (foodService.existsByName(food.getName())) return "Food with this name exists";

    if (foodService.existsById(food.getId())) return "Food with this id exists";

    return foodService.save(food);
  }

  @PostMapping("/search")
  public Object searchAnimals(@Valid @RequestBody Search search, BindingResult bindingResult){
    if (bindingResult.hasErrors()) return bindingResult.getAllErrors();

    List<Animal> animals = animalService.searchAnimals(search.getSearchTerm());

    System.out.println("an" + animals.size());

    List<Food> foods = foodService.searchFood(search.getSearchTerm());

    System.out.println("food: " + foods.size());

    foods.forEach(food -> {
      food.getAnimals().forEach(animal -> {
        if (!animals.contains(animal)) animals.add(animal);
      });
    });

    return animals;
  }

  @PostMapping("/create-animal")
  public Object createAnimal(@Valid @RequestBody Animal animal, BindingResult bindingResult){
    if (bindingResult.hasErrors()) return bindingResult.getAllErrors();

    if (animalService.existsByName(animal.getName())) return "Animal with this name exists";

    if (animalService.existsById(animal.getId())) return "Animal with this id exists";

    return animalService.save(animal);
  }
}
