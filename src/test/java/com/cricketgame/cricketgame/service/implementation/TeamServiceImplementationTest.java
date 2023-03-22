package com.cricketgame.cricketgame.service.implementation;

import com.cricketgame.cricketgame.dao.PlayerRepo;
import com.cricketgame.cricketgame.model.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class TeamServiceImplementationTest {

    @InjectMocks
    TeamServiceImplementation teamServiceImplementation;

    @Mock
    PlayerRepo repo;

    @Test
    void verifyTeamForOddNumbers() throws Error{
            teamServiceImplementation.verifyTeam(4);
    }

    @Test
    void createPlayer(){
        for (Player player : teamServiceImplementation.createPlayers()) assertNotNull(player);


    }
}