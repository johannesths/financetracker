package controller;

import model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        if (transaction == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(transactionService.saveTransaction(transaction));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        if (transaction == null || !(id.equals(transaction.getTransaction_id())))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(transactionService.saveTransaction(transaction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Transaction> deleteTransaction(@PathVariable Long id) {
        if (transactionService.getTransactionById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        transactionService.deleteTransactionById(id);
        return ResponseEntity.noContent().build();
    }
}
