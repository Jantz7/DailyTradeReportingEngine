package com.antoniouj.dailyreportingengine.service.impl;

import com.antoniouj.dailyreportingengine.AbstractTest;
import com.antoniouj.dailyreportingengine.model.Instruction;
import com.antoniouj.dailyreportingengine.model.Ranking;
import com.antoniouj.dailyreportingengine.service.CalculationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CalculationServiceImplTest extends AbstractTest {

    private List<Instruction> instructions = new ArrayList<>();

    @Autowired
    private CalculationService calculationService;

    @Before
    public void setup() {

        instructions = createInstructions();
    }

    @Test
    public void testCalculateDailyIncome() {

        BigDecimal dailyIncome = calculationService.calculateDailyIncome(instructions);

        assertEquals(BAR_TRADE_AMOUNT, dailyIncome);

    }

    @Test
    public void testCalculateDailyOutcome() {

        BigDecimal dailyOutcome = calculationService.calculateDailyOutcome(instructions);

        assertEquals(FOO_TRADE_AMOUNT, dailyOutcome);
    }

    @Test
    public void testCalculateIncomeRanks() {

        List<Ranking> rankings = calculationService.calculateIncomeRanks(instructions);

        assertEquals(1, rankings.size());
        assertEquals(BAR_ENTITY, rankings.get(0).getEntity());
        assertEquals(1, rankings.get(0).getRank());
    }

    @Test
    public void testCalculateOutcomeRanks() {

        List<Ranking> rankings = calculationService.calculateOutcomeRanks(instructions);

        assertEquals(1, rankings.size());
        assertEquals(FOO_ENTITY, rankings.get(0).getEntity());
        assertEquals(1, rankings.get(0).getRank());
    }
}
