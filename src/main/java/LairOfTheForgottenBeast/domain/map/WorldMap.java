package LairOfTheForgottenBeast.domain.map;

import java.util.List;

public class WorldMap {
   private Room rooms[][][];
   
   public WorldMap(Room[][][] rooms) {
      super();
      this.rooms = rooms;
   }

   public Room[][][] getRooms() {
      return rooms;
   }

   public void setRooms(Room[][][] rooms) {
      this.rooms = rooms;
   }
   
   /**
    * Returns the <code>Room</code> object at the specified coordinates in <code>WorldMap</code>.
    * The coords arguments should be an <code>int[]</code> type.
    * This method may throw an exception if the room is not found.
    * If no <code>Room</code> is found, this method should return null.
    * @param  coords  an <code>int[]</code>, the coordinates of a <code>Room</code>.
    * @return      The <code>Room</code> at the specified coordinates in this <code>WorldMap</code>.
    * @see         Room
    */
   public Room getRoom(int[] coords) {
      return rooms[coords[0]][coords[1]][coords[2]];
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
   public Room getRoom(int x, int y, int z) {
      return rooms[x][y][z];
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
   public Room setRoom(int x, int y, int z, Room room) {
      room = rooms[x][y][z];
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
      for (int z = 0; z < rooms[0][0].length; z++) {
         for (int y = 0; y < rooms[0].length; y++) {
            for (int x = 0; x < rooms.length; x++) {
               if (rooms[x][y][z].getName().equals(name)) {
                  room = rooms[x][y][z];
               }
            }
         }
      }
      return room;
   }
   
   /**
    * Returns an int array with the coordinates of the specified Room.
    * The room argument should be a <code>Room</code> object.
    * If an empty <code>String</code> is passed, this method will return null.
    * If name is <code>null</code>, this method will return null.
    * @param  room  A <code>Room</code> object.
    * @return      The coordinates of the Room as an int array [x, y].
    * @see         Room
    */
   public int[] getRoomCoords(Room room) {
      if (room.equals("") || room.equals(null)) {
         return null;
      }
      int coords[] = {-1, -1};
      for (int y = 0; y < rooms.length; y++) {
         for (int x = 0; x < rooms[0].length; x++) {
            if (rooms[x][y].equals(room)) {
               coords[0] = x;
               coords[1] = y;
            }
         }
      }
      return coords;
   }
}
