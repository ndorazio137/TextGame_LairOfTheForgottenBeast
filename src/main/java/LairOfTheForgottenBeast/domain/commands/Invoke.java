package LairOfTheForgottenBeast.domain.commands;

import java.util.List;
import LairOfTheForgottenBeast.domain.CommandInfo;
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.service.SpellService;

public class Invoke implements ICommand<String> {

  @Override
  public <AnyType> String call(GameState gameState, CommandInfo commandInfo) {
    SpellService spellService = gameState.getSpellService();
    String commandOutput = "";
    commandOutput = spellService.castSpell(gameState, commandInfo);
    return commandOutput;
  }

}
