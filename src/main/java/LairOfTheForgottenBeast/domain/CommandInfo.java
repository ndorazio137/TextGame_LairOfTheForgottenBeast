package LairOfTheForgottenBeast.domain;

import java.util.List;

public class CommandInfo {
  String username;
  List<String> commandList;
  private String multiplayer;

  // public CommandInfo(String username, List<String> commandList) {
  // super();
  // this.username = username;
  // this.commandList = commandList;
  // }

  public CommandInfo(String username, List<String> commandList, String multiplayer) {
    super();
    this.username = username;
    this.commandList = commandList;
    this.multiplayer = multiplayer;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<String> getCommandList() {
    return commandList;
  }

  public void setCommandList(List<String> commandList) {
    this.commandList = commandList;
  }

  public boolean getMultiplayer() {
    return this.multiplayer.equals("true");
  }

  public void setMultiplayer(String multiplayer) {
    this.multiplayer = multiplayer;
  }
}
