package pl.merdala.multicurrencymoney;

public interface Expression {
    Money reduce(Wallet wallet, String currency);
}
