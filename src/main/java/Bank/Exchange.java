package Bank;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Exchange {

    private static final double USD_to_EUR = 1.1;
    private static final double USD = 28;
    private static final double EUR_to_USD = 0.9;
    private static final double EUR = 30;

    public Exchange() {
    }

    public Double exchangeUAHtoEUR(Double money) {
        Double eur;
        return eur = money / EUR;

    }

    public Double exchangeUAHtoUSD(Double money) {
        Double usd;
        return usd = money / USD;

    }

    public Double exchangeUSDtoUAH(Double money) {
        Double uah;
        return uah = money * USD;
    }

    public Double exchangeUSDtoEUR(Double money) {
        Double usd;
        return usd = money * USD_to_EUR;
    }

    public Double exchangeEURtoUSD(Double money) {
        Double eur;
        return eur = money * EUR_to_USD;
    }

    public Double exchangeEURtoUAH(Double money) {
        Double eur;
        return eur = money * EUR;
    }
}
