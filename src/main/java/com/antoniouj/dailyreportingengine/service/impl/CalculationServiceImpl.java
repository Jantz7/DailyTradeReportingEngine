package com.antoniouj.dailyreportingengine.service.impl;

import com.antoniouj.dailyreportingengine.model.Instruction;
import com.antoniouj.dailyreportingengine.model.Ranking;
import com.antoniouj.dailyreportingengine.model.TransactionType;
import com.antoniouj.dailyreportingengine.service.CalculationService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class CalculationServiceImpl implements CalculationService {

    @Override
    public BigDecimal calculateDailyIncome(List<Instruction> instructions) {

        return instructions.stream()
                .filter(instruction -> instruction.getTransaction().equals(TransactionType.SELL))
                .map(Instruction::getAmountOfTrade)
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.CEILING);
    }

    @Override
    public BigDecimal calculateDailyOutcome(List<Instruction> instructions) {

        return instructions.stream()
                .filter(instruction -> instruction.getTransaction().equals(TransactionType.BUY))
                .map(Instruction::getAmountOfTrade)
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.CEILING);
    }

    @Override
    public List<Ranking> calculateIncomeRanks(List<Instruction> instructions) {

        AtomicInteger rank = new AtomicInteger(0);

        return instructions.stream()
                .filter(instruction -> instruction.getTransaction().equals(TransactionType.SELL))
                .sorted(Comparator.comparing(Instruction::getAmountOfTrade))
                .map(instruction -> new Ranking(rank.incrementAndGet(), instruction.getEntity()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ranking> calculateOutcomeRanks(List<Instruction> instructions) {

        AtomicInteger rank = new AtomicInteger(0);

        return instructions.stream()
                .filter(instruction -> instruction.getTransaction().equals(TransactionType.BUY))
                .sorted(Comparator.comparing(Instruction::getAmountOfTrade))
                .map(instruction -> new Ranking(rank.incrementAndGet(), instruction.getEntity()))
                .collect(Collectors.toList());
    }
}
