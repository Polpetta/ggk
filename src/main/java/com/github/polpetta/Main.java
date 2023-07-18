package com.github.polpetta;

import com.github.polpetta.UI.UiDI;
import com.github.polpetta.engine.Engine;
import com.github.polpetta.engine.EngineDI;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
  public static void main(String[] args) {
    final Injector injector = Guice.createInjector(new AppDI(), new UiDI(), new EngineDI());
    // final Logger logger = injector.getInstance(LogFactory.class).create(Main.class);
    final Engine engine = injector.getInstance(Engine.class);
    try {
      engine.run();
    } catch (Throwable ex) {
      System.err.println(ex.getMessage());
      throw new RuntimeException(ex);
    }
  }
}
