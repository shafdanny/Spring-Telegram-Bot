package object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by shafiq on 29/01/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Update {
    private int update_id;
    private Message message;

    public Update(){
    }

    public Update(int update_id, Message message) {
        this.update_id = update_id;
        this.message = message;
    }

    public int getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(int update_id) {
        this.update_id = update_id;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
