package com.cricketgame.cricketgame.commonutils;
import java.util.Comparator;
import com.cricketgame.cricketgame.model.TournamentScoreBoard;

public class SortByPoints implements Comparator<TournamentScoreBoard> {
    @Override
    public int compare(TournamentScoreBoard o1, TournamentScoreBoard o2) {
        return o2.getPoints()- o1.getPoints();
    }
}
