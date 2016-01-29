package object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by shafiq on 29/01/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Chat {
    private int id;
    private String type;
    private String first_name;

    public Chat() {
    }

    public Chat(int id, String type, String first_name) {
        this.id = id;
        this.type = type;
        this.first_name = first_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
