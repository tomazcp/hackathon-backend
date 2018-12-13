package org.academiadecodigo.hackathon.service.questionnaire;

import org.academiadecodigo.hackathon.questionnaire.Question;

import java.util.List;

public interface QuestionnaireService {

    List<Question> questionsList();

    String[] answers();

}

