package br.com.lychee.scorestream.model;

import br.com.lychee.scorestream.tracker.Ranked;

public class Episodes implements Ranked {
    private int number;
    private String name;
    private Series series;

    private int totalViews;

    @Override
    public int getRanked() {
        if (totalViews > 100) {
            return 4;
        } else {
            return 2;
        }
    }

    public int getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Series getSerie() {
        return series;
    }

    public void setSerie(Series series) {
        this.series = series;
    }
}
