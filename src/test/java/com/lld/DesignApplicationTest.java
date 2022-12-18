package com.lld;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class DesignApplicationTest
    extends TestCase
{
    private static final String[] applications = new String[]{
            "registercallback.RegisterCallbackApplication",
            "parkinglot.ParkingLotApplication"
    };

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DesignApplicationTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DesignApplicationTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        for (String app: applications) {
            DesignApplication.main(new String[]{app});
        }
    }
}
