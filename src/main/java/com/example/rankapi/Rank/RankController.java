package com.example.rankapi.Rank;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
public class RankController {

    private RankService rankService;

    public RankController(RankService rankingService) {
        this.rankService = rankingService;
    }

    @GetMapping("/rank/{gameTitle}")
    public List<Rank> getRank(@PathVariable String gameTitle){

        return rankService.getListedRank(gameTitle);

    }

    @GetMapping("/playerusername")
    public String getPlayerUsername(Principal principal){

        return principal.getName();

    }

    @Transactional
    @PostMapping("/rank/{gameTitle}/add")
    public List<Rank> addRank(@PathVariable String gameTitle, @RequestBody Rank rank){
        rankService.addRank(gameTitle, rank);
        return rankService.getListedRank(gameTitle);
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
