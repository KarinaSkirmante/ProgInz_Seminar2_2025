package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Professor;
import lv.venta.model.enums.Degree;

public interface IProfessorRepo extends CrudRepository<Professor, Integer>{

   public abstract boolean existsByNameAndSurnameAndDegree(String name, String surname, Degree degree);

}
