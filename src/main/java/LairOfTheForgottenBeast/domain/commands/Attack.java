package LairOfTheForgottenBeast.domain.commands;

import java.util.List;

import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.creature.Creature;
import LairOfTheForgottenBeast.domain.map.WorldMap;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.inventorySystem.Inventory;

public class Attack implements ICommand<String>{

	@Override
	public <AnyType> String call(GameState gameState, List<String> command) {
		// TODO Auto-generated method stub
		
		WorldMap worldMap = gameState.getWorldMap();
		Player player = gameState.getPlayer();
		RoomDynamic room = player.getCurrentRoom();
	    List<Creature> creatures = room.getCreatures();
	    
		return "Attack worked!";
	}

}
