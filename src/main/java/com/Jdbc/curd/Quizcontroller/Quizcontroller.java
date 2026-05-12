package com.Jdbc.curd.Quizcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Jdbc.curd.QuestionDto.QuestionDto;
import com.Jdbc.curd.QuestionDto.QuizSubmitDto;

import com.Jdbc.curd.Quizservice.Quizservice;
import com.Jdbc.curd.entity.Question;



@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class Quizcontroller {

    @Autowired
    private Quizservice service;

    @GetMapping("/{topic}")
    public List<QuestionDto> getQuestions(
            @PathVariable String topic){

        return service.getQuestions(topic);
    }

    @PostMapping("/submit")
    public int submitQuiz(
            @RequestBody List<QuizSubmitDto> answers){

        return service.calculateScore(answers);
    }

    @PostMapping("/add")
    public Question addQuestion(
            @RequestBody Question question){

        return service.addQuestion(question);
    }
}