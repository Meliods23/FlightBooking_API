package se.lexicon.flightbooking_api;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.lexicon.flightbooking_api.service.aiTools.FlightTools;

@SpringBootApplication
public class FlightBookingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightBookingApiApplication.class, args);
    }

    @Bean
    public ChatClient chatClient(ChatModel chatModel, FlightTools flightTools) {
        ChatClient.Builder builder = ChatClient.builder(chatModel);
        builder.defaultTools(flightTools);

        return builder.build();
    }
}
