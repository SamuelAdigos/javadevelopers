package es.cabsa.javadevelopers.services;

import es.cabsa.javadevelopers.dao.AnimalDto;
import es.cabsa.javadevelopers.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    @Autowired
    private AnimalDto animalDto;

    public Animal save(Animal animal){
        return animalDto.save(animal);
    }

    public List<Animal> searchAnimals(String search){
        return animalDto.findAllByNameContains( search);
    }

    public List<Animal> getAll(){
        return animalDto.findAll();
    }

    public boolean existsByName(String name){
        return animalDto.existsByName(name);
    }

    public boolean existsById(int id){
        return animalDto.existsById(id);
    }
}
