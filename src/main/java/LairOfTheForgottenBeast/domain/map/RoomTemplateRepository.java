package LairOfTheForgottenBeast.domain.map;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTemplateRepository extends CrudRepository<RoomTemplate, Long> {
   @Query("select r from Room r order by id desc")
   List<RoomTemplate> findAllOrderByIdDesc();
}