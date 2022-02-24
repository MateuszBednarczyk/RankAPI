package com.example.rankapi.Repositories;

import com.example.rankapi.Entities.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankRepository extends JpaRepository<Rank, Long> {
    Rank findRankByGametitle(String gameTitle);
    void deleteByGametitle(String gameTitle);
}
