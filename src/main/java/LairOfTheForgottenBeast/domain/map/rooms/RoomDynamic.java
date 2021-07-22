package LairOfTheForgottenBeast.domain.map.rooms;

import java.util.ArrayList;
import java.util.List;
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.creature.Creature;
import LairOfTheForgottenBeast.domain.prop.Prop;

/**
 * Expands on Room with fields that are added when building the map and filling rooms with objects,
 * and interacting with rooms.
 */
public class RoomDynamic extends Room {

  List<Prop> props;
  List<Creature> creatures;
  List<Player> players;

  // wrapper for superclass constructor
  public RoomDynamic(int id, String name, String description) {
    super(id, name, description);
    this.props = new ArrayList<Prop>();
    this.creatures = new ArrayList<Creature>();
    this.players = new ArrayList<Player>();
  }

  public String getLongDescription(boolean multiplayer) {
    String baseDescription = super.getDescription();

    String propsDescription = "";
    // String propsDescription = this.getProps().toString();
    List<Prop> props = this.getProps();
    for (int i = 0; i < props.size(); i++) {
      propsDescription += props.get(i).getName();
      if (i == props.size() - 2) {
        propsDescription += ", and ";
      } else if (i != props.size() - 1) {
        propsDescription += ", ";
      }
    }

    String creaturesDescription = "";
    List<Creature> creatures = this.getCreatures();
    for (int c = 0; c < creatures.size(); c++) {
      creaturesDescription += creatures.get(c).getName();
      if (c == creatures.size() - 2) {
        creaturesDescription += ", and ";
      } else if (c != creatures.size() - 1) {
        creaturesDescription += ", ";
      }
    }
    
    String playersDescription = "";
    List<Player> players = this.getPlayers();
    for (int c = 0; c < players.size(); c++) {
      playersDescription += players.get(c).getName();
      if (c == players.size() - 2) {
        playersDescription += ", and ";
      } else if (c != players.size() - 1) {
        playersDescription += ", ";
      }
    }
    
    String longDescription = baseDescription;
    if (props.size() > 0) {
      longDescription += " \nThe following objects are in this room: " + propsDescription + ".";
    }
    if (creatures.size() > 0) {
      longDescription += " \nThe following creatures are in this room: " + creaturesDescription + ".";
    }
    if (players.size() > 0 && multiplayer) {
      longDescription += " \nThe following players are in this room: " + playersDescription + ".";
    }
    
    return longDescription;
  }


  public List<Prop> getProps() {
    return props;
  }

  public void setProps(List<Prop> props) {
    this.props = props;
  }

  // Maybe we should update this to return the prop added
  // instead of a boolean?
  public boolean addProp(Prop prop) {
    return this.props.add(prop);
  }

  // Maybe we should update this to return the prop removed
  // instead of a boolean?
  public boolean removeProp(Prop prop) {
    return this.props.remove(prop);
  }

  public List<Player> getPlayers() {
    return players;
  }

  public void setPlayers(List<Player> players) {
    this.players = players;
  }

  public List<Creature> getCreatures() {
    return creatures;
  }

  public void setCreatures(List<Creature> creatures) {
    this.creatures = creatures;
  }

  public boolean addCreature(Creature creature) {
    return this.creatures.add(creature);
  }

  public boolean removeCreature(Creature creature) {
    return this.creatures.remove(creature);
  }
  
  public boolean addPlayer(Player player) {
    return this.players.add(player);
  }

  public boolean removePlayer(Player player) {
    return this.players.remove(player);
  }

  public Object findTarget(String targetName) {
    for (Creature creature : creatures) {
      if (creature.getName().equalsIgnoreCase(targetName)) {
           return creature;
      }
    }
    
    for (Prop prop : props) {
      if (prop.getName().equalsIgnoreCase(targetName)) {
          return prop;
      }
    }
    
    return null;
  }

  @Override
  public boolean equals(Object obj) {

    if (!super.equals(obj))
      return false;

    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    RoomDynamic other = (RoomDynamic) obj;
    if (props == null) {
      if (other.props != null)
        return false;
    } else if (!props.equals(other.props))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "RoomObject [id=" + id + ", name=" + name + ", description=" + description + ", props="
        + props + ", creatures=" + creatures + " ]";
  }

}
