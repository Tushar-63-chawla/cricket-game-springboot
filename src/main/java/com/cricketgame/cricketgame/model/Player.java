package com.cricketgame.cricketgame.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;
@Entity
@Data
public class Player {
    @Id
    private String id;
    private String name;
    private String team;
    private String type;
    private int runs;

}
