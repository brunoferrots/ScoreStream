package br.com.lychee.scorestream.model;

import br.com.lychee.scorestream.tracker.Ranked;

public abstract class Title implements Ranked, Comparable<Title> {
    private String name;
    private int releaseYear;
    private boolean includeInPlan;
    private double sumRating;
    private int totalRatings = 0;
    private int lengthInMinutes;

    @Override
    public int getRanked() {
        return (int) this.handleMedia() / 2;
    }

    protected Title (String name, int releaseYear, int lengthInMinutes) {
        this.setName(name);
        this.setReleaseYear(releaseYear);
        this.setLengthInMinutes(lengthInMinutes);
    }

    protected Title (String name, int releaseYear) {
        this.setName(name);
        this.setReleaseYear(releaseYear);
    }

    public String showFeatures() {
        return """
                Movie Features:
                name -         %s
                release year - %d
                length -       %d min
                rating -       %.2f
                """.formatted(
                this.getName(),
                this.getReleaseYear(),
                this.getLengthInMinutes(),
                this.getSumRating()
        );
    }

    public void evaluates(double value) {
        sumRating += value;
        totalRatings++;
    }

    public double handleMedia() {
        return sumRating / totalRatings;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    private void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean isIncludeInPlan() {
        return includeInPlan;
    }

    public void setIncludeInPlan(boolean includeInPlan) {
        this.includeInPlan = includeInPlan;
    }

    public double getSumRating() {
        return sumRating;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }
}
