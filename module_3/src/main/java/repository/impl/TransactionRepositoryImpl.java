package repository.impl;

import entity.Account;
import entity.Transaction;
import org.hibernate.Session;
import repository.TransactionRepository;

public class TransactionRepositoryImpl implements TransactionRepository {
    private final Session session;

    public TransactionRepositoryImpl(Session session) {
        this.session = session;
    }

    @Override
    public void save(Transaction transaction) {
        org.hibernate.Transaction t = session.getTransaction();
        t.begin();
        try {
            session.persist(t);
            Account account = session.find(Account.class, transaction.getAccount().getId());
            account.setBalance(account.getBalance() + transaction.getValue());
            session.merge(account);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            throw new RuntimeException(e);
        }

    }
}
