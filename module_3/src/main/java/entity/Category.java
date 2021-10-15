package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "category_type", discriminatorType = DiscriminatorType.STRING)
public class Category extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Transaction> transactions = new HashSet<>();

    public Category() {

    }

    public void addTransactionToCategory(Transaction transaction) {
        transactions.add(transaction);
        transaction.setCategory(this);
    }


}
