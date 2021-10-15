package controller;

import entity.*;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.JPATransactionService;
import util.Util;

import java.io.BufferedReader;
import java.util.List;
import java.util.stream.Collectors;

public class JPAController {
    private static final Logger loggerInfo = LoggerFactory.getLogger("info");
    private static final Logger loggerError = LoggerFactory.getLogger("error");

    private final Session session;
    private final String email;
    private final JPATransactionService jpaTransactionService;

    public JPAController(Session session, String userEmail) {
        this.session = session;
        email = userEmail;
        jpaTransactionService = new JPATransactionService(session);
    }

    public void run(BufferedReader bufferedReader) {
        loggerInfo.info("Creating new transactions and writing to db");
        try {
            User currentUser = jpaTransactionService.findUserByEmail(email);
            List<Account> accounts = jpaTransactionService.findAccountsOfUser(currentUser.getId());
            accounts.forEach(a -> System.out.format("%s:id -> %s:name%n", a.getId(), a.getAccountName()));

            System.out.println("Pleas choose account");
            long accountId = Util.chooseAccount(bufferedReader, accounts.stream().map(Account::getId).collect(Collectors.toList()));
            Account account = session.find(Account.class, accountId);

            Transaction transaction = new Transaction();
            transaction.setAccount(account);

            System.out.println("Pleas enter transaction value (positive or negative number)");
            long value = Long.parseLong(bufferedReader.readLine());

            List<ExpenseCategory> expenseCategories = jpaTransactionService.getExpenseCategories();
            List<IncomeCategory> incomeCategories = jpaTransactionService.getIncomeCategories();

            System.out.printf("Pleas choose category by id");
            long categoryId;
            if (value > 0) {
                incomeCategories.forEach(i -> System.out.printf("%s:id -> %s:name%n", i.getId(), i.getName()));
            } else if (value < 0) {
                expenseCategories.forEach(i -> System.out.printf("%s:id -> %s:name%n", i.getId(), i.getName()));
            }
            categoryId = Long.parseLong(bufferedReader.readLine());

            jpaTransactionService.addTransaction(account, transaction, value, categoryId);
        } catch (Exception e) {
            loggerError.error("Transaction failed", e);
            throw new RuntimeException(e);
        }
    }
}

