package com.microsoft.applicationinsights.internal.channel.common;

import org.junit.Test;

import static org.junit.Assert.*;

public final class StaticBackOffTimesContainerTest {
    @Test
    public void testBackOffs() {
        long[] backOffs = new StaticBackOffTimesPolicy().getBackOffTimeoutsInMillis();
        assertNotNull(backOffs);
        assertEquals(backOffs.length, StaticBackOffTimesPolicy.NUMBER_OF_BACK_OFFS);
        int couples = StaticBackOffTimesPolicy.NUMBER_OF_BACK_OFFS;
        long oddValue = -1;
        for (int i = 0; i < couples; ++i) {
            if (i % 2 == 0) {
                assertEquals(backOffs[i], BackOffTimesPolicy.MIN_TIME_TO_BACK_OFF_IN_MILLS);
            } else {
                if (i == 1) {
                    oddValue = backOffs[i];
                    assertTrue(oddValue > 0);
                }

                assertEquals(oddValue, backOffs[i]);
            }
        }
    }
}