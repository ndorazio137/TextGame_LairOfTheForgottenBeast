package LairOfTheForgottenBeast.domain.map;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
   @Query("select r from Room r order by id desc")
   List<Room> findAllOrderByIdDesc();
}