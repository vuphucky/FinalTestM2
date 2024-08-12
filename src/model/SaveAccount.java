package model;

public class SaveAccount extends BankAccount {
private int saveMoney;
private String daySaveMoney;
private String interest;
private String term;

    public int getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(int saveMoney) {
        this.saveMoney = saveMoney;
    }

    public String getDaySaveMoney() {
        return daySaveMoney;
    }

    public void setDaySaveMoney(String daySaveMoney) {
        this.daySaveMoney = daySaveMoney;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public SaveAccount() {
        super();
    }

    public SaveAccount(int id, String codeAccount, String name, String creationDate, int saveMoney, String daySaveMoney, String interest, String term) {
        super(id, codeAccount, name, creationDate);
        this.saveMoney = saveMoney;
        this.daySaveMoney = daySaveMoney;
        this.interest = interest;
        this.term = term;
    }

    @Override
    public String toString() {
        return super.toString() + ",save money= " + saveMoney + ",day save money= " + daySaveMoney + ",interest= " + interest + ",term=  " + term ;
    }
}
