package OOP;

public class VisaCard extends Card{

    public VisaCard() {
        super(PaymentSystem.VISA);
    }

    @Override
    void payInCountry(Country country, int amount) {

    }
}
