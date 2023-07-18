package com.github.polpetta.UI;

import java.io.*;
import java.util.Scanner;
import javax.inject.Singleton;

@Singleton
class SystemUI implements UI {
  @Override
  public OutputStream getOutput() {
    return new BufferedOutputStream(System.out);
  }

  @Override
  public Scanner readInput() {
    return new Scanner(System.in);
  }
}
