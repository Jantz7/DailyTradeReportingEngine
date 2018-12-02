package com.antoniouj.dailyreportingengine;

import com.antoniouj.dailyreportingengine.model.Instruction;
import com.antoniouj.dailyreportingengine.model.TransactionType;
import com.antoniouj.dailyreportingengine.service.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.List;

import static java.util.Arrays.asList;

@SpringBootApplication
public class DailyReportingEngineApplication implements CommandLineRunner {

    @Autowired
    private ReportingService reportingService;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DailyReportingEngineApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) {

        // Creating foo Instruction to be used in generating report
        Instruction fooInstruction = new Instruction("foo", TransactionType.BUY, new BigDecimal(0.50),
                Currency.getInstance("SGD"), LocalDate.of(2016, 1, 1),
                LocalDate.of(2016, 1, 2), 200, new BigDecimal(100.25));

        // Creating bar Instruction to be used in generating report
        Instruction barInstruction = new Instruction("bar", TransactionType.SELL, new BigDecimal(0.22),
                Currency.getInstance("AED"), LocalDate.of(2016, 1, 5),
                LocalDate.of(2016, 1, 7), 450, new BigDecimal(150.5));

        List<Instruction> instructions = asList(fooInstruction, barInstruction);

        // Outputting report to the console
        System.out.println(reportingService.generateReport(instructions));
    }
}
