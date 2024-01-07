package com.busaridwan.graphqldemo.service;

import com.busaridwan.graphqldemo.model.Level;
import com.busaridwan.graphqldemo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();
    AtomicInteger id = new AtomicInteger(0);
    public List<Student> findAll(){
        return students;
    }
    public Optional<Student> findById(Integer studentId){
        return students.stream().filter(student -> student.id() == studentId).findFirst();
    }
    public Student create(String name, Level level){
        Student student = new Student(id.incrementAndGet(), name, level);
        students.add(student);
        return student;
    }
    public Student delete(Integer studentId){
        Student student = students.stream().filter(s -> s.id() == studentId)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Student not found"));
        students.remove(student);
        return student;
    }
    public Student update(Integer studentId, String name, Level level){
        Student updatedStudent = new Student(studentId,name,level);
        Optional<Student> student = findById(studentId);
        if (student.isPresent()){
            int index = students.indexOf(student.get());
            students.set(index, updatedStudent);
        }else {
            throw new IllegalArgumentException("Invalid student record");
        }
        return updatedStudent;
    }
}
