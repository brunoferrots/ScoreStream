package br.com.lychee.scorestream.controller;

import br.com.lychee.scorestream.model.Movie;
import br.com.lychee.scorestream.model.Series;
import br.com.lychee.scorestream.tracker.RecommendationFilter;
import br.com.lychee.scorestream.tracker.TimeTracker;

import java.util.ArrayList;

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
        //NEW AWESOME SYNTAX
        var catBoots = new Movie("Cat Boots 2", 2023, 160);
        catBoots.evaluates(10);

        var movieList = new ArrayList<Movie>();
        movieList.add(johnWick);
        movieList.add(catBoots);
        System.out.println(movieList.get(0).getName());
        System.out.println(movieList.get(1).getName());

        System.out.println(movieList);
        System.out.println(movieList.get(1).toString());

    }
}