package com.cricketgame.cricketgame.service.implementation;

import com.cricketgame.cricketgame.commonutils.SortByPoints;
import com.cricketgame.cricketgame.commonutils.Utils;
import com.cricketgame.cricketgame.dao.TournamentScoreBoardRepo;
import com.cricketgame.cricketgame.model.TournamentScoreBoard;
import com.cricketgame.cricketgame.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TournamentServiceImplementation implements TournamentService {
    @Autowired
    TournamentScoreBoardRepo tournamentScoreBoardRepo;

    @Autowired
    MatchServiceImplementation matchServiceImplementation;
    @Autowired
    TeamServiceImplementation teamServiceImplementation;

    @Override
    public String returnWinningTeam(String team_1, String team_2) {
        String battingTeam_1 = Utils.teamSelector(team_1, team_2);
        String battingTeam_2 = battingTeam_1 == team_1 ? team_2 : team_1;
        int scoreOfBattingTeam_1 = 0, scoreOfBattingTeam_2 = 0;
        scoreOfBattingTeam_1 = matchServiceImplementation.match(battingTeam_1);
        scoreOfBattingTeam_2 = matchServiceImplementation.match(battingTeam_2);
        if (scoreOfBattingTeam_1 > scoreOfBattingTeam_2) {
            return getString(battingTeam_1);

        } else {
            return getString(battingTeam_2);
        }

    }

    private String getString(String battingTeam) {
        TournamentScoreBoard tournamentScoreBoard = new TournamentScoreBoard();
        if (tournamentScoreBoardRepo.findByTeamName(battingTeam) != null) {
            tournamentScoreBoard = tournamentScoreBoardRepo.findByTeamName(battingTeam);
            tournamentScoreBoard.setPoints(tournamentScoreBoard.getPoints() + 2);
        } else {
            tournamentScoreBoard.setTeamName(battingTeam);
            tournamentScoreBoard.setPoints(tournamentScoreBoard.getPoints() + 2);
        }
        tournamentScoreBoardRepo.save(tournamentScoreBoard);
        return battingTeam;
    }

    @Override
    public String returnTournamentWinner() {
        List<TournamentScoreBoard> tournamentScoreBoards = tournamentScoreBoardRepo.findAll();
        Collections.sort(tournamentScoreBoards, new SortByPoints());
        if (tournamentScoreBoards.get(0).getPoints() == tournamentScoreBoards.get(1).getPoints())
            return Integer.parseInt(tournamentScoreBoards.get(0).getTeamName()) < Integer.parseInt(tournamentScoreBoards.get(1).getTeamName()) ? tournamentScoreBoards.get(0).getTeamName() : tournamentScoreBoards.get(1).getTeamName();
        else
            return tournamentScoreBoards.get(0).getTeamName();
    }

    @Override
    public String runMatchSim(List<String> listOfTeams) {
        if (listOfTeams.size() == 1) {
            return ("Team " + returnTournamentWinner() + " Won");
        }
        List<String> newListOfTeams = new ArrayList();
        for (int i = 0; i < listOfTeams.size(); i += 2) {
            String winningTeam = returnWinningTeam(listOfTeams.get(i), listOfTeams.get(i + 1));
            newListOfTeams.add(winningTeam);
        }
        return runMatchSim(newListOfTeams);
    }

    @Override
    public String runMatchIni() {
        List<String> listOfTeams = new ArrayList<>();
        int n = teamServiceImplementation.getN();
        for (int i = 1; i <= n; i++) {
            listOfTeams.add("" + i);
        }
        return runMatchSim(listOfTeams);
    }
}
