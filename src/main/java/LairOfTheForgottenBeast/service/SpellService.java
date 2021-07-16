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
	
	private HashMap<String, String> magicWordDictionary;
	private final int SPELL_DAMAGE = 20;
	
	public SpellService() {
		this.initMagicWordDictionary();
	}
	
	private void initMagicWordDictionary() {
		magicWordDictionary = new HashMap<String, String>();
		HashMap<String, String> dict = this.magicWordDictionary;
		dict.put("sum","create");
		dict.put("fir","fire");
		dict.put("pro","projectile");
		dict.put("col","frost");
	}
	
	public String castSpell(GameState gamestate, List<String> invokeCommand) {
		System.out.println("SpellService: Received command List: " + invokeCommand);
		String spellString = "";
		String targetName = "";
		String outputString = "";
		System.out.println("SpellService: parsing target name and spell string...");
		boolean foundAtToken = false;
		for (int i = 1; i < invokeCommand.size() - 1; i++) {
			if (invokeCommand.get(i).equals("at")) {
				targetName = concatTheRemainingTokens(invokeCommand, i+1);
				foundAtToken = true;
				System.out.println("SpellService: found target name: " + targetName);
			} 
			if (!foundAtToken && i > 0) {
				spellString += magicWordDictionary.get(invokeCommand.get(i));
			}
			if (!foundAtToken) {
				spellString += " ";
			}
		}
		spellString = spellString.trim();
		System.out.println("SpellService.castSpell: Spell String constructed: "
				+ "\"" + spellString + "\"");
		if (!foundAtToken) {
			System.out.println("SpellService.castSpell: failed to parse " 
					+ "target name");
			return defaultString(); // fizzle spell
		}
		if (spellString.equals("create fire projectile")) {
			System.out.println("SpellService.castSpell: identified spell \"create fire projectile\"");
			outputString = castCreateProjectile(gamestate, "fire", targetName);
		}
		else if (spellString.equals("create frost projectile")) {
			System.out.println("SpellService.castSpell: identified spell \"create frost projectile\"");
			outputString = castCreateProjectile(gamestate, "frost", targetName);
		}
		else {
			System.out.println("SpellService.castSpell: spell string did not "
					+ "match any known spell... fizzling spell.");
			outputString = defaultString();
		}
		
		return outputString;
	}
	
	private String concatTheRemainingTokens(List<String> tokens, int i) {
		String tokenString = "";
		
		for (int index = i; index < tokens.size(); index++) {
			tokenString += tokens.get(index);
			if (index < tokens.size() - 1) {
				tokenString += " ";
			}
		}
		
		return tokenString;
	}

	private Object findTarget(GameState gamestate, String targetName) {
		Player player = gamestate.getPlayer();
		RoomDynamic room = player.getCurrentRoom();
		System.out.println("SpellService.findTarget: finding target " 
				+ targetName + " in room " + room.getName());
		for (Creature creature : room.getCreatures()) {
			if (creature.getName().equals(targetName)) {
				System.out.println("SpellService.findTarget: Creature target "
						+ "identified: " + creature);
				return creature;
			}
		}
		for (Prop prop : room.getProps()) {
			if (prop.getName().equals(targetName)) {
				System.out.println("SpellService.findTarget: Prop target "
						+ "identified: " + prop);
				return prop;
			}
		}
		System.out.println("SpellService.findTarget: target " + targetName 
				+ " not found in room " + room.getName());
		return null;
	}

	private String castCreateProjectile(GameState gamestate, String aspect, String targetName) {
		System.out.println("SpellService.castCreateProjectile: about to locate "
				+ "target for casting \"create " + aspect + " projectile");
		Object target = findTarget(gamestate, targetName);
		if (target instanceof Creature) {
			System.out.println("SpellService.castCreateProjectile: Casting "
					+ "spell at creature: " + target);
			((Creature)target).setCurrentHitPoints(((Creature) target).getCurrentHitPoints() - SPELL_DAMAGE);
			return "You cast a blast of " + aspect + " at " + ((Creature) target).getName() + ".";
		} 
		else if (target instanceof Prop) {
			if ( aspect.equals("fire") && (((Prop) target).burn() != null) ) {
				System.out.println("SpellService.castCreateProjectile: Casting "
						+ "fire spell at prop: " + target);
				return "You cast a blast of fire at the " 
						+ targetName + ". " 
						+ ((Prop) target).burn();
			} else if (aspect.equals("frost")  && (((Prop) target).freeze() != null) ) {
				System.out.println("SpellService.castCreateProjectile: Casting "
						+ "frost spell at prop: " + target);
				return "You cast a blast of frost at the " 
						+ targetName + ". " 
						+ ((Prop) target).freeze();
			}
		}
		
		return null;
	}
	
	private String defaultString() {
		return "The spell fizzles.";
	}
}
