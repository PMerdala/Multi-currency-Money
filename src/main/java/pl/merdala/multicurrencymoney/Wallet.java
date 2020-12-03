package pl.merdala.multicurrencymoney;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Wallet {

    private final Map<Pair<String>,BigDecimal> rates = new HashMap<>();

    private Pair<String> createKey(String fromCurrency, String toCurrency){
        return new Pair<>(fromCurrency,toCurrency);
    }

    private boolean isTheSameCurrency(String fromCurrency, String toCurrency){
        return fromCurrency != null && fromCurrency.equals(toCurrency);
    }

    public Wallet addRate(String fromCurrency, String toCurrency,BigDecimal rate){
        Pair<String> key = createKey(fromCurrency,toCurrency);
        if (!rates.containsKey(key)){
            rates.put(key,rate);
        }else{
            rates.replace(key,rate);
        }
        return this;
    }

    public Money reduce(Expression expression, String toCurrency) {
        return expression.reduce(this,toCurrency);
    }

    public BigDecimal rate(String fromCurrency, String toCurrency){
        if (isTheSameCurrency(fromCurrency,toCurrency))
            return BigDecimal.ONE;
        return rates.get(createKey(fromCurrency,toCurrency));
    }

    public static Wallet create(){
        return new Wallet();
    }
}
