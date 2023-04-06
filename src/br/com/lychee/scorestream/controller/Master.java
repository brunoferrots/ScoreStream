package br.com.lychee.scorestream.controller;

import br.com.lychee.scorestream.model.Movie;
import br.com.lychee.scorestream.model.Series;
import br.com.lychee.scorestream.tracker.RecommendationFilter;
import br.com.lychee.scorestream.tracker.TimeTracker;

public class Master {
    public static void main(String[] args) {
        Movie johnWick = new Movie("John Wick 4", 2023, 180);
        Series viking = new Series("Viking", 2013);

        johnWick.evaluates(9.8);
        johnWick.evaluates(7.0);
        johnWick.evaluates(5.5);

        System.out.println(johnWick.showFeatures());
        System.out.printf("The current media is : %f%n",johnWick.handleMedia());
        System.out.printf("Quantity total ratings is :  %d%n",johnWick.getTotalRatings());

        viking.setEpisodes(10);
        viking.setSeason(5);
        viking.setMinutesPerEpisodes(50);

        System.out.printf("The total minutes of the current complete series is : %d min %n", viking.getLengthInMinutes());

        TimeTracker timeTracker = new TimeTracker();
        timeTracker.include(johnWick);
        timeTracker.include(viking);
        System.out.printf("The time total watched is : %d %n", timeTracker.getTimeTotal());

        RecommendationFilter recommendationFilter = new RecommendationFilter();
        System.out.println(johnWick.getName()+ " - " + recommendationFilter.filter(johnWick));
    }
}