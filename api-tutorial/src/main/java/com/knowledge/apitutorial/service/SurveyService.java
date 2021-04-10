package com.knowledge.apitutorial.service;

import com.knowledge.apitutorial.model.Question;
import com.knowledge.apitutorial.model.Survey;
import org.springframework.stereotype.Component;

import java.util.List;

public interface SurveyService
{
    List<Survey> retrieveAllSurveys();
    Survey retrieveSurvey(String surveyId);
    List<Question> retrieveQuestions(String surveyId);
    Question retrieveQuestion(String surveyId, String questionId);
    Question addQuestion(String surveyId, Question question);
}
