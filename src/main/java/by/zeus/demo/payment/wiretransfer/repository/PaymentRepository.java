package by.zeus.demo.payment.wiretransfer.repository;

import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.payment.wiretransfer.domain.Payment;

import java.time.LocalDateTime;
import java.util.List;

public interface PaymentRepository extends BaseRepository<Payment> {
    List<Payment> findByAmountGreaterThan(Double amount);
    List<Payment> findByPaymentDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
