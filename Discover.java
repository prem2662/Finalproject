package CreditValidation;

public class Discover extends Card {

	public Discover(String card_number) {
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
                return value.substring(0, 4).equals("6011") ? "Discover" : "Invalid";
            } catch (Exception var5) {
                return "Invalid";
            }
        }
	}

}
