package object;

import java.util.ArrayList;

/**
 * Created by shafiq on 29/01/16.
 */
public abstract class Response {
    private boolean ok;
    private Object result;

    public Response() {
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

    public <T> void setResult(T result) {
        this.result = result;
    }
}
