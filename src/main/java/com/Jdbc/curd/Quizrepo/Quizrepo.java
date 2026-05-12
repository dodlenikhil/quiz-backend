package com.Jdbc.curd.Quizrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jdbc.curd.entity.Question;



@Repository
public interface Quizrepo extends JpaRepository<Question, Long>{

    List<Question> findByTopic(String topic);

	

}
