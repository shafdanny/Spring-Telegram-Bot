package object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by shafiq on 29/01/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {
    private int message_id;
    private User from;
    private Chat chat;
    private int date;
    private String text;

    public Message(){}

    public Message(int message_id, User from, Chat chat, int date, String text) {
        this.message_id = message_id;
        this.from = from;
        this.chat = chat;
        this.date = date;
        this.text = text;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
