package com.antoniouj.dailyreportingengine.model;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Currency;

/**
 * An Instruction to BUY or SELL sent by a client
 */
public class Instruction {

    // A financial entity whose sales are to be bought or sold
    @NotNull(message = "Entity cannot be null")
    private String entity;

    // The transactionType of the Instruction which can be "BUY" or "SELL"
    @NotNull(message = "TransactionType cannot be null and must have a value of B or S")
    private TransactionType transaction;

    // The Foreign exchange rate with respect to USD that was agreed
    @NotNull(message = "AgreedFx cannot be null")
    private BigDecimal agreedFx;

    // The Currency of the transaction
    @NotNull(message = "Currency cannot be null and must be a valid currency")
    private Currency currency;

    // Date of which the Instruction was sent by the client
    private LocalDate instructionDate;

    // Date of which the client wishes the Instruction to be settled
    @NotNull(message = "Settlement Date cannot be null")
    private LocalDate settlementDate;

    // Number of shares to be bought or sold
    @NotNull(message = "Units cannot be null")
    private int units;

    // Price of a single share
    @NotNull(message = "Price per units cannot be null")
    private BigDecimal pricePerUnit;

    // Amount of trade which is calculated by units * pricePerUnit * agreedFx
    private BigDecimal amountOfTrade;

    public Instruction(String entity, TransactionType transaction, BigDecimal agreedFx, Currency currency,
                       LocalDate instructionDate, LocalDate settlementDate, int units, BigDecimal pricePerUnit) {

        this.entity = entity;
        this.transaction = transaction;
        this.agreedFx = agreedFx;
        this.currency = currency;
        this.instructionDate = instructionDate;
        this.settlementDate = settlementDate;
        this.units = units;
        this.pricePerUnit = pricePerUnit;
        this.amountOfTrade = calculateAmountOfTrade();
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public TransactionType getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionType transaction) {
        this.transaction = transaction;
    }

    public BigDecimal getAgreedFx() {
        return agreedFx;
    }

    public void setAgreedFx(BigDecimal agreedFx) {
        this.agreedFx = agreedFx;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDate getInstructionDate() {
        return instructionDate;
    }

    public void setInstructionDate(LocalDate instructionDate) {
        this.instructionDate = instructionDate;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(LocalDate settlementDate) {
        this.settlementDate = settlementDate;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public BigDecimal getAmountOfTrade() {
        return amountOfTrade;
    }

    private BigDecimal calculateAmountOfTrade() {
        return this.amountOfTrade = this.pricePerUnit.multiply(BigDecimal.valueOf(this.units)).multiply(this.agreedFx)
                .setScale(2, RoundingMode.CEILING);
    }
}
