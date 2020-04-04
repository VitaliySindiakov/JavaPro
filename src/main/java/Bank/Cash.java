package Bank;

import javax.persistence.*;

@Entity
@Table(name = "cash")
public class Cash {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long cshId;

    @Column
    private Double moneyUah;
    @Column
    private Double moneyUsd;
    @Column
    private Double moneyEur;

    @Column(nullable = false)
    private  String name;

    @OneToOne(mappedBy = "cash")
    private Users user;

    public Cash() {
    }

    public Cash(Double moneyUah, Double moneyUsd, Double moneyEur, String name, Users user) {
        this.moneyUah = moneyUah;
        this.moneyUsd = moneyUsd;
        this.moneyEur = moneyEur;
        this.name = name;
        this.user = user;
    }

    public Double getMoneyUah() {
        return moneyUah;
    }

    public void setMoneyUah(Double moneyUah) {
        this.moneyUah = moneyUah;
    }

    public Double getMoneyUsd() {
        return moneyUsd;
    }

    public void setMoneyUsd(Double moneyUsd) {
        this.moneyUsd = moneyUsd;
    }

    public Double getMoneyEur() {
        return moneyEur;
    }

    public void setMoneyEur(Double moneyEur) {
        this.moneyEur = moneyEur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Cash{" +
                "cshId=" + cshId +
                ", moneyUah=" + moneyUah +
                ", moneyUsd=" + moneyUsd +
                ", moneyEur=" + moneyEur +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}