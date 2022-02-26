package com.example.calsakay;

import java.util.Date;

public class Messages {

    private String sender;
    private int senderId;
    private String recipient;
    private int recipientId;
    private Date timestamp;
    private String message;
    private int id;

    public Messages(String sender, int senderId, String recipient, int recipientId, Date timestamp, String message, int id) {
        this.sender = sender;
        this.senderId = senderId;
        this.recipient = recipient;
        this.recipientId = recipientId;
        this.timestamp = timestamp;
        this.message = message;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "sender='" + sender + '\'' +
                ", senderId=" + senderId +
                ", recipient='" + recipient + '\'' +
                ", recipientId=" + recipientId +
                ", timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", id=" + id +
                '}';
    }

    public String getSender() {
        return sender;
    }

    public int getSenderId() {
        return senderId;
    }

    public String getRecipient() {
        return recipient;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }

}
