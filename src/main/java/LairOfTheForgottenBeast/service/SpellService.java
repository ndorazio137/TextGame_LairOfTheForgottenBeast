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
	private final int BOSS_ROOM_ID = 64;
	
	public SpellService() {
		this.initMagicWordDictionary();
	}
	
	private void initMagicWordDictionary() {
		magicWordDictionary = new HashMap<String, String>();
		HashMap<String, String> dict = this.magicWordDictionary;
		dict.put("indra", "create");
		dict.put("krata", "fire");
		dict.put("shuf", "projectile");
		dict.put("slou", "frost");
		dict.put("mito", "self-cast");
		dict.put("zuna", "teleportation");
		dict.put("sgatra", "random");
		dict.put("job", "object");
		dict.put("nili", "creature");
		dict.put("fulga", "lightning");
		dict.put("nuli", "plant");
	}
	
	public String castSpell(GameState gamestate, List<String> invokeCommand) {
		System.out.println("SpellService: Received command List: " 
				+ invokeCommand);
		String spellString = "";
		String targetName = "";
		String outputString = "";
		System.out.println("SpellService: parsing target name and spell "
				+ "string...");
		boolean foundAtToken = false;
		for (int i = 1; i < invokeCommand.size() - 1; i++) {
			if (invokeCommand.get(i).equals("at")) {
				targetName = concatTheRemainingTokens(invokeCommand, i+1);
				foundAtToken = true;
				System.out.println("SpellService: found target name: " 
						+ targetName);
			} 
			if (!foundAtToken && i > 0) {
				spellString += magicWordDictionary.get(invokeCommand.get(i));
			}
			if (!foundAtToken) {
				spellString += " ";
			}
		}
		if (!foundAtToken) {
			spellString += (magicWordDictionary.get(
					invokeCommand.get(invokeCommand.size()-1)));
		}
		spellString = spellString.trim();
		System.out.println("SpellService.castSpell: Spell String constructed: "
				+ "\"" + spellString + "\"");
//		if (!foundAtToken) {
//			System.out.println("SpellService.castSpell: failed to parse " 
//					+ "target name");
//			return defaultString(); // fizzle spell
//		}
		if (spellString.equals("create fire projectile")) {
			System.out.println("SpellService.castSpell: identified spell \""
					+ "create fire projectile\"");
			outputString = castCreateProjectile(gamestate, "fire", targetName);
		}
		else if (spellString.equals("create frost projectile")) {
			System.out.println("SpellService.castSpell: identified spell \""
					+ "create frost projectile\"");
			outputString = castCreateProjectile(gamestate, "frost", targetName);
		}
		else if (spellString.equals("self-cast fire projectile")) {
			System.out.println("SpellService.castSpell: identified spell \""
					+ "self-cast fire projectile\"");
			outputString = selfCastCreateProjectile(gamestate, "fire", 
					gamestate.getPlayer());
		}
		else if (spellString.equals("self-cast frost projectile")) {
			System.out.println("SpellService.castSpell: identified spell \""
					+ "self-cast frost projectile\"");
			outputString = selfCastCreateProjectile(gamestate, "frost", 
					gamestate.getPlayer());
		}
		else if (spellString.equals("self-cast random teleportation")) {
			System.out.println("SpellService.castSpell: identified spell \""
					+ "self-cast random teleportation\"");
			outputString = selfCastRandomTeleport(gamestate);
		}
		else if (spellString.equals("self-cast teleportation projectile")) {
			System.out.println("SpellService.castSpell: identified spell \""
					+ "self-cast random teleportation\"");
			outputString = selfCastRandomTeleport(gamestate);
			return outputString;
		}
		else if (spellString.equals("create teleportation projectile")) {
			System.out.println("SpellService.castSpell: identified spell \""
					+ "self-cast random teleportation\"");
			outputString = castCreateProjectile(gamestate, "teleportation", 
					targetName);
		}
		else {
			System.out.println("SpellService.castSpell: spell string did not "
					+ "match any known spell... fizzling spell.");
			outputString = defaultString();
		}
		
		return outputString;
	}

	private String selfCastRandomTeleport(GameState gamestate) {
		Player player = gamestate.getPlayer();
		RoomDynamic startRoom = player.getCurrentRoom();
		RoomDynamic endRoom;
		do {
			endRoom = gamestate.getWorldMap().getRandomValidRoom();
		} while (startRoom.equals(endRoom) || endRoom.getId() != BOSS_ROOM_ID);
		
		System.out.println("SpellService.selfCastRandomTeleport: attempting to"
				+ " teleport the player from " + startRoom.getName() 
				+ " to " + endRoom.getName() + ".");
		player.setCurrentRoom(endRoom);
		return "A swirling portal surrounds you for a moment and when it fades "
				+ "you find yourself in a new location. You are in " 
				+ endRoom.getName() + ": " + endRoom.getLongDescription();
	}

	private String selfCastCreateProjectile(GameState gamestate, String aspect, 
			Player player) {
		System.out.println("SpellService.castCreateProjectile: Casting "
				+ "spell at self: " + player.getName());
		player.setCurrentHitPoints(player.getCurrentHitPoints() - SPELL_DAMAGE);
		return "You cast a blast of " + aspect + " that explodes on yourself.";
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
			if (creature.getName().equalsIgnoreCase(targetName)) {
				System.out.println("SpellService.findTarget: Creature target "
						+ "identified: " + creature);
				return creature;
			}
		}
		for (Prop prop : room.getProps()) {
			if (prop.getName().equalsIgnoreCase(targetName)) {
				System.out.println("SpellService.findTarget: Prop target "
						+ "identified: " + prop);
				return prop;
			}
		}
		System.out.println("SpellService.findTarget: target " + targetName 
				+ " not found in room " + room.getName());
		return null;
	}

	private String castCreateProjectile(GameState gamestate, String aspect, 
			String targetName) {
		System.out.println("SpellService.castCreateProjectile: about to locate "
				+ "target for casting \"create " + aspect + " projectile");
		if (targetName.equals("")) {
			return "This spell must be cast at a target.";
		}
		Object target = findTarget(gamestate, targetName);
		if (target == null) {
			return "You don't see a " + targetName + " to cast your spell at.";
		}
		if (target instanceof Creature) {
			System.out.println("SpellService.castCreateProjectile: Casting "
					+ "spell at creature: " + target);
			if (aspect.equals("teleportation")) {
				((Creature)target).getCurrentRoom()
						.removeCreature((Creature)target);
				RoomDynamic newRoom = gamestate.getWorldMap()
						.getRandomValidRoom();
				((Creature)target).setCurrentRoom(newRoom);
				newRoom.addCreature(((Creature)target));
				System.out.println("SpellService.castCreateProjectile: "
						+ "teleported " + ((Creature)target).getName() + " to "
								+ " room: " + ((Creature)target)
								.getCurrentRoom());
				return "You cast a blast of " + aspect + " energy at " 
						+ ((Creature) target).getName() + ". A swirling portal "
						+ "surrounds it for a moment and it vanishes.";
			} else {
				((Creature)target).setCurrentHitPoints(
						((Creature)target).getCurrentHitPoints() 
						- SPELL_DAMAGE);
				return "You cast a blast of " + aspect + " at " 
						+ ((Creature) target).getName() + ".";
			}
		} 
		else if (target instanceof Prop) {
			if ( aspect.equals("fire") && (((Prop) target).burn() != null) ) {
				System.out.println("SpellService.castCreateProjectile: Casting "
						+ "fire spell at prop: " + target);
				return "You cast a blast of fire at the " 
						+ targetName + ". " 
						+ ((Prop) target).burn();
			} else if (aspect.equals("frost")  
					&& (((Prop) target).freeze() != null) ) {
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
