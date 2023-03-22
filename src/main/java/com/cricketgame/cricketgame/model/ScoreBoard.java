package com.cricketgame.cricketgame.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ScoreBoard {
    @Id
    @GeneratedValue
    private int id;
    private int oversDone;
    private String battingTeam;
    private String batsman;
    private int runsOnCurrBall;
    private int totalRuns;
}
