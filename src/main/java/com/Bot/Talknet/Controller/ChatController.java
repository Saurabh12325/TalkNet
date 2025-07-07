package com.Bot.Talknet.Controller;

import com.Bot.Talknet.Service.ChatGptService;
import com.Bot.Talknet.dto.PromptRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatGptService chatGptService;

    public ChatController(ChatGptService chatGptService) {
        this.chatGptService = chatGptService;
    }

    @PostMapping
    public String chat(@RequestBody PromptRequest promptRequest) {
        return chatGptService.getChatGptResponse(promptRequest);
    }
}
