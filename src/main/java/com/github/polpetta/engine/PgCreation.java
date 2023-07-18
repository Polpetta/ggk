package com.github.polpetta.engine;

import com.github.polpetta.UI.UI;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class PgCreation {

  private final UI ui;
  private final PlayerFactory playerFactory;
  final Map<PlayerPOJO, Integer> playerPositions;

  @Inject
  public PgCreation(UI ui, PlayerFactory playerFactory) {
    this.ui = ui;
    this.playerFactory = playerFactory;
    this.playerPositions = new HashMap<>();
  }

  /**
   * Insert a new player
   * @return true if a player has been inserted or already exists, false if the player skipped adding users
   */
  public boolean insertPlayer() {
    ui.output("Insert a player name (press enter to start playing): ");
    final String possibleName = ui.readUntilNewLine();
    if (!possibleName.isEmpty()) {
      final PlayerPOJO possibleNewPlayer = playerFactory.create(possibleName);
      Optional.ofNullable(playerPositions.get(possibleNewPlayer))
          .ifPresentOrElse(
              ignored -> ui.output(possibleName + " already existing player"),
              () -> playerPositions.put(possibleNewPlayer, 0));
      return true;
    }
    return false;
  }
}
