package Bank;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    @Column(nullable = false)
    private  String name;
    @Column(nullable = false)
    private Integer age;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "cash_id")
    private Cash cash;

    public Users() {
    }

    public Users(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
