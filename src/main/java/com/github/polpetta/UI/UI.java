package com.github.polpetta.UI;

import io.vavr.control.Try;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import javax.inject.Singleton;

public interface UI {

  /**
   * Get the {@link OutputStream} of the current implementation where data will be written
   *
   * @return a {@link OutputStream} that will write data into an implemented output with UTF-8
   *     encoding
   */
  OutputStream getOutput();

  /**
   * Write the whole string as UTF-8
   *
   * @param content is a {@link String} of the content to write
   */
  default Try<Void> output(String content) {
    return Try.of(
        () -> {
          final OutputStream output = getOutput();
          output.write(content.getBytes(StandardCharsets.UTF_8));
          output.flush();
          return null;
        });
  }

  /**
   * Gets continuous input from user
   *
   * @return an {@link InputStream} containing the input read
   */
  Scanner readInput();

  /**
   * Read until new line
   *
   * @return a {@link Try} of {@link String} representing the input read
   */
  default String readUntilNewLine() {
      final Scanner scanner = readInput();
      return scanner.nextLine();
  }
}
