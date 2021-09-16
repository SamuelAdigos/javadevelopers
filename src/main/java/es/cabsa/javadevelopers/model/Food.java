package es.cabsa.javadevelopers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "animals"})
public class Food {
    @Id
    @NotNull
    private int id;

    @Column(columnDefinition = "VARCHAR(50)")
    @NotNull
    private String name;

    @ManyToMany
    private Set<com.jungle.jungle.model.Animal> animals = new HashSet<>();

    public Food() {
    }

    public Food(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<com.jungle.jungle.model.Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<com.jungle.jungle.model.Animal> animals) {
        this.animals = animals;
    }
}
