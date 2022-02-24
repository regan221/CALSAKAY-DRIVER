package com.example.calsakay;

public class Messages {

    private String messageSender;
    private String messagePreview;
    private String messageTimestamp;

    public Messages(String messageSender, String messagePreview, String messageTimestamp) {
        this.messageSender = messageSender;
        this.messagePreview = messagePreview;
        this.messageTimestamp = messageTimestamp;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "messageSender='" + messageSender + '\'' +
                ", messagePreview='" + messagePreview + '\'' +
                ", messageTimestamp='" + messageTimestamp + '\'' +
                '}';
    }

    public String getMessageSender() {
        return messageSender;
    }

    public void setMessageSender(String messageSender) {
        this.messageSender = messageSender;
    }

    public String getMessagePreview() {
        return messagePreview;
    }

    public void setMessagePreview(String messagePreview) {
        this.messagePreview = messagePreview;
    }

    public String getMessageTimestamp() {
        return messageTimestamp;
    }

    public void setMessageTimestamp(String messageTimestamp) {
        this.messageTimestamp = messageTimestamp;
    }
}
