package method;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import object.Response;
import object.Update;
import object.User;

import java.util.ArrayList;

/**
 * Created by shafiq on 29/01/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUpdatesResponse extends Response{

    public void setResult(ArrayList<Update> result) {
        super.setResult(result);
    }
}