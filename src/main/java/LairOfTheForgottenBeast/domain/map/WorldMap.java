package LairOfTheForgottenBeast.domain.map;

import java.util.List;

public class WorldMap {
   private Room rooms[][];
   
   public WorldMap(Room[][] rooms) {
      super();
      this.rooms = rooms;
   }

   public Room[][] getRooms() {
      return rooms;
   }

   public void setRooms(Room[][] rooms) {
      this.rooms = rooms;
   }
   
   /**
    * Returns the <code>Room</code> object at the specified coordinates in <code>WorldMap</code>.
    * The x and y arguments should be an <code>int</code> type.
    * This method may throw an exception if the room is not found.
    * If no <code>Room</code> is found, this method should return null.
    * @param  x  an <code>int</code>, the x coordinate of a <code>Room</code>.
    * @param  y  an <code>int</code>, the y coordinate of a <code>Room</code>.
    * @return      The <code>Room</code> at the specified coordinates in this <code>WorldMap</code>.
    * @see         Room
    */
   public Room getRoom(int x, int y) {
      return rooms[x][y];
   }
   
   /**
    * Replaces the <code>Room</code> object at the specified coordinates in <code>WorldMap</code>.
    * The x and y arguments should be <code>int</code> type.
    * This method may throw an exception if the coordinates are out of bounds.
    * @param  x  an <code>int</code>, the x coordinate of a <code>Room</code>.
    * @param  y  an <code>int</code>, the y coordinate of a <code>Room</code>.
    * @return      The <code>Room</code> at the specified coordinates in this <code>WorldMap</code>.
    * @see         Room
    */
   public Room setRoom(int x, int y, Room room) {
      room = rooms[x][y];
      return room;
   }
   
   /**
    * Returns a <code>Room</code> object with a matching name from the WorldMap.
    * The name argument should be the name of a <code>Room</code> object.
    * If an empty <code>String</code> is passed, this method will return null.
    * If name is <code>null</code>, this method will return null.
    * @param  name  A String, the name of a <code>Room</code>.
    * @return      A room with a matching name.
    * @see         Room
    */
   public Room getRoom(String name) {
      if (name.equals("") || name.equals(null)) {
         return null;
      }
      Room room = new Room();
      for (int y = 0; y < rooms.length; y++) {
         for (int x = 0; x < rooms[0].length; x++) {
            if (rooms[x][y].getName().equals(name)) {
               room = rooms[x][y];
            }
         }
      }
      return room;
   }
}
