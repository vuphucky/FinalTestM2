package model;

public abstract class BankAccount {
    private int id;
    private String codeAccount;
    private String name;
    private String creationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeAccount() {
        return codeAccount;
    }

    public void setCodeAccount(String codeAccount) {
        this.codeAccount = codeAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public BankAccount() {
    }

    public BankAccount(int id, String codeAccount, String name, String creationDate) {
        this.id = id;
        this.codeAccount = codeAccount;
        this.name = name;
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", codeAccount='" + codeAccount + '\'' +
                ", name='" + name + '\'' +
                ", creationDate='" + creationDate + '\'';
    }
}
