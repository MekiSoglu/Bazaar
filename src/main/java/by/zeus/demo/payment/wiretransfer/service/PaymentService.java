package by.zeus.demo.payment.wiretransfer.service;

import by.zeus.demo.base.service.BaseService;
import by.zeus.demo.payment.wiretransfer.domain.FeeType;
import by.zeus.demo.payment.wiretransfer.domain.Payment;
import by.zeus.demo.payment.wiretransfer.repository.PaymentRepository;
import by.zeus.demo.payment.wiretransfer.web.dto.PaymentDto;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentService extends BaseService<Payment> {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        super(paymentRepository);
        this.paymentRepository = paymentRepository;
    }

    public List<PaymentDto> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public PaymentDto getPaymentById(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.map(this::convertToDto).orElse(null);
    }

    public PaymentDto createPayment(PaymentDto paymentDto) {
        Payment payment = convertToEntity(paymentDto);
        Payment createdPayment = paymentRepository.save(payment);
        return convertToDto(createdPayment);
    }

    private PaymentDto convertToDto(Payment payment) {
        PaymentDto dto = new PaymentDto();
        dto.setSenderFirstName(payment.getSenderFirstName());
        dto.setSenderLastName(payment.getSenderLastName());
        dto.setSenderAddress(payment.getSenderAddress());
        dto.setSenderPhone(payment.getSenderPhone());
        dto.setReceiverFirstName(payment.getReceiverFirstName());
        dto.setReceiverLastName(payment.getReceiverLastName());
        dto.setReceiverAddress(payment.getReceiverAddress());
        dto.setReceiverAccountNumber(payment.getReceiverAccountNumber());
        dto.setReceiverBankName(payment.getReceiverBankName());
        dto.setReceiverBankCode(payment.getReceiverBankCode());
        dto.setReceiverSwiftCode(payment.getReceiverSwiftCode());
        dto.setTransferPurpose(payment.getTransferPurpose());
        dto.setFeeType(payment.getFeeType().name());
        dto.setAmount(payment.getAmount());
        dto.setPaymentDate(payment.getPaymentDate());
        dto.setCurrency(payment.getCurrency().getCurrencyCode());
        return dto;
    }

    private Payment convertToEntity(PaymentDto dto) {
        Payment payment = new Payment();
        payment.setSenderFirstName(dto.getSenderFirstName());
        payment.setSenderLastName(dto.getSenderLastName());
        payment.setSenderAddress(dto.getSenderAddress());
        payment.setSenderPhone(dto.getSenderPhone());
        payment.setReceiverFirstName(dto.getReceiverFirstName());
        payment.setReceiverLastName(dto.getReceiverLastName());
        payment.setReceiverAddress(dto.getReceiverAddress());
        payment.setReceiverAccountNumber(dto.getReceiverAccountNumber());
        payment.setReceiverBankName(dto.getReceiverBankName());
        payment.setReceiverBankCode(dto.getReceiverBankCode());
        payment.setReceiverSwiftCode(dto.getReceiverSwiftCode());
        payment.setTransferPurpose(dto.getTransferPurpose());
        payment.setFeeType(FeeType.valueOf(dto.getFeeType()));
        payment.setAmount(dto.getAmount());
        payment.setPaymentDate(dto.getPaymentDate());
        payment.setCurrency(Currency.getInstance(dto.getCurrency()));
        return payment;
    }
}
