package LairOfTheForgottenBeast.domain;

/**
 * Movement directions in game.
 * 
 * @author Nick D'Orazio
 * @version 1.0.0
 * @since 1.0.0
 */
public enum Directions {
  // Enum fields are "private static final" by default.
  NORTH("NORTH", "N"), EAST("EAST", "E"), SOUTH("SOUTH", "S"), WEST("WEST", "W"), UNKNOWN("UNKNOWN",
      "U");

  private final String directionCode;
  private final String directionShortHandCode;

  Directions(String code, String shortHandCode) {
    this.directionCode = code;
    this.directionShortHandCode = shortHandCode;
  }

  public String getDirectionCode() {
    return this.directionCode;
  }

  public String getShortHandDirectionCode() {
    return this.directionShortHandCode;
  }

  public static Directions contains(String direction) {
    direction = direction.toUpperCase();
    for (Directions d : Directions.values()) {
      if (d.getDirectionCode().equals(direction.toUpperCase())
          || d.getShortHandDirectionCode().equals(direction.toUpperCase())) {
        return d;
      }
    }

    return Directions.UNKNOWN;
  }
}
