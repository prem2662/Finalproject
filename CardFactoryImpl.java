package CreditValidation;

public class CardFactoryImpl implements CardFactory {
    public CardFactoryImpl() {
    	
    }

    public Card createCard(String card_number) {
        if (card_number.equals("")) {
            return null;
        } else {
            try {
                long number = Double.valueOf(card_number).longValue();
                String value = Long.toString(number);
                if (value.length() <= 16) {
                    if (value.length() == 15) {
                        return new AmericanExpressCard(card_number);
                    } else if (value.length() == 16 && value.charAt(0) == '5') {
                        return new MasterCard(card_number);
                    } else if (value.length() == 16 && value.charAt(0) == '6') {
                        return new Discover(card_number);
                    } else {
                        return (value.length() == 13 || value.length() == 16) && value.charAt(0) == '4' ? new Visa(card_number) : null;
                    }
                } else {
                    return null;
                }
            } catch (Exception var5) {
                return null;
            }
        }
    }
}