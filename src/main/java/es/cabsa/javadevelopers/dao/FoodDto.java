package es.cabsa.javadevelopers.dao;

import com.jungle.jungle.model.Animal;
import com.jungle.jungle.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodDto extends JpaRepository<Food, Integer> {
    boolean existsById(int id);
    boolean existsByName(String name);
    List<Food> findAllByNameContains(String search1);
}
