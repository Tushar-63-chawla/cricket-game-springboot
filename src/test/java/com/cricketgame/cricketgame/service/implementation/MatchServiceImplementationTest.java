package com.cricketgame.cricketgame.service.implementation;

import com.cricketgame.cricketgame.commonutils.Utils;
import com.cricketgame.cricketgame.dao.PlayerRepo;
import com.cricketgame.cricketgame.dao.ScoreBoardRepo;
import com.cricketgame.cricketgame.model.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class MatchServiceImplementationTest {
    @InjectMocks
    MatchServiceImplementation matchServiceImplementation;
    @Mock
    ScoreBoardRepo scoreBoardRepo;
    @Mock
    PlayerRepo playerRepo;

    @Test
    void match() {
        List<Player> battingTeamPlayer = new ArrayList<>();
        String[] name = {"a","b","c","d","e"};
        for (int i = 0; i < 5; i++) {
            Player player = new Player();
            player.setId(UUID.randomUUID().toString().substring(0, (int) (UUID.randomUUID().toString().length() % 10)));
            player.setName(name[i]+"1");
            player.setTeam("1");
            player.setType(((i&1)==0)?"Batsman":"Bowler");
            player.setRuns(0);
            battingTeamPlayer.add(player);
        }
        Mockito.when(playerRepo.findByTeam("1")).thenReturn(battingTeamPlayer);
        try (MockedStatic<Utils> theMock = Mockito.mockStatic(Utils.class)) {
            theMock.when(() -> Utils.runs()).thenReturn("4");
            Mockito.when(playerRepo.findByName("a1")).thenReturn(battingTeamPlayer.get(0));
            matchServiceImplementation.match("1");
        }
    }
}