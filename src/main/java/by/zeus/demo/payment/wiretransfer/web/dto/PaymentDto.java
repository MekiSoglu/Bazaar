package by.zeus.demo.payment.wiretransfer.web.dto;

import java.time.LocalDateTime;

public class PaymentDto {

    public String getReceiverBank;
    private String senderFirstName;
    private String senderLastName;
    private String senderAddress;
    private String senderPhone;

    private String receiverFirstName;
    private String receiverLastName;
    private String receiverAddress;
    private String receiverAccountNumber;
    private String receiverBankName;
    private String receiverBankCode;
    private String receiverSwiftCode;

    private String transferPurpose;
    private String feeType;
    private Double amount;
    private LocalDateTime paymentDate;
    private String currency;

    public String getSenderFirstName() { return senderFirstName; }
    public void setSenderFirstName(String senderFirstName) { this.senderFirstName = senderFirstName; }

    public String getSenderLastName() { return senderLastName; }
    public void setSenderLastName(String senderLastName) { this.senderLastName = senderLastName; }

    public String getSenderAddress() { return senderAddress; }
    public void setSenderAddress(String senderAddress) { this.senderAddress = senderAddress; }

    public String getSenderPhone() { return senderPhone; }
    public void setSenderPhone(String senderPhone) { this.senderPhone = senderPhone; }

    public String getReceiverFirstName() { return receiverFirstName; }
    public void setReceiverFirstName(String receiverFirstName) { this.receiverFirstName = receiverFirstName; }

    public String getReceiverLastName() { return receiverLastName; }
    public void setReceiverLastName(String receiverLastName) { this.receiverLastName = receiverLastName; }

    public String getReceiverAddress() { return receiverAddress; }
    public void setReceiverAddress(String receiverAddress) { this.receiverAddress = receiverAddress; }

    public String getReceiverAccountNumber() { return receiverAccountNumber; }
    public void setReceiverAccountNumber(String receiverAccountNumber) { this.receiverAccountNumber = receiverAccountNumber; }

    public String getReceiverBankName() { return receiverBankName; }
    public void setReceiverBankName(String receiverBankName) { this.receiverBankName = receiverBankName; }

    public String getReceiverBankCode() { return receiverBankCode; }
    public void setReceiverBankCode(String receiverBankCode) { this.receiverBankCode = receiverBankCode; }

    public String getReceiverSwiftCode() { return receiverSwiftCode; }
    public void setReceiverSwiftCode(String receiverSwiftCode) { this.receiverSwiftCode = receiverSwiftCode; }

    public String getTransferPurpose() { return transferPurpose; }
    public void setTransferPurpose(String transferPurpose) { this.transferPurpose = transferPurpose; }

    public String getFeeType() { return feeType; }
    public void setFeeType(String feeType) { this.feeType = feeType; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public LocalDateTime getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
}
