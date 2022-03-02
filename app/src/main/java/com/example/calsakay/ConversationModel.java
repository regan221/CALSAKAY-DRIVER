package com.example.calsakay;

public class ConversationModel {

    private String messageContent, messageTimestamp;
    private boolean isSent;

    public ConversationModel(String messageContent, String messageTimestamp, boolean isSent) {
        this.messageContent = messageContent;
        this.messageTimestamp = messageTimestamp;
        this.isSent = isSent;
    }

    @Override
    public String toString() {
        return "ConversationModel{" +
                "messageContent='" + messageContent + '\'' +
                ", messageTimestamp='" + messageTimestamp + '\'' +
                ", isSent=" + isSent +
                '}';
    }

    public String getMessageContent() {
        return messageContent;
    }

    public String getMessageTimestamp() {
        return messageTimestamp;
    }

    public boolean isSent() {
        return isSent;
    }
}
