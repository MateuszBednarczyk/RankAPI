package com.example.rankapi.Controllers;

import com.example.rankapi.Entities.Rank;
import com.example.rankapi.Repositories.RankRepository;
import com.example.rankapi.Services.RankingService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.security.Principal;

@RestController
public class RankController {

    private RankingService rankingService;
    private RankRepository rankRepository;

    public RankController(RankingService rankingService, RankRepository rankRepository) {
        this.rankingService = rankingService;
        this.rankRepository = rankRepository;
    }

    @GetMapping("/rank/{gameTitle}")
    public Rank getHighestRank(@PathVariable String gameTitle){

        return rankingService.getHighestRank(gameTitle);

    }

    @Transactional
    @PostMapping("/rank/{gameTitle}/add")
    public Rank addRank(@RequestBody Rank rank, @PathVariable String gameTitle){
        if(rankingService.checkRank(rank, gameTitle)){

            return rankingService.getHighestRank(gameTitle);

        }else{

            rankingService.deleteByGametitle(gameTitle);
            rankRepository.save(rank);
            return rankingService.getHighestRank(gameTitle);

        }
    }
}
