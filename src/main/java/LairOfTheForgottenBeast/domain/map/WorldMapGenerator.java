package LairOfTheForgottenBeast.domain.map;

public interface WorldMapGenerator {
  public WorldMap generateWorldMap(int sizeX, int sizeY, int sizeZ);

  public WorldMap generateWorldMap(int sizeX, int sizeY, int sizeZ, String options);
}
