package se.lexicon.flightbooking_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.flightbooking_api.model.Answer;
import se.lexicon.flightbooking_api.model.Question;
import se.lexicon.flightbooking_api.service.OpenAIService;

@RestController
@RequiredArgsConstructor
public class AIChatController {

    private final OpenAIService openAIService;

    @PostMapping("/chat")
    public Answer askQuestion(@RequestBody Question question) {
        return openAIService.askQuestion(question);
    }


}
