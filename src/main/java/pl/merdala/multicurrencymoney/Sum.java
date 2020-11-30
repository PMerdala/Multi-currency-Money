package pl.merdala.multicurrencymoney;

class Sum implements Expression {
    public final Expression augmend;
    public final Expression augend;

    public Sum(Expression augmend, Expression augend) {
        this.augmend = augmend;
        this.augend = augend;
    }

    @Override
    public Money reduce(Wallet wallet, String toCurrency) {
        return augmend.reduce(wallet,toCurrency).plus(augend.reduce(wallet,toCurrency)).reduce(wallet,toCurrency);
    }
}
