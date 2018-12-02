package com.antoniouj.dailyreportingengine.service;

import com.antoniouj.dailyreportingengine.model.Instruction;

import java.util.List;

public interface ReportingService {

    /**
     * Generates report containing Daily Income, Daily Outcome,
     * Income Rankings and Outcome Rankings
     *
     * @param instructions sent from the client
     * @return String containing report to output into console
     */
    String generateReport(List<Instruction> instructions);
}
