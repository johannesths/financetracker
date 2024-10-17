package service;

import model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found!"));
    }

    public Transaction saveTransaction(Transaction transaction) {
        if (transaction == null)
            throw new IllegalArgumentException("Transaction cannot be null!");
        return transactionRepository.save(transaction);
    }

    public void deleteTransactionById(Long id) {
        transactionRepository.deleteById(id);
    }
}
