package com.cricketgame.cricketgame.commonutils;

import com.cricketgame.cricketgame.model.Player;

import java.util.UUID;

public class Utils {
    public static Player createPlayer(String name, String team, String type, int runs) {
        Player player = new Player();
        String uuid = UUID.randomUUID().toString();
        player.setId(uuid.substring(0, (int)(uuid.length() % 10)));
        player.setName(name);
        player.setTeam(team);
        player.setType(type);
        player.setRuns(runs);
        return player;
    }

    public static String runs(){
        int random = (int)(Math.random()*10);
        return random == 3 ? "W": Integer.toString(random==7?3:random==8?4:random==9?6:random);
    }

    public static String teamSelector(String team_1, String team_2){
        int random = (int)(Math.random()*2);
        return random == 0 ? team_1 : team_2 ;
    }
}
