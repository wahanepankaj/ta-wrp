package com.example;

import eu.verdelhan.ta4j.Decimal;
import eu.verdelhan.ta4j.TimeSeries;
import eu.verdelhan.ta4j.indicators.trackers.RSIIndicator;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Calendar;

public class TajApplicationTests {

    @Test
    public void test_get_tokens() {
        final String[] tokens = TajApplication.getTokens();
        Assert.assertTrue(tokens.length > 0);
    }

    @Test
    public void test_getTimeSeries() throws IOException {
        final TimeSeries timeSeries = TajApplication.getTimeSeries("INFY.NS", Calendar.getInstance());
        Assert.assertTrue(timeSeries.getFirstTick().getBeginTime().isBefore(timeSeries.getLastTick().getEndTime()));
        Assert.assertTrue(timeSeries.getEnd() - timeSeries.getBegin() > 25);

    }

    @Test
    public void test_getRSIIndicator() throws IOException {
        final TimeSeries timeSeries = TajApplication.getTimeSeries("INFY.NS", Calendar.getInstance());
        final RSIIndicator rsiIndicator = TajApplication.getRsiIndicator(timeSeries, 14);
        Assert.assertTrue(rsiIndicator.getValue(timeSeries.getEnd()).isGreaterThan(Decimal.ZERO));
    }
}
