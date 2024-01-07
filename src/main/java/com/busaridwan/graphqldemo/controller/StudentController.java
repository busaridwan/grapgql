package com.busaridwan.graphqldemo.controller;

import com.busaridwan.graphqldemo.model.Level;
import com.busaridwan.graphqldemo.model.Student;
import com.busaridwan.graphqldemo.service.StudentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @QueryMapping
    public List<Student> findAll(){
        return service.findAll();
    }
    @QueryMapping
    public Optional<Student> findById(@Argument Integer id){
        return service.findById(id);
    }
    @MutationMapping
    public Student create(@Argument String name, @Argument Level level){
        return service.create(name, level);
    }
    @MutationMapping
    public Student update(@Argument Integer id, @Argument String name, @Argument Level level){
        return service.update(id,name,level);
    }
    @MutationMapping
    public Student delete(@Argument Integer id){
        return service.delete(id);
    }
}
