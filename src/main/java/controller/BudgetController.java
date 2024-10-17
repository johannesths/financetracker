package controller;

import model.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.BudgetRepository;
import service.BudgetService;

import java.util.List;

@RestController
@RequestMapping("budgets/")
public class BudgetController {

    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping
    public ResponseEntity<List<Budget>> getAllBudgets() {
        List<Budget> budgets = budgetService.getAllBudgets();
        return ResponseEntity.ok(budgets);
    }

    @PostMapping
    public ResponseEntity<Budget> createBudget(@RequestBody Budget budget) {
        Budget budgetCreated = budgetService.addBudget(budget);
        if (budgetCreated == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(budgetCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Budget> updateBudget(@PathVariable Long id, @RequestBody Budget budget) {
        Budget updatedTransaction = budgetService.updateBudget(budget);
        if (updatedTransaction == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(updatedTransaction);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Budget> deleteBudget(@PathVariable Long id) {
        if (budgetService.getBudgetById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        budgetService.deleteBudget(id);
        return ResponseEntity.noContent().build();
    }
}
