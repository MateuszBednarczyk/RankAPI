package com.example.rankapi.Rank;

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

    public void deleteByGametitle(String gameTitle){

        rankRepository.deleteByGametitle(gameTitle);

    }

    public boolean checkRank(Rank rank, String gameTitle){

        if(rankRepository.findRankByGametitle(gameTitle) == null){

            return false;

        }else if(rank.getGametitle().equals(gameTitle)) {
            long oldScore = rankRepository.findRankByGametitle(gameTitle).getScore();
            long newScore = rank.getScore();
            if (newScore > oldScore) {

                return false;

            } else {

                return true;

            }
        }else if(!rank.getGametitle().equals(gameTitle)){

            return false;

        }else{

            long oldScore = rankRepository.findRankByGametitle(gameTitle).getScore();
            long newScore = rank.getScore();
            if (newScore>oldScore) {

                return false;

            }else{

                return true;

            }

        }
    }
}
