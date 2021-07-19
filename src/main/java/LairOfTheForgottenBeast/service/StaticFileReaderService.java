package LairOfTheForgottenBeast.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaticFileReaderService {

  private static final Logger log = LoggerFactory.getLogger(StaticFileReaderService.class);

  public String[] readFile(String fileName) {

    String[] data;

    try {
      // Creates a String[] based on the lines of a file.
      // Splits on new line delimiters \r and \n (also on spaces as default behavior which I want to
      // get rid of).
      data = new String(Files.readAllBytes(Paths.get(fileName))).split("\\r?\\n", 0);
      return data;
    } catch (IOException e) {
      log.warn("Error reading file: " + fileName, e);
    }
    return null;
  }

}
