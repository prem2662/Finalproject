package CreditValidation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RecordsIteratorImpl implements RecordsIterator {
	
	private JSONArray json_records; 
	private int cursor;
    private int max;
    
	@Override
	public boolean isDone() {
        return this.max == this.cursor;
    }
	
	public RecordsIteratorImpl(JSONArray r, int size) {
        this.json_records = r;
        this.cursor = 0;
        this.max = size;
    }

	@Override
	public void next() {
        ++this.cursor;
    }
	
	@Override
	public JSONObject currentObject() {
        return (JSONObject)this.json_records.get(this.cursor);
    }

}
