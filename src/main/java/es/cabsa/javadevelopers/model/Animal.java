package es.cabsa.javadevelopers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "food"})
public class Animal {
    @Id
    @NotNull
    private int id;

    @Column(columnDefinition = "VARCHAR(50)")
    @NotNull
    private String name;

    @NotNull
    private int legs;

    @ManyToMany(mappedBy = "animals")
    private Set<Food> food = new HashSet<>();

    public Animal(int id, String name, int legs) {
        this.id = id;
        this.name = name;
        this.legs = legs;
    }

    public Animal() {
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

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public Set<Food> getFood() {
        return food;
    }

    public void setFood(Set<Food> food) {
        this.food = food;
    }
}
