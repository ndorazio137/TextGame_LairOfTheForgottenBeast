package LairOfTheForgottenBeast.domain;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import LairOfTheForgottenBeast.domain.map.rooms.RoomRepository;

@SpringBootTest
// This test will determine if a room entity can be 
// successfully queried from the database. We expect
// the room with id number 9 will be a Kitchen.
public class RoomTest {
   @Autowired
   RoomRepository roomRepository;
   @Test
   public void test1() {
      int testId = (int) 9;
      String testRoom = roomRepository.findNameById((int)testId);
      System.out.println(testRoom);
      assertEquals(testRoom, "Kitchen");
   }
}