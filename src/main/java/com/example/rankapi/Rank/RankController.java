package com.example.rankapi.Rank;

import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

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
