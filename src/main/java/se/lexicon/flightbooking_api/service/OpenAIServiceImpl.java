package se.lexicon.flightbooking_api.service;

import lombok.AllArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;
import se.lexicon.flightbooking_api.model.Answer;
import se.lexicon.flightbooking_api.model.Question;
import se.lexicon.flightbooking_api.service.aiTools.FlightTools;


@Service
@AllArgsConstructor
public class OpenAIServiceImpl implements OpenAIService {

    private final FlightBookingService flightBookingService;
    private final ChatClient chatClient;

    @Override
    public Answer askQuestion(Question question) {
        PromptTemplate promptTemplate = new PromptTemplate(question.question());
        Prompt prompt = promptTemplate.create();

        ChatResponse chatResponse = chatClient.prompt(prompt).call().chatResponse();

        return new Answer(chatResponse.getResult().getOutput().getText());
    }
}
