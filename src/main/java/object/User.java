package object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by shafiq on 29/01/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private Integer id;
    private String first_name;
    private String username;

    public User() {
    }

    public User(int id, String first_name, String username) {
        this.id = id;
        this.first_name = first_name;
        this.username = username;
    }

    public User(int id, String first_name) {
        this.id = id;
        this.first_name = first_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
