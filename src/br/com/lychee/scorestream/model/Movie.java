package br.com.lychee.scorestream.model;

public class Movie extends Title {
    public Movie(String name, int releaseYear, int lengthInMinutes) {
        super(name, releaseYear, lengthInMinutes);
    }

    @Override
    public String toString() {
        return """
                Name movie:    %s
                Release year:  %d
                """.formatted(super.getName(), super.getReleaseYear());
    }
}
