package com.example.service;

import com.example.pojo.Teacher;

public interface TeacherService {
    public Teacher findByJobId(String jobId);
    public Teacher updateTeacherByJobId(Teacher t);
    public void deleteTeacherByJobId(String jobId);
}
