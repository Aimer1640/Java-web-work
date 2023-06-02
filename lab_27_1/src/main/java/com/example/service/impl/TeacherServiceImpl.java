package com.example.service.impl;

import com.example.pojo.Teacher;
import com.example.repository.TeacherRepository;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Teacher findByJobId(String jobId) {
        Object o= redisTemplate.opsForValue().get(jobId);
        if (o!=null){
            return (Teacher) o;
        }
        else {
            Optional<Teacher> teacherOptional=teacherRepository.findById(jobId);
            if (teacherOptional.isPresent()){
                Teacher teacher=teacherOptional.get();
                redisTemplate.opsForValue().set(jobId,teacher,10, TimeUnit.MINUTES);
                return teacherOptional.get();
            }
            return null;
        }
    }

    @Override
    public Teacher updateTeacherByJobId(Teacher t) {
        Teacher teacher=teacherRepository.save(t);
        redisTemplate.opsForValue().set(t.getJobId(),teacher);
        return teacher;
    }

    @Override
    public void deleteTeacherByJobId(String jobId) {
        teacherRepository.deleteById(jobId);
        redisTemplate.delete(jobId);
    }
}
