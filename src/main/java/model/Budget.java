package model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long budget_id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Budget() {

    }

    public Budget(BigDecimal amount, LocalDate startDate, LocalDate endDate, User user, Category category) {
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.category = category;
    }
}
