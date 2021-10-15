package repository;

import entity.ExpenseCategory;
import entity.IncomeCategory;

import java.util.List;

public interface CategoryRepository {
    List<IncomeCategory> getIncomeCategories();

    List<ExpenseCategory> getExpenseCategories();

    IncomeCategory getIncomeCategory(Long id);

    ExpenseCategory getExpenseCategory(Long id);
}
