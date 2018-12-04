package com.antoniouj.dailyreportingengine.model;

import com.antoniouj.dailyreportingengine.AbstractTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InstructionTest extends AbstractTest {

    @Test
    public void testCalculateAmountOfTrade() {

        Instruction instruction = new Instruction(FOO_ENTITY, FOO_TRANSACTION_TYPE, FOO_AGREED_FX, FOO_CURRENCY,
                FOO_INSTRUCTION_DATE, FOO_SETTLEMENT_DATE, FOO_UNITS, FOO_PRICE_PER_UNITS);

        assertEquals(FOO_ENTITY, instruction.getEntity());
        assertEquals(FOO_TRANSACTION_TYPE, instruction.getTransaction());
        assertEquals(FOO_AGREED_FX, instruction.getAgreedFx());
        assertEquals(FOO_CURRENCY, instruction.getCurrency());
        assertEquals(FOO_INSTRUCTION_DATE, instruction.getInstructionDate());
        assertEquals(FOO_SETTLEMENT_DATE, instruction.getSettlementDate());
        assertEquals(FOO_UNITS, instruction.getUnits());
        assertEquals(FOO_PRICE_PER_UNITS, instruction.getPricePerUnit());
        assertEquals(FOO_TRADE_AMOUNT, instruction.getAmountOfTrade());
    }
}
