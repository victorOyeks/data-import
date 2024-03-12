package com.oyeks.dataimport;

import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.util.CsvContext;

import java.math.BigDecimal;

public class ParseBigDecimalWithFormat implements CellProcessor {

    private String format;

    public ParseBigDecimalWithFormat(String format) {
        this.format = format;
    }

    @Override
    public Object execute(Object value, CsvContext context) {
        if (value == null) {
            return null;
        }

        // Remove non-numeric characters (except for the decimal point)
        String cleanedValue = value.toString().replaceAll("[^\\d.]", "");

        try {
            // Parse the cleaned value as a BigDecimal
            return new BigDecimal(cleanedValue);
        } catch (NumberFormatException e) {
            throw new SuperCsvCellProcessorException(
                    String.format("'%s' could not be parsed as a BigDecimal", value),
                    context, this);
        }
    }
}
