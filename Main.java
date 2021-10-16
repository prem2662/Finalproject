package CreditValidation;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
        try {
            FileContext fc = new FileContext();
            String inputFilename = "CreditValidation/"+ args[0];
            String outputFilename = "CreditValidation/" + args[1];
            fc.parse(inputFilename, outputFilename);
        } catch (Exception var4) {
            System.out.print("Error: " + var4);
        }

    }

}
