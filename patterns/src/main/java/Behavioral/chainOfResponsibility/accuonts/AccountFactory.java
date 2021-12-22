package Behavioral.chainOfResponsibility.accuonts;

public class AccountFactory {
    private AccountFactory() {

    }

    public static Account create() {
        Account bank = new Bank(123d);
        Account payPal = new PayPal(1234d);
        bank.setNext(payPal);
        Account bitcoin = new BitCoin(12345d);
        payPal.setNext(bitcoin);
        return bank;
    }
}
