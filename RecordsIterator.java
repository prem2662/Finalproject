package CreditValidation;

import org.json.simple.JSONObject;

public interface RecordsIterator {
    boolean isDone();

    void next();

    JSONObject currentObject();
}