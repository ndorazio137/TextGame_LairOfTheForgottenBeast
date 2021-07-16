package LairOfTheForgottenBeast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.creature.Creature;
import LairOfTheForgottenBeast.domain.map.WorldMap;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Prop;

public class SpellService {
	
	private Map magicWordDictionary;
	private final int SPELL_DAMAGE = 20;
	
	public SpellService() {
		magicWordDictionary = new HashMap<String, String>();
		this.initMagicWordDictionary();
	}
	
	private void initMagicWordDictionary() {
		Map dict = this.magicWordDictionary;
		dict.put("sum","create");
		dict.put("fir","fire");
		dict.put("pro","projectile");
		dict.put("col","frost");
	}
	
	public String castSpell(GameState gamestate, List<String> invokeCommand) {
		String spellString = "";
		String targetName = "";
		String outputString = "";
		boolean foundAt = false;
		for (int i = 0; i < invokeCommand.size() - 1; i++) {
			if (invokeCommand.get(i).equals("at")) {
				targetName = invokeCommand.get(i+1);
				foundAt = true;
			} 
			if (!foundAt && i > 0) {
				spellString += invokeCommand.get(i);
			}
			if (i > 1 && i < invokeCommand.size() - 1) {
				spellString += " ";
			}
		}
		
		switch(spellString) {
		   case "create fire projectile":
		      outputString = createProjectile(gamestate, "fire", targetName);
		      break;
		   case "create frost projectile":
			  outputString = createProjectile(gamestate, "frost", targetName);
		      break;
		   default:
			  outputString = "The spell fizzles.";
		}
		
		return outputString;
	}
	
	private Object findTarget(GameState gamestate, String targetName) {
		Player player = gamestate.getPlayer();
		RoomDynamic room = player.getCurrentRoom();
		for (Creature creature : room.getCreatures()) {
			if (creature.getName().equals(targetName)) {
				return creature;
			}
		}
		for (Prop prop : room.getProps()) {
			if (prop.getName().equals(targetName)) {
				return prop;
			}
		}
		return null;
	}

	private String createProjectile(GameState gamestate, String aspect, String targetName) {
		Object target = findTarget(gamestate, targetName);
		if (target instanceof Creature) {
			target.setCurrentHitPoints(((Creature) target).getCurrentHitPoints() - SPELL_DAMAGE);
		} 
		else if (target instanceof Prop) {
			if (aspect.equals("fire")) {
				((Prop) target).burn();
			} else if (aspect.equals("frost")) {
				((Prop) target).freeze();
			}
		}
		
		return null;
	}
}
