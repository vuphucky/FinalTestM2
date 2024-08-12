package model;

public class PaymentAccount extends BankAccount{
    private String cardNumber;
    private int moneyInAccount;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getMoneyInAccount() {
        return moneyInAccount;
    }

    public void setMoneyInAccount(int moneyInAccount) {
        this.moneyInAccount = moneyInAccount;
    }

    public PaymentAccount() {
        super();
    }

    public PaymentAccount(int id, String codeAccount, String name, String creationDate, String cardNumber, int moneyInAccount) {
        super(id, codeAccount, name, creationDate);
        this.cardNumber = cardNumber;
        this.moneyInAccount = moneyInAccount;
    }

    @Override
    public String toString() {
        return super.toString() + ",card number= " + cardNumber + ",money in account= " + moneyInAccount;
    }
}
