package Behavioral.chainOfResponsibility.accuonts;

public abstract class Account {
    protected Account next;
    protected double balance;

    Account(double balance) {
        this.balance = balance;
    }

    public void setNext(Account account) {
        this.next = account;
    }

    public void pay(double amount) {
        if (this.canPay(amount)) {
            System.out.println(this.getClass().getSimpleName() + " payed");
        } else if (next != null) {
            next.pay(amount);
            return;
        } else {
            System.out.println("None of the accounts have enough balance");
        }
    }

    private boolean canPay(double amount) {
        return balance >= amount;
    }
}
