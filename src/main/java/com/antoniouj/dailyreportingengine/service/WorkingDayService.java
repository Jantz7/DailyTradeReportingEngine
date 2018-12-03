package com.antoniouj.dailyreportingengine.service;

import com.antoniouj.dailyreportingengine.model.Instruction;

import java.util.List;

public interface WorkingDayService {

    /**
     * Validate the Settlement Date of an Instruction based on
     * the Currency and the Working Day
     *
     * @param instructions sent from the client
     * @return instructions with validated Settlement Date
     */
    List<Instruction> validateSettlementDate(List<Instruction> instructions);
}
