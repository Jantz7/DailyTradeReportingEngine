package com.antoniouj.dailyreportingengine.service.impl;

import com.antoniouj.dailyreportingengine.model.Instruction;
import com.antoniouj.dailyreportingengine.model.Ranking;
import com.antoniouj.dailyreportingengine.service.CalculationService;
import com.antoniouj.dailyreportingengine.service.ReportingService;
import com.antoniouj.dailyreportingengine.service.WorkingDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ReportingServiceImpl implements ReportingService {

    @Autowired
    private CalculationService calculationService;

    @Autowired
    private WorkingDayService workingDayService;

    @Override
    public String generateReport(List<Instruction> instructions) {

        StringBuilder stringBuilder = new StringBuilder();

        List<Instruction> validatedInstructions = workingDayService.validateSettlementDate(instructions);

        generateDailyIncomeReport(stringBuilder, validatedInstructions);

        generateDailyOutcomeReport(stringBuilder, validatedInstructions);

        generateDailyIncomeRankings(stringBuilder, validatedInstructions);

        generateOutcomeRankings(stringBuilder, validatedInstructions);

        return stringBuilder.toString();
    }

    /**
     * Generates Daily Income Report based on the value calculated from the calculationService
     *
     * @param stringBuilder         in which to append the value from the calculatedService
     * @param validatedInstructions are instructions sent by the client which have been
     *                              validated using the workingDayService
     */
    private void generateDailyIncomeReport(StringBuilder stringBuilder, List<Instruction> validatedInstructions) {

        BigDecimal dailyIncome = calculationService.calculateDailyIncome(validatedInstructions);

        stringBuilder
                .append("**********DAILY INCOME**********\n")
                .append("--------------------------------\n")
                .append("TRADE AMOUNT: ").append(dailyIncome)
                .append("\n");
    }

    /**
     * Generates Daily Outcome Report based on the value calculated from the calculationService
     *
     * @param stringBuilder         in which to append the value from the calculatedService
     * @param validatedInstructions are instructions sent by the client which have been
     *                              validated using the workingDayService
     */
    private void generateDailyOutcomeReport(StringBuilder stringBuilder, List<Instruction> validatedInstructions) {

        BigDecimal dailyOutcome = calculationService.calculateDailyOutcome(validatedInstructions);

        stringBuilder
                .append("**********DAILY OUTCOME**********\n")
                .append("--------------------------------\n")
                .append("TRADE AMOUNT: ").append(dailyOutcome)
                .append("\n");
    }

    /**
     * Generates Daily Income Rankings based on the value calculated from the calculationService
     *
     * @param stringBuilder         in which to append the value from the calculatedService
     * @param validatedInstructions are instructions sent by the client which have been
     *                              validated using the workingDayService
     */
    private void generateDailyIncomeRankings(StringBuilder stringBuilder, List<Instruction> validatedInstructions) {

        List<Ranking> incomeRankings = calculationService.calculateIncomeRanks(validatedInstructions);

        stringBuilder
                .append("**********INCOME RANKINGS**********\n");

        incomeRankings.forEach(ranking ->
                stringBuilder
                        .append("--------------------------------\n")
                        .append("ENTITY: ").append(ranking.getEntity())
                        .append("\n")
                        .append("RANK: ").append(ranking.getRank())
                        .append("\n"));
    }

    /**
     * Generates Daily Outcome Rankings based on the value calculated from the calculationService
     *
     * @param stringBuilder         in which to append the value from the calculatedService
     * @param validatedInstructions are instructions sent by the client which have been
     *                              validated using the workingDayService
     */
    private void generateOutcomeRankings(StringBuilder stringBuilder, List<Instruction> validatedInstructions) {

        List<Ranking> outcomeRankings = calculationService.calculateOutcomeRanks(validatedInstructions);

        stringBuilder
                .append("**********OUTCOME RANKINGS**********\n");

        outcomeRankings.forEach(ranking ->
                stringBuilder
                        .append("--------------------------------\n")
                        .append("ENTITY: ").append(ranking.getEntity())
                        .append("\n")
                        .append("RANK: ").append(ranking.getRank())
                        .append("\n"));
    }
}
