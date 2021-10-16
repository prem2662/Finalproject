package CreditValidation;

public class MasterCard extends Card {

	public MasterCard(String card_number) {
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
                return value.charAt(1) != '1' && value.charAt(1) != '2' && value.charAt(1) != '3' && value.charAt(1) != '4' && value.charAt(1) != '5' ? "Invalid" : "MasterCard";
            } catch (Exception var5) {
                return "Invalid";
            }
        }
	}

}
