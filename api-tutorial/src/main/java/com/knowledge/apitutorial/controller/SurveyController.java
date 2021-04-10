package com.knowledge.apitutorial.controller;

import com.knowledge.apitutorial.model.Question;
import com.knowledge.apitutorial.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
