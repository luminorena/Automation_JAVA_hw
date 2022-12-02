package OOP;

public abstract class Card {
    String cardHolder;
    int balance;
    String cardNumber;
    PaymentSystem paymentSystem;

    public Card(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    abstract void  payInCountry (Country country, int amout);
}
