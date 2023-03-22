package com.cricketgame.cricketgame.service.implementation;

import com.cricketgame.cricketgame.dao.TournamentScoreBoardRepo;
import com.cricketgame.cricketgame.model.TournamentScoreBoard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
@ExtendWith(MockitoExtension.class)
class TournamentServiceImplementationTest {
    @InjectMocks
    TournamentServiceImplementation tournamentServiceImplementation;
    @Mock
    TournamentScoreBoardRepo tournamentScoreBoardRepo;
    @Mock
    MatchServiceImplementation matchServiceImplementation;
    @Mock
    TeamServiceImplementation teamServiceImplementation;


    @Test
    void returnWinningTeam(){
        tournamentServiceImplementation.returnWinningTeam("1","2");
    }
    @Test
    void returnTournamentWinner(){
        List<TournamentScoreBoard> tournamentScoreBoardList = new ArrayList<>();
        TournamentScoreBoard tournamentScoreBoard = new TournamentScoreBoard();
        tournamentScoreBoard.setTeamName("1");
        tournamentScoreBoard.setPoints(4);
        tournamentScoreBoardList.add(tournamentScoreBoard);
        tournamentScoreBoard.setTeamName("2");
        tournamentScoreBoard.setPoints(2);
        tournamentScoreBoardList.add(tournamentScoreBoard);

        Mockito.when(tournamentScoreBoardRepo.findAll()).thenReturn(tournamentScoreBoardList);
        tournamentServiceImplementation.returnTournamentWinner();
    }

    @Test
    void runMatchSim(){
        List<String>  list= new ArrayList<>();
        list.add("1");list.add("2");list.add("3");list.add("4");
        List<TournamentScoreBoard> tournamentScoreBoardList = new ArrayList<>();
        TournamentScoreBoard tournamentScoreBoard = new TournamentScoreBoard();
        tournamentScoreBoard.setTeamName("1");
        tournamentScoreBoard.setPoints(4);
        tournamentScoreBoardList.add(tournamentScoreBoard);
        tournamentScoreBoard.setTeamName("2");
        tournamentScoreBoard.setPoints(2);
        tournamentScoreBoardList.add(tournamentScoreBoard);
        Mockito.when(tournamentScoreBoardRepo.findAll()).thenReturn(tournamentScoreBoardList);
        tournamentServiceImplementation.runMatchSim(list);
    }
    @Test
    void runMatchIni(){
        List<TournamentScoreBoard> tournamentScoreBoardList = new ArrayList<>();
        TournamentScoreBoard tournamentScoreBoard = new TournamentScoreBoard();
        tournamentScoreBoard.setTeamName("1");
        tournamentScoreBoard.setPoints(4);
        tournamentScoreBoardList.add(tournamentScoreBoard);
        tournamentScoreBoard.setTeamName("2");
        tournamentScoreBoard.setPoints(2);
        tournamentScoreBoardList.add(tournamentScoreBoard);
        Mockito.when(tournamentScoreBoardRepo.findAll()).thenReturn(tournamentScoreBoardList);
        Mockito.when(teamServiceImplementation.getN()).thenReturn(4);
        tournamentServiceImplementation.runMatchIni();

    }
}