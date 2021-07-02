package LairOfTheForgottenBeast.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Before;
import LairOfTheForgottenBeast.domain.map.Room;
import LairOfTheForgottenBeast.domain.map.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Item;

@SpringBootTest
public class RoomItemInsertionTest {
   // Use Mock for classes to be stubbed.
   @Mock
   private Room mockRoom;

   @Mock
   private Item mockItem;

   // This is the class to be tested.
   private RoomDynamic roomDynamic;

   @SuppressWarnings("deprecation")
   @Before
   public void setUp() {
      MockitoAnnotations.initMocks(this);
      mockItem = Mockito.mock(Item.class);
   }

   /**
    * Test to determine if an Item can be added to the Room.
    */
   @Test
   public void test1() {
      roomDynamic = new RoomDynamic(1, "Sinkhole",
         "The air is moist and earthy.");
      /* Check: Was the Item added? */
      assertThat(roomDynamic.addProp(mockItem));
   }
}