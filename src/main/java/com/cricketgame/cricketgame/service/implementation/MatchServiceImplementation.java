package com.cricketgame.cricketgame.service.implementation;

import com.cricketgame.cricketgame.commonutils.SortByPoints;
import com.cricketgame.cricketgame.commonutils.Utils;
import com.cricketgame.cricketgame.dao.PlayerRepo;
import com.cricketgame.cricketgame.dao.ScoreBoardRepo;
import com.cricketgame.cricketgame.dao.TournamentScoreBoardRepo;
import com.cricketgame.cricketgame.model.Player;
import com.cricketgame.cricketgame.model.ScoreBoard;
import com.cricketgame.cricketgame.model.TournamentScoreBoard;
import com.cricketgame.cricketgame.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MatchServiceImplementation implements MatchService {

    @Autowired
    ScoreBoardRepo scoreBoardRepo;
    @Autowired
    PlayerRepo playerRepo;

    @Override
    public int match(String team) {
        String runOnCurrBall = "";
        int totalScoreOfTeam = 0, currPlayerIndex = 0;
        List<Player> battingTeamPlayers = playerRepo.findByTeam(team);
        List<String> playerNames = new ArrayList<>();
        for (Player player : battingTeamPlayers) {
            playerNames.add(player.getName());
        }
        Player player = new Player();
        for (int currBallNumber = 1; currBallNumber <= 30; currBallNumber++) {
            runOnCurrBall = Integer.toString(0);
            ScoreBoard scoreBoard = new ScoreBoard();
            scoreBoard.setOversDone(5 - (int) Math.ceil((30 - currBallNumber) / 6));
            scoreBoard.setBattingTeam(team);
            runOnCurrBall = Utils.runs();
            if (currPlayerIndex == 4) {
                return totalScoreOfTeam;
            }
            else if (runOnCurrBall.equals("W")) {
                currPlayerIndex++;
                player = new Player();
                continue;
            } else {
                scoreBoard.setBatsman(playerNames.get(currPlayerIndex));
                player = playerRepo.findByName(playerNames.get(currPlayerIndex));
                player.setRuns(player.getRuns() + Integer.parseInt(runOnCurrBall));
                scoreBoard.setRunsOnCurrBall(Integer.parseInt(runOnCurrBall));
                totalScoreOfTeam += Integer.parseInt(runOnCurrBall);
                scoreBoard.setTotalRuns(totalScoreOfTeam);
                scoreBoardRepo.save(scoreBoard);
            }
            if(!player.equals(null))
                playerRepo.save(player);
        }
//        if(!player.equals(null))
//            playerRepo.save(player);
        return totalScoreOfTeam;
    }

}
