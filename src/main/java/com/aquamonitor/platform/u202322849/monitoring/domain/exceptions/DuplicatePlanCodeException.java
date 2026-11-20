package com.aquamonitor.platform.u202322849.monitoring.domain.exceptions;


/**
 * Reports that a plan code is already in use.
 * @author Marlon Packard Viza Quispe
 */
public class DuplicatePlanCodeException extends RuntimeException {
    public DuplicatePlanCodeException(Throwable cause) { super("Plan code already exists.", cause); }
}
