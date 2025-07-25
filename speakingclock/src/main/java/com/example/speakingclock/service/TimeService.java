package com.example.speakingclock.service;

import com.example.speakingclock.exception.InvalidTimeException;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class TimeService {

	
    public String convertCurrentTimeToWords() {
        LocalTime now = LocalTime.now();
        String time = now.format(DateTimeFormatter.ofPattern("HH:mm"));
        return convertTimeToWords(time);
    }

    
    public String convertTimeToWords(String time) {
        if (time == null || !time.matches("\\d{2}:\\d{2}")) {
            throw new InvalidTimeException("Invalid time format. Use HH:mm");
        }

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        if (hour > 23 || minute > 59) {
            throw new InvalidTimeException("Invalid time values");
        }

        if (hour == 0 && minute == 0)
            return "It's Midnight";

        if (hour == 12 && minute == 0)
            return "It's Midday";

        return "It's " + numberToWords(hour) + " " + numberToWords(minute);
    }

    private String numberToWords(int num) {
        if (num < 0 || num > 59) {
            throw new IllegalArgumentException("Number out of supported range (0–59)");
        }

        String[] words = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
        };

        String[] tens = {
            "", "", "twenty", "thirty", "forty", "fifty"
        };

        if (num < 20) {
            return words[num];
        } else {
            return tens[num / 10] + (num % 10 != 0 ? " " + words[num % 10] : "");
        }
    }
}
