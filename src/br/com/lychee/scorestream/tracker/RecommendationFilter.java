package br.com.lychee.scorestream.tracker;

public class RecommendationFilter {
    public String filter(Ranked ranked) {
        if (ranked.getRanked() >= 4) {
            return "It's a favorite on the moment";
        } else if (ranked.getRanked() >= 2) {
            return "Very well ranked on the moment";
        } else {
            return "Add in your list for watch later";
        }
    }
}
