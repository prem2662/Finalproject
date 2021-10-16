package CreditValidation;

public class AmericanExpressCard extends Card {

	public AmericanExpressCard(String card_number) {
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
                return value.charAt(0) != '3' || value.charAt(1) != '4' && value.charAt(1) != '7' ? "Invalid" : "AmericanExpress";
            } catch (Exception var5) {
                return "Invalid";
            }
        }
	}

}
