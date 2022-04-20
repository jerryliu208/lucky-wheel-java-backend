package com.developerExam.backend.Repository;

import com.developerExam.backend.Model.Prize;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrizeRepository extends JpaRepository<Prize, Integer> {
    List<Prize> findAll();
    Prize findOneById(Integer id);
}
