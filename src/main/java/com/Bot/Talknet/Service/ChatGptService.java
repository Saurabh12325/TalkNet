package com.Bot.Talknet.Service;

import com.Bot.Talknet.dto.ChatgptRequest;
import com.Bot.Talknet.dto.ChatgptResponse;
import com.Bot.Talknet.dto.PromptRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ChatGptService {
    private final RestClient restClient;

    public ChatGptService(RestClient restClient) {
        this.restClient = restClient;
    }
    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openapi.api.model}")
    private String model;

    public String getChatGptResponse(PromptRequest promptRequest) {
        ChatgptRequest chatgptRequest  = new ChatgptRequest(
                model,
                List.of(new ChatgptRequest.Messages("user", promptRequest.prompt()))
        );
      ChatgptResponse response= restClient.post()
               .header("Authorization", "Bearer " + apiKey)
               .header("content-type", "application/json")
               .body(chatgptRequest)
               .retrieve()
               .body(ChatgptResponse.class);
      return response.choices().get(0).messages().content();
    }
}
