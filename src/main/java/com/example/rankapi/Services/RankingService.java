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

}
