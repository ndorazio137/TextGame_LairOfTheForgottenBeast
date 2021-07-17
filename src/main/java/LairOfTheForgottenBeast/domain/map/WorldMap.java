package LairOfTheForgottenBeast.domain.map;

import java.util.Random;

import LairOfTheForgottenBeast.domain.map.rooms.Room;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;

public class WorldMap {
   private RoomDynamic rooms[][][];
   private int sizeX;
   private int sizeY;
   private int sizeZ;
   
   public WorldMap(RoomDynamic[][][] rooms, int sizeX, int sizeY, int sizeZ) {
      super();
      this.rooms = rooms;
      this.sizeX = sizeX;
      this.sizeY = sizeY;
      this.sizeZ = sizeZ;
   }

   public int getSizeX() {
      return sizeX;
   }

   public void setSizeX(int sizeX) {
      this.sizeX = sizeX;
   }

   public int getSizeY() {
      return sizeY;
   }

   public void setSizeY(int sizeY) {
      this.sizeY = sizeY;
   }

   public int getSizeZ() {
      return sizeZ;
   }

   public void setSizeZ(int sizeZ) {
      this.sizeZ = sizeZ;
   }

   public Room[][][] getRooms() {
      return rooms;
   }

   public void setRooms(RoomDynamic[][][] rooms) {
      this.rooms = rooms;
   }
   
   /**
    * Returns the <code>Room</code> object at the specified coordinates in <code>WorldMap</code>.
    * The coords arguments should be an <code>int[]</code> type.
    * This method will return null if the coordinates are out of bounds.
    * If no <code>Room</code> is found, this method should return null.
    * @param  coords  an <code>int[]</code>, the coordinates of a <code>Room</code>.
    * @return      The <code>Room</code> at the specified coordinates in this <code>WorldMap</code>.
    * @see         Room
    */
   public RoomDynamic getRoom(int[] coords) {
      if (coords.length != 3) {
         return null;
      }
      if (!coordIsInBounds(coords[0],coords[1],coords[2])) {
         return null;
      }
      return rooms[coords[0]][coords[1]][coords[2]];
   }
   
   /**
    * Returns the <code>Room</code> object at the specified coordinates in <code>WorldMap</code>.
    * The x and y arguments should be an <code>int</code> type.
    * This method will return null if the coordinates are out of bounds.
    * If no <code>Room</code> is found, this method should return null.
    * @param  x  an <code>int</code>, the x coordinate of a <code>Room</code>.
    * @param  y  an <code>int</code>, the y coordinate of a <code>Room</code>.
    * @return      The <code>Room</code> at the specified coordinates in this <code>WorldMap</code>.
    * @see         Room
    */
   public RoomDynamic getRoom(int x, int y, int z) {
      if (!coordIsInBounds(x,y,z)) {
           return null;
        }
      return rooms[x][y][z];
   }
   
   /**
    * Replaces the <code>Room</code> object at the specified coordinates in <code>WorldMap</code>.
    * The x and y arguments should be <code>int</code> type.
    * This method will return null if the coordinates are out of bounds.
    * @param  x  an <code>int</code>, the x coordinate of a <code>Room</code>.
    * @param  y  an <code>int</code>, the y coordinate of a <code>Room</code>.
    * @return      The <code>Room</code> at the specified coordinates in this <code>WorldMap</code>.
    * @see         Room
    */
   public Room setRoom(int x, int y, int z, Room room) {
      if (!coordIsInBounds(x,y,z)) {
         return null;
      }
      room = rooms[x][y][z];
      return room;
   }
   
   /**
    * Returns whether the coordinates are valid within WorldMap.
    * If any coordinate is < 0 or > the max world size, this method returns false.
    * Otherwise this method returns true.
    * If any argument is <code>null</code>, this method's behavior is undefined.
    * @param  x  The x component of a coordinate, a measure of "east"ness.
    * @param  y  The y component of a coordinate, a measure of "north"ness.
    * @param  z  The z component of a coordinate, a measure of altitude.
    * @return      A boolean.
    */
   private boolean coordIsInBounds(int x, int y, int z) {
      return !(x < 0 || x > sizeX-1
            || y < 0 || y > sizeY-1
            || z < 0 || z > sizeZ-1);
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
      for (int z = 0; z < sizeZ+1; z++) {
         for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
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
      if (room.equals(null)) {
         return null;
      }
      int coords[] = {-1, -1, -1};
      for (int z = 0; z < sizeZ; z++) {   
         for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
               if (rooms[x][y][z].equals(room)) {
                  coords[0] = x;
                  coords[1] = y;
                  coords[2] = z;
               }
            }
         }
      }
      return coords;
   }

public RoomDynamic getRandomValidRoom() {
	Random rand = new Random();
	RoomDynamic randRoom;
	do {
		int x = rand.nextInt(sizeX);
		int y = rand.nextInt(sizeY);
		int z = rand.nextInt(sizeZ);
		randRoom = this.rooms[x][y][z];
	} while (randRoom.getName().equalsIgnoreCase("Wall"));
	return randRoom;
}
}
