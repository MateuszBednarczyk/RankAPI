package com.example.rankapi.Rank;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RankingService {

    private RankRepository rankRepository;

    public RankingService(RankRepository rankRepository) {
        this.rankRepository = rankRepository;
    }

    public Rank getHighestRank(String gameTitle) {

        return rankRepository.findRankByGametitle(gameTitle);

    }

    public List<Rank> getListedRank(String gameTitle){

        return rankRepository.findAllByGametitleOrderByScore(gameTitle);

    }

    public void addRank(String gameTitle, Rank rank){

        for (Rank entityInRank : rankRepository.findAllByGametitleOrderByScore(gameTitle)) {
            if (entityInRank.getUsername().equals(rank.getUsername()) & rank.getScore() > entityInRank.getScore()) {

                rankRepository.deleteRankByGametitleAndUsername(gameTitle, rank.getUsername());
                rankRepository.save(rank);

            }
        }

        if(rankRepository.findAllByGametitleOrderByScore(gameTitle)
                .stream()
                .noneMatch(newRank -> newRank.getUsername().equals(rank.getUsername()) &
                newRank.getGametitle().equals(rank.getGametitle()))){

            rankRepository.save(rank);

        }
    }

    //Getting value for only highest rank

//    public boolean checkRank(Rank rank, String gameTitle){
//
//        if(rankRepository.findRankByGametitle(gameTitle) == null){
//
//            return false;
//
//        }else if(rank.getGametitle().equals(gameTitle)) {
//            long oldScore = rankRepository.findRankByGametitle(gameTitle).getScore();
//            long newScore = rank.getScore();
//            if (newScore > oldScore) {
//
//                return false;
//
//            } else {
//
//                return true;
//
//            }
//        }else if(!rank.getGametitle().equals(gameTitle)){
//
//            return false;
//
//        }else{
//
//            long oldScore = rankRepository.findRankByGametitle(gameTitle).getScore();
//            long newScore = rank.getScore();
//            if (newScore>oldScore) {
//
//                return false;
//
//            }else{
//
//                return true;
//
//            }
//
//        }
//    }
}
