package es.cabsa.javadevelopers.services;

import es.cabsa.javadevelopers.dao.FoodDto;
import es.cabsa.javadevelopers.model.Animal;
import es.cabsa.javadevelopers.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodDto foodDto;

    public Food save(Food food){
        return foodDto.save(food);
    }

    public List<Food> getAll(){
        return foodDto.findAll();
    }

    public List<Food> searchFood(String search){
        return foodDto.findAllByNameContains( search);
    }

    public boolean existsByName(String name){
        return foodDto.existsByName(name);
    }

    public boolean existsById(int id){
        return foodDto.existsById(id);
    }
}
