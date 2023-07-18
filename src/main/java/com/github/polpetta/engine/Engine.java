package com.github.polpetta.engine;

import io.vavr.CheckedRunnable;

import javax.inject.Inject;

public class Engine implements CheckedRunnable {

  private final PgCreation pgCreation;

  @Inject
  public Engine(PgCreation pgCreation) {
    this.pgCreation = pgCreation;
  }

  @Override
  public void run() throws Throwable {
    boolean keepAddingUsers = true;
    do {
      // 1 - insert player
      keepAddingUsers = pgCreation.insertPlayer();

      // 2 - roll dice

      // 3 - check if number 63 (win) or go to 2
    } while (keepAddingUsers);
  }
}
