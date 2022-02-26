package com.example.rankapi.Rank;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.transaction.Transactional;

@RestController
public class RankController {

    private RankingService rankingService;

    public RankController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @GetMapping("/rank/{gameTitle}")
    public List<Rank> getRank(@PathVariable String gameTitle){

        return rankingService.getListedRank(gameTitle);

    }

    @Transactional
    @PostMapping("/rank/{gameTitle}/add")
    public List<Rank> addRank(@PathVariable String gameTitle, @RequestBody Rank rank){
        rankingService.addRank(gameTitle, rank);
        return rankingService.getListedRank(gameTitle);
    }

    //If u want to select only highest rank and post only highest rank for a game use this and
    // a checkRank in service

//    @Transactional
//    @PostMapping("/rank/{gameTitle}/add")
//    public Rank addRank(@RequestBody Rank rank, @PathVariable String gameTitle){
//        if(rankingService.checkRank(rank, gameTitle)){
//
//            return rankingService.getHighestRank(gameTitle);
//
//        }else{
//
//            rankingService.deleteByGametitle(gameTitle);
//            rankRepository.save(rank);
//            return rankingService.getHighestRank(gameTitle);
//
//        }
//    }

}
