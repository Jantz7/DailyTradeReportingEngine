package com.antoniouj.dailyreportingengine.service.impl;

import com.antoniouj.dailyreportingengine.model.Instruction;
import com.antoniouj.dailyreportingengine.service.WorkingDayService;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import static java.util.Arrays.asList;

@Service
public class WorkingDayServiceImpl implements WorkingDayService {

    // Working week which starts Monday and ends Friday
    private static final List<DayOfWeek> defaultWorkingDays = asList(DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY);

    // Working week for AED and SAR currency which starts Sunday and ends Thursday
    private static final List<DayOfWeek> otherWorkingDays = asList(DayOfWeek.SUNDAY,
            DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY);

    @Override
    public List<Instruction> validateSettlementDate(List<Instruction> instructions) {

        instructions.forEach(instruction -> {

            LocalDate newSettlementDate;
            LocalDate settlementDate = instruction.getSettlementDate();

            // conditional to check which working week should be used for the instruction
            if (instruction.getCurrency().getCurrencyCode().equalsIgnoreCase("AED")
                    || instruction.getCurrency().getCurrencyCode().equalsIgnoreCase("SAR")) {

                newSettlementDate = validateOtherWorkingDays(settlementDate);

            } else {

                newSettlementDate = validateDefaultWorkingDays(settlementDate);
            }

            instruction.setSettlementDate(newSettlementDate);
        });

        return instructions;
    }

    /**
     * Validates the Day of the Week of the settlement Day based on the defaultWorkingDays
     *
     * @param settlementDay in which the instruction has to be settled
     * @return unchanged settlement day or new settlement day if original wasn't validate
     */
    private LocalDate validateDefaultWorkingDays(LocalDate settlementDay) {

        if (!defaultWorkingDays.contains(settlementDay.getDayOfWeek())) {

            return validateDefaultWorkingDays(settlementDay.plusDays(1));

        } else {

            return settlementDay;
        }
    }


    /**
     * Validates the Day of the Week of the settlement Day based on the otherWorkingDays
     *
     * @param settlementDay in which the instruction has to be settled
     * @return unchanged settlement day or new settlement day if original wasn't validate
     */
    private LocalDate validateOtherWorkingDays(LocalDate settlementDay) {

        if (!otherWorkingDays.contains(settlementDay.getDayOfWeek())) {

            return settlementDay.plusDays(1);

        } else {

            return settlementDay;
        }
    }
}
