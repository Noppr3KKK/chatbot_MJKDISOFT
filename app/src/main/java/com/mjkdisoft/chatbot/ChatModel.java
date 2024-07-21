package com.mjkdisoft.chatbot;

// ChatModel.java
public class ChatModel {
    private String message;
    private boolean isBot;
    private String timeSent;

    @Override
    public String toString() {
        return "ChatModel{" +
                "message='" + message + '\'' +
                ", isBot=" + isBot +
                ", timeSent='" + timeSent + '\'' +
                '}';
    }

    public ChatModel(String message, boolean isBot, String timeSent) {
        this.message = message;
        this.isBot = isBot;
        this.timeSent = timeSent;
    }

    public String getMessage() {
        return message;
    }

    public boolean isBot() {
        return isBot;
    }
    public String getTimeSent() {
        return timeSent;
    }

}
