package br.com.lychee.scorestream.controller;

import br.com.lychee.scorestream.model.Movie;
import br.com.lychee.scorestream.model.Series;
import br.com.lychee.scorestream.model.Title;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MasterList {
    public static void main(String[] args) {
        var johnWick = new Movie("John Wick 4", 2023, 180);
        johnWick.evaluates(9.8);

        var viking = new Series("Viking", 2013);
        viking.evaluates(7.5);

        var catBoots = new Movie("Cat Boots 2", 2022, 160);
        catBoots.evaluates(10.0);

        var list = new ArrayList<Title>();
        list.add(johnWick);
        list.add(viking);
        list.add(catBoots);

//        for (var title : list) {
//            System.out.println(title);
//        }
//        list.forEach(list -> System.out.println(list)); LAMBDA EXPRESSION
        list.forEach(System.out::println);

        System.out.println("Sorting title list per name!");
        Collections.sort(list);
        System.out.println(list);

        list.sort(Comparator.comparing(Title::getReleaseYear));
        System.out.println("Sorting title list per release year");
        System.out.println(list);



    }
}
