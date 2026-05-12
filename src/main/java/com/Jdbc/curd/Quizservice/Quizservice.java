package com.Jdbc.curd.Quizservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jdbc.curd.QuestionDto.QuestionDto;
import com.Jdbc.curd.QuestionDto.QuizSubmitDto;
import com.Jdbc.curd.Quizrepo.Quizrepo;
import com.Jdbc.curd.entity.Question;



@Service
public class Quizservice {

    @Autowired
    private Quizrepo repo;

    public List<QuestionDto> getQuestions(String topic){

        List<Question> questions =repo.findByTopicIgnoreCase(topic);

        List<QuestionDto> dtoList = new ArrayList<>();

        for(Question q : questions){

            QuestionDto dto = new QuestionDto();

            dto.setId(q.getId());
            dto.setQuestion(q.getQuestion());
            dto.setOption1(q.getOption1());
            dto.setOption2(q.getOption2());
            dto.setOption3(q.getOption3());
            dto.setOption4(q.getOption4());

            dtoList.add(dto);
        }

        return dtoList;
    }

    public int calculateScore(List<QuizSubmitDto> answers){

        int score = 0;

        for(QuizSubmitDto dto : answers){

            Question question =
                repo.findById(dto.getQuestionId()).get();

            if(question.getAnswer()
                .equals(dto.getSelectedAnswer())){

                score++;
            }
        }

        return score;
    }

	public Question addQuestion(Question question){

    return repo.save(question);
}
}
