package pl.merdala.multicurrencymoney;

class Sum implements Expression {
    public final Expression augment;
    public final Expression augend;

    private Sum(Expression augment, Expression augend) {
        this.augment = augment;
        this.augend = augend;
    }

    @Override
    public Money reduce(Wallet wallet, String toCurrency) {
        return augment.reduce(wallet,toCurrency).plus(augend.reduce(wallet,toCurrency)).reduce(wallet,toCurrency);
    }

    @Override
    public Expression plus(Expression augend) {
        return Sum.create(this,augend);
    }

    @Override
    public Expression times(int multiple) {
        return Sum.create(augment.times(multiple),augend.times(multiple));
    }

    public static Sum create(Expression augment, Expression augend){
        return new Sum(augment,augend);
    }
}
