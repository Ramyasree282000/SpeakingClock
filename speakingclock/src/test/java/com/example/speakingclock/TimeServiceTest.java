package com.example.speakingclock;

import com.example.speakingclock.exception.InvalidTimeException;
import com.example.speakingclock.service.TimeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TimeServiceTest {

    @Autowired
    private TimeService timeService;

    @Test
    public void testMidnight() {
        assertEquals("It's Midnight", timeService.convertTimeToWords("00:00"));
    }

    @Test
    public void testMidday() {
        assertEquals("It's Midday", timeService.convertTimeToWords("12:00"));
    }

    @Test
    public void testValidTime() {
        assertEquals("It's eleven twenty five", timeService.convertTimeToWords("11:25"));
    }
    @Test
    public void testEarlyMorning() {
        assertEquals("It's one fifteen", timeService.convertTimeToWords("01:15"));
    }

    @Test
    public void testLateEvening() {
        assertEquals("It's twenty three fifty nine", timeService.convertTimeToWords("23:59"));
    }


    @Test
    public void testInvalidTimeFormat() {
        Exception exception = assertThrows(InvalidTimeException.class, () ->
                timeService.convertTimeToWords("abc"));
        assertTrue(exception.getMessage().contains("Invalid time format"));
    }
    
    @Test
    public void testEmptyInput() {
        Exception exception = assertThrows(InvalidTimeException.class, () ->
                timeService.convertTimeToWords(""));
        assertTrue(exception.getMessage().contains("Invalid time format"));
    }

    @Test
    public void testNullInput() {
        Exception exception = assertThrows(InvalidTimeException.class, () ->
                timeService.convertTimeToWords(null));
        assertTrue(exception.getMessage().contains("Invalid time format"));
    }
    
    @Test
    public void testOutOfRangeTime() {
        Exception exception = assertThrows(InvalidTimeException.class, () ->
                timeService.convertTimeToWords("25:61"));
        assertTrue(exception.getMessage().contains("Invalid time values"));
    }


}
