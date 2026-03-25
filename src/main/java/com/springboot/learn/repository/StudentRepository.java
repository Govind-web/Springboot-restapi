package com.springboot.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.learn.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
