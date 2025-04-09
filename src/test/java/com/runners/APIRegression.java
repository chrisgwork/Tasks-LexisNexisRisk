package com.runners;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class APIRegression {

    @Test
    void testParallel() {
        Results results = Runner.path("classpath:features")
                .tags("@API")
                .parallel(10);

        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }
}