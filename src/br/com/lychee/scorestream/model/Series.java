package br.com.lychee.scorestream.model;

public class Series extends Title {
    private int episodes;
    private int season;
    private boolean activate;
    private int minutesPerEpisodes;

    public Series(String name, int releaseYear) {
        super(name, releaseYear);
    }

    @Override
    public int getLengthInMinutes() {
        return episodes * season * minutesPerEpisodes;
    }

    private void setLengthInMinutes() {}

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    public int getMinutesPerEpisodes() {
        return minutesPerEpisodes;
    }

    public void setMinutesPerEpisodes(int minutesPerEpisodes) {
        this.minutesPerEpisodes = minutesPerEpisodes;
    }

    @Override
    public String toString() {
        return """
                Name series:    %s
                Release year:  %d
                """.formatted(super.getName(), super.getReleaseYear());
    }
}

