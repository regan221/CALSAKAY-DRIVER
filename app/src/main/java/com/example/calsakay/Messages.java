package com.example.calsakay;

import java.util.Date;

public class Messages {

    private int senderId;
    private int recieverId;
    private Date timestamp;
    private String message;
    private int id;
    private String threadName;
    private String messageType;
    private boolean isRead;

    public Messages(int senderId, int recieverId, Date timestamp, String message, int id, String threadName, String messageType, boolean isRead) {
        this.senderId = senderId;
        this.recieverId = recieverId;
        this.timestamp = timestamp;
        this.message = message;
        this.id = id;
        this.threadName = threadName;
        this.messageType = messageType;
        this.isRead = isRead;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "senderId=" + senderId +
                ", recieverId=" + recieverId +
                ", timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", id=" + id +
                ", threadName='" + threadName + '\'' +
                ", messageType='" + messageType + '\'' +
                ", isRead=" + isRead +
                '}';
    }

    public int getSenderId() {
        return senderId;
    }

    public int getRecieverId() {
        return recieverId;
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

    public String getThreadName() {
        return threadName;
    }

    public String getMessageType() {
        return messageType;
    }

    public boolean isRead() {
        return isRead;
    }
}
