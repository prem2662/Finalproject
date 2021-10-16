package CreditValidation;

import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileParser implements FileParser {
    private JSONArray output_records = new JSONArray();
    private JSONArray records = new JSONArray();

    public JsonFileParser() {
    }

    public void fetchRecords(String inputFilename) {
        JSONParser jsonParser = new JSONParser();

        try {
            FileReader reader = new FileReader(inputFilename);
            Throwable var4 = null;

            try {
                Object obj = jsonParser.parse(reader);
                this.records = (JSONArray)obj;
            } catch (Throwable var16) {
                var4 = var16;
                throw var16;
            } finally {
                if (reader != null) {
                    if (var4 != null) {
                        try {
                            reader.close();
                        } catch (Throwable var15) {
                            var4.addSuppressed(var15);
                        }
                    } else {
                        reader.close();
                    }
                }

            }
        } catch (FileNotFoundException var18) {
            var18.printStackTrace();
        } catch (IOException var19) {
            var19.printStackTrace();
        } catch (ParseException var20) {
            var20.printStackTrace();
        }

    }

    public void processRecords(String outputFilename) {
        RecordsIteratorImpl iterator = new RecordsIteratorImpl(this.records, this.records.size());

        while(!iterator.isDone()) {
            JSONObject record = iterator.currentObject();
            JSONObject output = this.processEachRecord(record);
            this.output_records.add(output);
            iterator.next();
        }

        this.writeFile(outputFilename);
    }

    public JSONObject processEachRecord(JSONObject record) {
        String card_type = "Invalid";
        String error_message = "None";
        JSONObject row = new JSONObject();

        String card_number;
        try {
            card_number = record.get("CardNumber").toString();
        } catch (Exception var10) {
            error_message = "InvalidCardNumber";
            card_type = "Invalid";
            row.put("CardNumber", 0);
            row.put("CardType", card_type);
            row.put("Error", error_message);
            return row;
        }

        CardFactory cardFactory = new CardFactoryImpl();
        Card card = cardFactory.createCard(card_number);
        if (card == null) {
            error_message = "InvalidCardNumber";
            card_type = "Invalid";
            row.put("CardNumber", Long.parseLong(card_number));
            row.put("CardType", card_type);
            row.put("Error", error_message);
            return row;
        } else {
            String output = card.validateCardType(card_number);
            if (output.equals("Invalid")) {
                error_message = "InvalidCardNumber";
            }

            row.put("CardNumber", Long.parseLong(card_number));
            row.put("CardType", output);
            row.put("Error", error_message);
            return row;
        }
    }

    public void writeFile(String outputFilename) {
        try {
            FileWriter file = new FileWriter(outputFilename);
            Throwable var3 = null;

            try {
                file.write(this.output_records.toJSONString());
            } catch (Throwable var13) {
                var3 = var13;
                throw var13;
            } finally {
                if (file != null) {
                    if (var3 != null) {
                        try {
                            file.close();
                        } catch (Throwable var12) {
                            var3.addSuppressed(var12);
                        }
                    } else {
                        file.close();
                    }
                }

            }
        } catch (IOException var15) {
            var15.printStackTrace();
        }

    }
}