package service;

import entity.*;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.CategoryRepository;
import repository.UserRepository;
import repository.impl.CategoryRepositoryImpl;
import repository.impl.UserRepositoryImpl;

import java.util.List;

public class JPATransactionService {
    private static final Logger loggerInfo = LoggerFactory.getLogger("info");


    private final Session session;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public JPATransactionService(Session session) {
        this.session = session;
        this.userRepository = new UserRepositoryImpl(session);
        this.categoryRepository = new CategoryRepositoryImpl(session);
    }

    public void addTransaction(Account account, Transaction transaction, Long value, Long categoryID) {
        loggerInfo.info("Adding new transaction to db");
        Category category = session.find(Category.class, categoryID);
        transaction.setValue(value);
        transaction.setCategory(category);
        account.setBalance(account.getBalance() + transaction.getValue());
        session.update(account);
        session.flush();
        session.save(transaction);
    }

    public List<IncomeCategory> getIncomeCategories() {
        loggerInfo.info("Getting all Income category");
        return categoryRepository.getIncomeCategories();
    }

    public List<ExpenseCategory> getExpenseCategories() {
        loggerInfo.info("Getting all Expense category");
        return categoryRepository.getExpenseCategories();
    }

    public User findUserByEmail(String email) {
        loggerInfo.info("Finding user by email");
        return userRepository.getUserByEmail(email);
    }

    public List<Account> findAccountsOfUser(Long id) {
        loggerInfo.info("Finding all user accounts");
        return userRepository.getAccountsByUser(id);
    }

}
