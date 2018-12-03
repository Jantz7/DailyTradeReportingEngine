package com.antoniouj.dailyreportingengine.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Currency;

/**
 * An Instruction to BUY or SELL sent by a client
 */
public class Instruction {

    // A financial entity whose sales are to be bought or sold
    private String entity;

    // The transactionType of the Instruction which can be "BUY" or "SELL"
    private TransactionType transaction;

    // The Foreign exchange rate with respect to USD that was agreed
    private BigDecimal agreedFx;

    // The Currency of the transaction
    private Currency currency;

    // Date of which the Instruction was sent by the client
    private LocalDate instructionDate;

    // Date of which the client wishes the Instruction to be settled
    private LocalDate settlementDate;

    // Number of shares to be bought or sold
    private int units;

    // Price of a single share
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
