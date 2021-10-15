package repository;

import entity.Account;
import entity.User;

import java.util.List;

public interface UserRepository {
    User getUserByEmail(String email);
    List<Account> getAccountsByUser(Long id);
}
