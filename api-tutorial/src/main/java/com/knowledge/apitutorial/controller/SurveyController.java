package com.knowledge.apitutorial.controller;

import com.knowledge.apitutorial.model.Question;
import com.knowledge.apitutorial.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class SurveyController
{
    @Autowired
    //@Qualifier("SurveyService")
    private SurveyService surveyService;

    @GetMapping("/surveys/{surveyId}/questions")
    public List<Question> retrieveQuestionsForSurvey(@PathVariable String surveyId)
    {
        return surveyService.retrieveQuestions(surveyId);
    }

    @GetMapping("/surveys/{surveyId}/questions/{questionId}")
    public Question retrieveDetailsFromQuestion(@PathVariable String surveyId,
                                                     @PathVariable String questionId)
    {
        return surveyService.retrieveQuestion(surveyId, questionId);
    }

    @PostMapping("/surveys/{surveyId}/questions")
    public ResponseEntity<Question> addQuestion(@PathVariable String surveyId, @RequestBody Question question)
    {
        Question createdQuestion = surveyService.addQuestion(surveyId, question);
        if(createdQuestion == null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdQuestion.getId()).toUri();

        return ResponseEntity.created(location).body(createdQuestion);
    }
}
