package CreditValidation;

public class Visa extends Card {

	public Visa(String card_number) {
		super(card_number);
		 
	}

	@Override
	String validateCardType(String card_number) {
		if (card_number.equals("")) {
            return "Invalid";
        } else {
            try {
                long number = Double.valueOf(card_number).longValue();
                String value = Long.toString(number);
                return (value.length() == 13 || value.length() == 16) && value.charAt(0) == '4' ? "Visa" : "Invalid";
            } catch (Exception var5) {
                return "Invalid";
            }
        }
	}

}
