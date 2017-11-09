package edu.wctc.advjava.mad.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Utility class for performing basic LocalDate/LocalDateTime operations (JDK 8+)
 * <p>
 * @version 1.00
 * @since 1.8
 * @author Matthew Dorney
 * 
 */
public class DateUtilities {
    
    /**
     * Format a <code>LocalDateTime</code> according to a specified pattern
     * as described in the <code>DateTimeFormatter</code> class
     * 
     * @param dateTime a <code>LocalDateTime</code>
     * @param formatStyle - An accepted pattern for DateTimeFormatter objects
     * @return A <code>String</code> representing your DateTime object formatted to the given pattern/style
     * @throws IllegalArgumentException if dateTime is null or formatStyle is invalid for DateTimeFormatter
     */
    public String dateTimeToFormattedString(LocalDateTime dateTime, String formatStyle) throws IllegalArgumentException{
        if (dateTime == null) {
            throw new IllegalArgumentException("This date is null");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStyle);
        return formatter.format(dateTime);
    }
    /**
     * Format a <code>LocalDateTime</code> according to the default date pattern for your Locale
     * 
     * @param dateTime a <code>LocalDateTime</code>
     * @return a <code>String</code> representing your date object using the Localized Format for dateTime
     * @throws IllegalArgumentException if dateTime is null
     */
    public String dateTimeToString(LocalDateTime dateTime) throws IllegalArgumentException {
        if (dateTime == null) {
            throw new IllegalArgumentException("This date is null");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL);
        return formatter.format(dateTime);
    }
    /**
     * Convert a string representation of a date into <code>LocalDate</code> object using a specified pattern
     * as described in the <code>DateTimeFormatter</code> class
     * 
     * @param dateString - a string representation of a date
     * @param pattern - the DateTimeFormatter pattern of your dateString
     * @return a <code>LocalDate</code> object
     * @throws IllegalArgumentException if either Parameters are empty or null, and if the pattern is invalid
     */
    public LocalDate parseDate(String dateString, String pattern) throws IllegalArgumentException {
        if (dateString == null || pattern == null || dateString.isEmpty() || pattern.isEmpty()) {
            throw new IllegalArgumentException("One or both strings is empty or null");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.parse(dateString, LocalDate::from);
    }
    /**
     * Convert a string representation of a date into <code>LocalDateTime</code> object using a specified pattern
     * as described in the <code>DateTimeFormatter</code> class
     * 
     * @param dateString - a string representation of a date and time
     * @param pattern - the DateTimeFormatter pattern of your dateString
     * @return - a <code>LocalDateTime</code> object
     * @throws IllegalArgumentException if either Parameters are empty or null, and if the pattern is invalid
     */
    public LocalDateTime parseDateTime(String dateString, String pattern) throws IllegalArgumentException {
        if (dateString == null || pattern == null || dateString.isEmpty() || pattern.isEmpty()) {
            throw new IllegalArgumentException("One or both strings is empty or null");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.parse(dateString, LocalDateTime::from);
    }
    /**
     * Takes two <code>LocalDateTime</code> objects and returns the difference in minutes
     * 
     * @param startTime - <code>LocalDateTime</code> representing the beginning of the period you are measuring
     * @param endTime - <code>LocalDateTime</code> representing the end of the period you are measuring
     * @return a <code>Long</code> representing the number of minutes between the date time objects
     * @throws IllegalArgumentException if either <code>LocalDateTime</code> is null
     */
    public long diffInMinutes(LocalDateTime startTime, LocalDateTime endTime) throws IllegalArgumentException {
        if (startTime == null || endTime == null) {
            throw new IllegalArgumentException("One or both objects entered was null");
        }
        return Duration.between(startTime, endTime).toMinutes();
    }
}
