package CreditValidation;

import java.io.File;

public class FileContext {
	private FileParser fileParser;
	
	public FileContext() {
		// TODO Auto-generated constructor stub
	}
	
	public void parse(String inputFilename, String outputFilename) {
        String input_file_extension = inputFilename.substring(inputFilename.lastIndexOf(".") + 1).toLowerCase();
        String output_file_extension = outputFilename.substring(outputFilename.lastIndexOf(".") + 1).toLowerCase();
        if (!input_file_extension.equals(output_file_extension)) {
            System.out.println("Please enter the same type of files.");
        } else {
            try {
            	this.fileParser = new JsonFileParser();
                this.fileParser.fetchRecords(inputFilename);
                File file = new File(outputFilename);
                file.createNewFile();
                this.fileParser.processRecords(outputFilename);
            } catch (Exception var6) {
                System.out.print("Error while Parsing File:" + var6);
            }

        }
    }
	

}
