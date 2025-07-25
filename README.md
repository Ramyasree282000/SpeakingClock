# SpeakingClock
Java Spring boot app that converts 24 hour time into spoken words

# Features
- Convert any HH:MM time to spoken words
- Handles cases like Midnight-00:00 and Midday - 12:00
- Junit test coverage(poitive and negative scenarios)
- Input validation and error handling

# Prereuisties
- Java 17
- Maven

# Available End points
- api/time/convert?time=23:59 -- Returns: It's twenty three fifty nine
- api/time/current -- Returns the current system time in words

# Test cases covers
- valid inputs(ex: 11:25, 01:15, 23:59)
- Special cases(00:00 - Midnight, 12:00 - Midday)
- Invalid inputs(ex:"abc","",null, outofRange times like 25:61)


  
