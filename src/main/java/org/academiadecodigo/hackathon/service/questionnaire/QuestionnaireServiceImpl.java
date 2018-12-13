package org.academiadecodigo.hackathon.service.questionnaire;

import org.academiadecodigo.hackathon.questionnaire.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService{


    @Override
    public List<Question> questionsList() {
        return null;
    }

    @Override
    public String[] answers() {
        return new String[0];
    }
}
