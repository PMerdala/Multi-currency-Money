package pl.merdala.multicurrencymoney;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Wallet {

    private final Map<String,BigDecimal> rates = new HashMap<>();

    private String createKey(String fromCurrency, String toCurrency){
        return fromCurrency+toCurrency;
    }

    public Wallet addRate(String fromCurrency, String toCurrency,BigDecimal rate){
        String key = createKey(fromCurrency,toCurrency);
        if (rates.get(key)==null){
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
        if (fromCurrency.equals(toCurrency))
            return BigDecimal.ONE;
        return rates.get(createKey(fromCurrency,toCurrency));
    }

    public static Wallet create(){
        return new Wallet();
    }
}
