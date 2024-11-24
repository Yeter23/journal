package com.yeter.journal.service.impl;

import com.yeter.journal.common.GeneralException;
import com.yeter.journal.entity.Lecture;
import com.yeter.journal.repository.LectureRepository;
import com.yeter.journal.service.ILectureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
@Service

public class LectureService implements ILectureService {
    private  final LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Override
    public Lecture save(Lecture lecture) {
        if (StringUtils.isEmpty(lecture.getName())) {
            throw new GeneralException("name con not be empty");
        }
        if (lecture.getTeacher() == null) {
            throw new GeneralException("teacher can not be empty");
        }
        return lectureRepository.save(lecture);
    }

    @Override
    public Lecture getById(Integer id) {
        return lectureRepository.findById(id).orElseThrow(()->new GeneralException("lecture not found"));
    }

    @Override
    public List<Lecture> getAll() {
        return lectureRepository.findAll();
    }

    @Override
    public  Page<Lecture>getAll(Pageable pageable) {
        return lectureRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        if (!lectureRepository.existsById(id)) {
           throw new GeneralException("lecture is not exists") ;
        }
        lectureRepository.deleteById(id);
    }
}
