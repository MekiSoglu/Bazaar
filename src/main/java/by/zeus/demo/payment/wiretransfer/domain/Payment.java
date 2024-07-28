package by.zeus.demo.payment.wiretransfer.domain;

import by.zeus.demo.base.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Currency;

@Entity
@Table(name = "payments")
public class Payment extends BaseEntity {

         // Gönderen bilgileri
    @Column(name = "sender_first_name")
    private String senderFirstName;

    @Column(name = "sender_last_name")
    private String senderLastName;

    @Column(name = "sender_address")
    private String senderAddress;

    @Column(name = "sender_phone")
    private String senderPhone;

         // Alıcı bilgileri
    @Column(name = "receiver_first_name")
    private String receiverFirstName;

    @Column(name = "receiver_last_name")
    private String receiverLastName;

    @Column(name = "receiver_address")
    private String receiverAddress;

    @Column(name = "receiver_account_number")
    private String receiverAccountNumber; //

    @Column(name = "receiver_bank_name")
    private String receiverBankName;

    @Column(name = "receiver_bank_code")
    private String receiverBankCode; //

    @Column(name = "receiver_swift_code")
    private String receiverSwiftCode;

         // Transfer detayları
    @Column(name = "transfer_purpose")
    private String transferPurpose;

    @Enumerated(EnumType.STRING)
    @Column(name = "fee_type")
    private FeeType feeType;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @JoinColumn(name = "currency_id")
    private Currency currency;



    public String getSenderFirstName() {
        return senderFirstName;
    }

    public void setSenderFirstName(String senderFirstName) {
        this.senderFirstName = senderFirstName;
    }

    public String getSenderLastName() {
        return senderLastName;
    }

    public void setSenderLastName(String senderLastName) {
        this.senderLastName = senderLastName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getReceiverFirstName() {
        return receiverFirstName;
    }

    public void setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
    }

    public String getReceiverLastName() {
        return receiverLastName;
    }

    public void setReceiverLastName(String receiverLastName) {
        this.receiverLastName = receiverLastName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public String getReceiverBankName() {
        return receiverBankName;
    }

    public void setReceiverBankName(String receiverBankName) {
        this.receiverBankName = receiverBankName;
    }

    public String getReceiverBankCode() {
        return receiverBankCode;
    }

    public void setReceiverBankCode(String receiverBankCode) {
        this.receiverBankCode = receiverBankCode;
    }

    public String getReceiverSwiftCode() {
        return receiverSwiftCode;
    }

    public void setReceiverSwiftCode(String receiverSwiftCode) {
        this.receiverSwiftCode = receiverSwiftCode;
    }

    public String getTransferPurpose() {
        return transferPurpose;
    }

    public void setTransferPurpose(String transferPurpose) {
        this.transferPurpose = transferPurpose;
    }

    public FeeType getFeeType() {
        return feeType;
    }

    public void setFeeType(FeeType feeType) {
        this.feeType = feeType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
