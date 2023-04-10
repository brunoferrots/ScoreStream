package br.com.lychee.scorestream.tracker;

import br.com.lychee.scorestream.model.Title;

public class TimeTracker {
    private int timeTotal;

    public int getTimeTotal() {
        return timeTotal;
    }

    public void include(Title title) {
        this.timeTotal += title.getLengthInMinutes();
    }
}
