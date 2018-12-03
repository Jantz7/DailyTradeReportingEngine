package com.antoniouj.dailyreportingengine.service.impl;

import com.antoniouj.dailyreportingengine.AbstractTest;
import com.antoniouj.dailyreportingengine.model.Instruction;
import com.antoniouj.dailyreportingengine.service.WorkingDayService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WorkingDayServiceImplTest extends AbstractTest {

    private List<Instruction> instructions = new ArrayList<>();

    @Autowired
    private WorkingDayService workingDayService;

    @Before
    public void setup() {

        instructions = createInstructions();
    }

    @Test
    public void testValidateSettlementDate() {

        List<Instruction> validatedInstructions = workingDayService.validateSettlementDate(instructions);

        Instruction fooInstruction = validatedInstructions.get(0);

        Instruction barInstruction = validatedInstructions.get(1);

        assertEquals(LocalDate.of(2016, 1, 4), fooInstruction.getSettlementDate());
        assertEquals(LocalDate.of(2016, 1, 7), barInstruction.getSettlementDate());
    }
}
