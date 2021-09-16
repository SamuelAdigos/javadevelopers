package es.cabsa.javadevelopers.dao;

import com.jungle.jungle.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalDto extends JpaRepository<Animal, Integer> {
    boolean existsByName(String name);
    boolean existsById(int id);
    List<Animal> findAllByNameContains( String search1);
}
