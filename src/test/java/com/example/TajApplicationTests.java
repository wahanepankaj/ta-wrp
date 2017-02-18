package com.example;

import eu.verdelhan.ta4j.TimeSeries;
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
        Assert.assertTrue(timeSeries.getEnd() - timeSeries.getBegin() > 200);

    }
}
