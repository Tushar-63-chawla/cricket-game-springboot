package com.cricketgame.cricketgame.dao;

import com.cricketgame.cricketgame.model.ScoreBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreBoardRepo extends JpaRepository<ScoreBoard,Integer> {
}
