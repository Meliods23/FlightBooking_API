package se.lexicon.flightbooking_api.service;

import se.lexicon.flightbooking_api.model.Answer;
import se.lexicon.flightbooking_api.model.Question;

public interface OpenAIService {

    Answer askQuestion(Question question);
}
