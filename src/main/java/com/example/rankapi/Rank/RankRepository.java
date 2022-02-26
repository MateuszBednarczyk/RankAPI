package com.example.rankapi.Rank;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankRepository extends JpaRepository<Rank, Long> {
    Rank findRankByGametitle(String gameTitle);
    List<Rank> findAllByGametitleOrderByScore(String gameTitle);
    void deleteRankByGametitleAndUsername(String gameTitle, String username);
}
