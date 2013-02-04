package com.acme.serviceavailability;

public interface AvailabilityChecker {
	String isPostCodeInServicableArea(String postCode) throws TechnicalFailureException;
}
