package LairOfTheForgottenBeast.domain.commands;

import java.util.List;

import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.service.SpellService;

public class Invoke implements ICommand<String> {

	@Override
	public <AnyType> String call(GameState gameState, List<String> command) {
		SpellService spellService = gameState.getSpellService();
		String commandOutput = "";
		commandOutput = spellService.castSpell(gameState, command);
		return commandOutput;
	}

}
