package com.acme.serviceavailability;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class MyAvailibilityCheckerTest {
    
    private static AvailabilityChecker availabilityChecker;
    
    @BeforeClass
    public static void defineChecker(){
        availabilityChecker = new MyAvailabilityChecker();
    }

    @Test
    public void isPostCodeInServicableAreaTest() throws TechnicalFailureException {
        String postCode = "1";
        String expected = ServiceCode.SERVICE_AVAILABLE.name();
        String actual = availabilityChecker.isPostCodeInServicableArea(postCode);
        Assert.assertEquals(expected, actual);
        
        postCode = "2";
        expected = ServiceCode.SERVICE_UNAVAILABLE.name();
        actual = availabilityChecker.isPostCodeInServicableArea(postCode);
        Assert.assertEquals(expected, actual);
        
        postCode = "3";
        expected = ServiceCode.SERVICE_PLANNED.name();
        actual = availabilityChecker.isPostCodeInServicableArea(postCode);
        Assert.assertEquals(expected, actual);
        
        postCode = "4";
        expected = ServiceCode.POSTCODE_INVALID.name();
        actual = availabilityChecker.isPostCodeInServicableArea(postCode);
        Assert.assertEquals(expected, actual);
    }
    
    @Test(expected=TechnicalFailureException.class)
    public void isPostCodeInServicableAreaExceptionTest() throws TechnicalFailureException {
        String postCode = "5";
        String expected = ServiceCode.SERVICE_AVAILABLE.name();
        String actual = availabilityChecker.isPostCodeInServicableArea(postCode);
        Assert.assertEquals(expected, actual);
    }
    
}
