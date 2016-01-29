package method;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import object.Update;
import object.User;

import java.util.ArrayList;

/**
 * Created by shafiq on 29/01/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUpdatesResponse {
    private boolean ok;
    private Object result;

    public GetUpdatesResponse() {
    }

    public GetUpdatesResponse(boolean ok, Object result){
        this.ok = ok;
        this.result = result;
    }

    public boolean getOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(ArrayList<Update> result) {
        this.result = result;
    }
}