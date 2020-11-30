package pl.merdala.multicurrencymoney;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    @Test
    void addRateNewRate() {
        Wallet wallet = Wallet.create();
        wallet.addRate("USD", "PLN", BigDecimal.valueOf(4));
        assertEquals(BigDecimal.valueOf(4), wallet.rate("USD", "PLN"));
    }

    @Test
    void addRateReplaceRate() {
        Wallet wallet = Wallet.create()
                .addRate("CHF", "USD", BigDecimal.valueOf(3))
                .addRate("CHF", "USD", BigDecimal.valueOf(4));
        assertEquals(BigDecimal.valueOf(4), wallet.rate("CHF", "USD"));
    }

    @Test
    void rateSameCurrency() {
        assertEquals(BigDecimal.ONE, Wallet.create().rate("EUR", "EUR"));
    }

    @Test
    void reduce() {
        Money dollar = Money.dollar(1);
        Wallet wallet = Wallet.create().addRate("USD", "CHF", BigDecimal.valueOf(2));
        Money franc = wallet.reduce(dollar, "CHF");
        assertEquals(Money.money(2,"CHF"),franc);
    }

}