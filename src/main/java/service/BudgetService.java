package service;

import model.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BudgetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    public Budget addBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public Budget updateBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public Budget getBudgetById(Long id) {
        return budgetRepository.findById(id).orElseThrow(() -> new RuntimeException("Budget not found!"));
    }

    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }
}
