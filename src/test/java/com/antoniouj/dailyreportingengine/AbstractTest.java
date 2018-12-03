package com.antoniouj.dailyreportingengine;

import com.antoniouj.dailyreportingengine.model.Instruction;
import com.antoniouj.dailyreportingengine.model.TransactionType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public abstract class AbstractTest {

    protected static final String FOO_ENTITY = "foo";
    protected static final TransactionType FOO_TRANSACTION_TYPE = TransactionType.BUY;
    protected static final BigDecimal FOO_AGREED_FX = new BigDecimal(0.50);
    protected static final Currency FOO_CURRENCY = Currency.getInstance("SGD");
    protected static final LocalDate FOO_INSTRUCTION_DATE = LocalDate.of(2016, 1, 1);
    protected static final LocalDate FOO_SETTLEMENT_DATE = LocalDate.of(2016, 1, 2);
    protected static final int FOO_UNITS = 200;
    protected static final BigDecimal FOO_PRICE_PER_UNITS = new BigDecimal(100.25).setScale(2,
            RoundingMode.HALF_EVEN);
    protected static final BigDecimal FOO_TRADE_AMOUNT = new BigDecimal(10025.00).setScale(2,
            RoundingMode.HALF_EVEN);

    protected static final String BAR_ENTITY = "bar";
    private static final TransactionType BAR_TRANSACTION_TYPE = TransactionType.SELL;
    private static final BigDecimal BAR_AGREED_FX = new BigDecimal(0.22);
    private static final Currency BAR_CURRENCY = Currency.getInstance("AED");
    private static final LocalDate BAR_INSTRUCTION_DATE = LocalDate.of(2016, 1, 5);
    private static final LocalDate BAR_SETTLEMENT_DATE = LocalDate.of(2016, 1, 7);
    private static final int BAR_UNITS = 450;
    private static final BigDecimal BAR_PRICE_PER_UNITS = new BigDecimal(150.25).setScale(2,
            RoundingMode.HALF_EVEN);
    protected static final BigDecimal BAR_TRADE_AMOUNT = new BigDecimal(14874.76).setScale(2,
            RoundingMode.HALF_EVEN);


    protected List<Instruction> createInstructions() {

        List<Instruction> instructions = new ArrayList<>();

        Instruction fooInstruction = new Instruction(FOO_ENTITY, FOO_TRANSACTION_TYPE, FOO_AGREED_FX, FOO_CURRENCY,
                FOO_INSTRUCTION_DATE, FOO_SETTLEMENT_DATE, FOO_UNITS, FOO_PRICE_PER_UNITS);

        Instruction barInstruction = new Instruction(BAR_ENTITY, BAR_TRANSACTION_TYPE, BAR_AGREED_FX, BAR_CURRENCY,
                BAR_INSTRUCTION_DATE, BAR_SETTLEMENT_DATE, BAR_UNITS, BAR_PRICE_PER_UNITS);

        instructions.add(fooInstruction);
        instructions.add(barInstruction);

        return instructions;
    }
}
