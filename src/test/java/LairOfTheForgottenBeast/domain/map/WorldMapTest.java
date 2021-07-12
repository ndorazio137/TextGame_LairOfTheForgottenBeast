package LairOfTheForgottenBeast.domain.map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/* Non-static Imports */
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;

@SpringBootTest
public class WorldMapTest {

   /** 
    * Test to determine if the world map exists.
    */
   @Test
   public void WorldMapExistsTest() {
      
      /* Create a world map with simple 1 x 1 x 1 dimensions */
      WorldMap worldMap = new WorldMap(new RoomDynamic[1][1][1], 1, 1, 1);
      /* Check: Is the world map not null ? */
      assertNotNull(worldMap);
   }
   
   /** 
    * Test to determine if the world map is invalid size.
    */
   @Test
   public void WorldMapSizeTest() {
      
      /* Create a world map and assign zero to x or y */
      WorldMap worldMap = new WorldMap(null, 0, 0, 0);
      
      /* Get the axis sizes */
      int sizeX = worldMap.getSizeX();
      int sizeY = worldMap.getSizeY();

      /* Check: Is the map using an invalid size? */
      assertTrue((sizeX <= 0) || (sizeY <= 0));
   }
}
