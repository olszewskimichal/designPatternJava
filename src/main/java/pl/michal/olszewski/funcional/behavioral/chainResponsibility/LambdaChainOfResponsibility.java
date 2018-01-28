package pl.michal.olszewski.funcional.behavioral.chainResponsibility;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class LambdaChainOfResponsibility {

  private static Optional<String> parseText(File file) {
    return Optional.ofNullable(file)
        .filter(f -> f.getType() == File.Type.TEXT)
        .map(f -> "Text file: " + f.getContent());
  }

  private static Optional<String> parsePresentation(File file) {
    return Optional.ofNullable(file)
        .filter(f -> f.getType() == File.Type.PRESENTATION)
        .map(f -> "Presentation file: " + f.getContent());
  }

  private static Optional<String> parseAudio(File file) {
    return Optional.ofNullable(file)
        .filter(f -> f.getType() == File.Type.AUDIO)
        .map(f -> "Audio file: " + f.getContent());
  }

  private static Optional<String> parseVideo(File file) {
    return Optional.ofNullable(file)
        .filter(f -> f.getType() == File.Type.VIDEO)
        .map(f -> "Video file: " + f.getContent());
  }

  public static void main(String[] args) {
    File file = new File(File.Type.AUDIO, "Dream Theater  - The Astonishing");

    System.out.println(
        Stream.<Function<File, Optional<String>>>of(
            LambdaChainOfResponsibility::parseText,
            LambdaChainOfResponsibility::parsePresentation,
            LambdaChainOfResponsibility::parseAudio,
            LambdaChainOfResponsibility::parseVideo)
            .map(f -> f.apply(file))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Unknown file: " + file))
    );
  }


}
