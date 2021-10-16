package CreditValidation;

import javax.xml.transform.TransformerException;

public interface FileParser {
    void processRecords(String var1);

    void fetchRecords(String var1);

    void writeFile(String var1) throws TransformerException;
}
