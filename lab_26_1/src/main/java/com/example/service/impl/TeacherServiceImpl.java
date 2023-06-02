package com.example.service.impl;

import com.example.pojo.Teacher;
import com.example.repository.TeacherRepository;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    @Cacheable(cacheNames = "teacher",unless = "#result==null")
    public Teacher findByJobId(String jobId) {
        Optional<Teacher> teacherOptional=teacherRepository.findById(jobId);
        if (teacherOptional.isPresent()){
            return teacherOptional.get();
        }
        return null;
    }

    @Override
    @CachePut(cacheNames = "teacher",key = "#result.jobId")
    public Teacher updateTeacherByJobId(Teacher t) {
        Teacher teacher=teacherRepository.save(t);
        return teacher;
    }

    @Override
    @CacheEvict(cacheNames = "teacher")
    public void deleteTeacherByJobId(String jobId) {
        teacherRepository.deleteById(jobId);
    }
}
