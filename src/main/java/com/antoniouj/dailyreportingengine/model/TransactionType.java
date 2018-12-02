package com.antoniouj.dailyreportingengine.model;

/**
 * The transactionType of the Instruction which can be "B" or "S"
 */
public enum TransactionType {
    BUY("B"),
    SELL("S");

    private String transactionType;

    TransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String transactionType() {
        return transactionType;
    }

}
