package repository;

import entity.Transaction;

public interface TransactionRepository {
    void save(Transaction transaction);
}
