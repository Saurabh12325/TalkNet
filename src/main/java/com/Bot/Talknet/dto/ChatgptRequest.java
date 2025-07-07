package com.Bot.Talknet.dto;

import java.util.List;

public record ChatgptRequest(String model, List<Messages> messages) {

    public static record Messages(String role, String content) {}

}


//record is a special class in java 17 that allows you to create a class with a constructor and some field