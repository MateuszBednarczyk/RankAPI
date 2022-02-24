package com.example.rankapi.Services;

import com.example.rankapi.Entities.Rank;
import com.example.rankapi.Repositories.RankRepository;
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

        }else{
            long oldScore = rankRepository.findRankByGametitle(gameTitle).getScore();
            long newScore = rank.getScore();
            if (newScore>oldScore){

                return false;

            }else{

                return true;

            }
        }
    }
}
