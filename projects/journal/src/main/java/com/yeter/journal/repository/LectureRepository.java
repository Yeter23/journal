package com.yeter.journal.repository;

import com.yeter.journal.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository  extends JpaRepository <Lecture,Integer> {
}
