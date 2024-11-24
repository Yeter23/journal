package com.yeter.journal.controller;

import com.yeter.journal.entity.Lecture;

import com.yeter.journal.entity.User;
import com.yeter.journal.service.ILectureService;
import com.yeter.journal.service.impl.LectureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lectures")
public class LectureController {
    private final ILectureService lectureService;

    public LectureController(ILectureService lectureService) {
        this.lectureService = lectureService;
    }
    @GetMapping

    ResponseEntity<Page<Lecture>> getLectures(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(lectureService.getAll(PageRequest.of(page, pageSize, Sort.by("id"))));
    }
    @PostMapping
    public ResponseEntity<Lecture> createLecture(@RequestBody Lecture lecture){
        return ResponseEntity.ok(lectureService.save(lecture));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteLecture(@PathVariable Integer id) {
        lectureService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    ResponseEntity<Lecture> getLecture(@PathVariable Integer id) {
        return ResponseEntity.ok(lectureService.getById(id));
    }
}
