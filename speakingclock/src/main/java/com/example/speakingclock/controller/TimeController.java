package com.example.speakingclock.controller;

import com.example.speakingclock.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/time")
public class TimeController {

	 @Autowired
	    private TimeService timeService;

	    @GetMapping("/current")
	    public ResponseEntity<String> getCurrentTimeInWords() {
	        
	        return ResponseEntity.ok(timeService.convertCurrentTimeToWords());
	    }

	   
	    @GetMapping("/convert")
	    public ResponseEntity<String> convertTimeToWords(@RequestParam String time) {
	        return ResponseEntity.ok(timeService.convertTimeToWords(time));
	    }
}
