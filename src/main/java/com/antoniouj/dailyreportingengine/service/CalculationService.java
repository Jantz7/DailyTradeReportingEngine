package com.antoniouj.dailyreportingengine.service;

import com.antoniouj.dailyreportingengine.model.Instruction;
import com.antoniouj.dailyreportingengine.model.Ranking;

import java.math.BigDecimal;
import java.util.List;

public interface CalculationService {

    /**
     * Calculates the Daily Income based on the unit, pricePerUnit and
     * agreedFx of the instructions sent by the client
     *
     * @param instructions sent by the client
     * @return Total daily income amount rounded to 2 decimal places
     */
    BigDecimal calculateDailyIncome(List<Instruction> instructions);

    /**
     * Calculates the Daily Outcome based on the unit, pricePerUnit and
     * agreedFx of the instructions sent by the client.
     *
     * @param instructions sent by the client
     * @return Total daily outcome amount rounded to 2 decimal places
     */
    BigDecimal calculateDailyOutcome(List<Instruction> instructions);

    /**
     * Calculates the Income Rankings of the instructions sent by the client based
     * on the AmountOfTrade
     *
     * @param instructions sent by the client
     * @return rankings of the instructions sent by the client
     */
    List<Ranking> calculateIncomeRanks(List<Instruction> instructions);

    /**
     * Calculates the Outcome Rankings of the instructions sent by the client based
     * on the AmountOfTrade
     *
     * @param instructions sent by the client
     * @return rankings of the instructions sent by the client
     */
    List<Ranking> calculateOutcomeRanks(List<Instruction> instructions);
}
