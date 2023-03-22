package com.cricketgame.cricketgame.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class TournamentScoreBoard {
    @Id
    private String teamName;
    private int points;
}
