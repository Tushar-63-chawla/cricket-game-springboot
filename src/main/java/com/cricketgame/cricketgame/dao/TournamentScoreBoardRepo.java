package com.cricketgame.cricketgame.dao;

import com.cricketgame.cricketgame.model.TournamentScoreBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentScoreBoardRepo extends JpaRepository<TournamentScoreBoard, String> {
    TournamentScoreBoard findByTeamName(String battingTeam1);

}
