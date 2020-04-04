import Bank.*;
import org.junit.After;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

public class ForRun {
    private static final String FIRST_USRNAME = "John";
    private static final String SECOND_USRNAME = "Nancy";
    protected Exchange exchange = new Exchange();

    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    protected Users userOne = new Users(FIRST_USRNAME, 33);
    protected Users userTwo = new Users(SECOND_USRNAME, 22);
    protected Cash cashUah = new Cash(49000d, 2000.0D, 1000d, userOne.getName(), userOne);

    @Test
    public void startTransaction() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("BankConfig");
            entityManager = entityManagerFactory.createEntityManager();
            doTransaction(userOne);
            doTransaction(userTwo);
            doTransaction(cashUah);
            showAllUsers();
            transferMoney("UAH", "USD", 40000d, getUserByName(FIRST_USRNAME));
            showCash();
            System.out.println(getAllMoney(userOne));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void transferMoney(String from, String to, Double value, Users user) {
        switch (from) {
            case "UAH":
                if (to.equals("USD")) {
                    changeMoney(value * (-1), user, from);
                    changeMoney(exchange.exchangeUAHtoUSD(value), user, to);
                    break;
                } else if (to.equals("EUR")) {
                    changeMoney(value * (-1), user, from);
                    changeMoney(exchange.exchangeUAHtoEUR(value), user, to);
                    break;
                }
            case "USD":
                if (to.equals("UAH")) {
                    changeMoney(value * (-1), user, from);
                    changeMoney(exchange.exchangeUSDtoUAH(value), user, to);
                    break;
                } else if (to.equals("EUR"))
                    changeMoney(value * (-1), user, from);
                changeMoney(exchange.exchangeUSDtoEUR(value), user, to);
                break;
            case "EUR":
                if (to.equals("UAH")) {
                    changeMoney(value * (-1), user, from);
                    changeMoney(exchange.exchangeEURtoUAH(value), user, to);
                    break;
                } else if (to.equals("USD")) {
                    changeMoney(value * (-1), user, from);
                    changeMoney(exchange.exchangeEURtoUSD(value), user, to);
                    break;
                }

            default:
                System.out.println("No such 'Cash'");
                break;
        }
    }

    private void doTransaction(Object object) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(object);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    private void showAllUsers() {
        TypedQuery<Users> query = entityManager.createQuery("SELECT users FROM Users users", Users.class);
        List<Users> list = query.getResultList();
        for (Users o : list) {
            System.out.println(o);
        }
    }

    private void showCash() {
        TypedQuery<Cash> query = entityManager.createQuery("SELECT cash FROM Cash cash", Cash.class);
        List<Cash> list = query.getResultList();
        for (Cash o : list) {
            System.out.println(o);
        }
    }

    private Users getUserByName(String name) {
        Users user = null;
        TypedQuery<Users> query = entityManager.createQuery("SELECT users FROM Users users WHERE users.name = :name", Users.class);
        query.setParameter("name", name);
        return user = query.getSingleResult();
    }

    private void changeMoney(Double money, Users user, String value) {
        Cash cash;
        Double temp;
        TypedQuery<Cash> query = entityManager.createQuery("SELECT cash FROM Cash cash", Cash.class);
        switch (value) {
            case "UAH":
                cash = query.getSingleResult();
                temp = cash.getMoneyUah();
                cash.setMoneyUah(temp + (money));
                doTransaction(cash);
                break;
            case "USD":
                cash = query.getSingleResult();
                temp = cash.getMoneyUsd();
                cash.setMoneyUsd(temp + (money));
                doTransaction(cash);
                break;
            case "EUR":
                cash = query.getSingleResult();
                temp = cash.getMoneyEur();
                cash.setMoneyEur(temp + (money));
                doTransaction(cash);
                break;
            default: {
                System.out.println("Wrong cash!");
            }
        }

    }

    private Double getAllMoney(Users user) {
        Double allMoney = 0d;
        Cash cash = null;
        TypedQuery<Cash> query = entityManager.createQuery("SELECT cash FROM Cash cash WHERE name=:name",Cash.class);
        query.setParameter("name", user.getName());
        cash = query.getSingleResult();
        allMoney = exchange.exchangeEURtoUAH(cash.getMoneyEur());
        allMoney = allMoney + exchange.exchangeUSDtoUAH(cash.getMoneyUsd());
        allMoney = allMoney + cash.getMoneyUah();
        return allMoney;
    }

    @After
    public void finish() {
        if (entityManager != null) entityManager.close();
        if (entityManagerFactory != null) entityManagerFactory.close();
    }
}
