package Behavioral.chainOfResponsibility;

import Behavioral.chainOfResponsibility.accuonts.Account;
import Behavioral.chainOfResponsibility.accuonts.AccountFactory;

public class Example {
    public static void main(String[] args) {
        Account account = AccountFactory.create();
        account.pay(123d);
        account.pay(1234d);
        account.pay(12345d);
        account.pay(123456d);
    }
}
