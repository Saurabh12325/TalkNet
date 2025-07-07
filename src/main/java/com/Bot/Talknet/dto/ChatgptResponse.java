package com.Bot.Talknet.dto;

import java.util.List;

public record ChatgptResponse(List<Choice> choices) {

    public static record Choice(Messages messages) {
        public static record Messages(String role,String content) {
        }
    }
}
