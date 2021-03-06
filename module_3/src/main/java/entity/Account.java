package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class Account  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "account_name", nullable = false)
    private String accountName;

    @Column(name = "balance", nullable = false)
    private Long balance;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transaction> transactions = new HashSet<>();

    public Account() {

    }

    @PrePersist
    public void onCreate() {
        if (balance == null) {
            balance = 0L;
        }
    }

    public void addTransactionToAccount(Transaction transaction) {
        transactions.add(transaction);
        transaction.setAccount(this);
    }


}
