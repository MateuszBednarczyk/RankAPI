package com.example.rankapi.Controllers;

import com.example.rankapi.Entities.Rank;
import com.example.rankapi.Repositories.RankRepository;
import com.example.rankapi.Services.RankingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankController {

    private RankingService rankingService;

    public RankController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @GetMapping("/rank/{gameTitle}")
    public Rank getHighestRank(@PathVariable String gameTitle){

        return rankingService.getHighestRank(gameTitle);

    }

}
