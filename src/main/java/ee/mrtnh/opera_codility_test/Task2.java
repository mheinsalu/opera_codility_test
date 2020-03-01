package ee.mrtnh.opera_codility_test;

import java.util.Arrays;

public class Task2 {

    final static int MINUTES_IN_DAY = 1440;

    public static void main(String[] args) {
        Task2 task2 = new Task2();

        String testString1 = "Sun 10:00-20:00 \n Fri 05:00-10:00 \n Fri 16:30-23:50 \n Sat 10:00-24:00 \n Sun 01:00-04:00 \n Sat 02:00-06:00 \n Tue 03:30-18:15 \n Tue 19:00-20:00 \n Wed 04:25-15:14 \n Wed 15:14-22:40 \n Thu 00:00-23:59 \n Mon 05:00-13:00 \n Mon 15:00-21:00";
        System.out.println("Solution is " + task2.solution(testString1));

        String testString2 = "Mon 01:00-23:00\nTue 01:00-23:00\nWed 01:00-23:00\nThu 01:00-23:00\nFri 01:00-23:00\nSat 01:00-23:00\nSun 01:00-21:00";
        System.out.println("Solution is " + task2.solution(testString2));
    }

    class ParsedLine implements Comparable<ParsedLine> {
        int start;
        int end;

        ParsedLine(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return start + " - " + end;
        }

        public int compareTo(ParsedLine compareParsedLine) {
            int compareStart = ((ParsedLine) compareParsedLine).getStart();
            //ascending order
            return this.start - compareStart;
        }
    }

    public int solution(String S) {
        String[] lines = S.split("\n");
        ParsedLine[] parsedLinesArray = new ParsedLine[lines.length];
        for (int i = 0; i < lines.length; i++) {
            parsedLinesArray[i] = parseLineToTimes(lines[i].trim());
        }
        Arrays.sort(parsedLinesArray);
        int maxInterval = parsedLinesArray[0].getStart();

        for (int i = 1; i < parsedLinesArray.length; i++) {
            int interval = parsedLinesArray[i].getStart() - parsedLinesArray[i - 1].getEnd();
            if (interval > maxInterval) {
                maxInterval = interval;
            }
        }

        int timeFromLastMeetingEndToNewWeek = 7 * MINUTES_IN_DAY - parsedLinesArray[parsedLinesArray.length - 1].getEnd();
        if (timeFromLastMeetingEndToNewWeek > maxInterval) {
            maxInterval = timeFromLastMeetingEndToNewWeek;
        }

        return maxInterval;
    }

    ParsedLine parseLineToTimes(String line) {
        String day = line.split(" ")[0];
        int dayStartIndex = convertDayStringToMinutes(day);

        String times = line.split(" ")[1];
        String startTime = times.split("-")[0];
        String endTime = times.split("-")[1];
        return new ParsedLine(
                dayStartIndex + convertTimeStringToMinutes(startTime),
                dayStartIndex + convertTimeStringToMinutes(endTime)
        );
    }

    int convertDayStringToMinutes(String day) {
        return convertDayIndexToStartMinute(convertDayStringToIndex(day));
    }

    int convertDayStringToIndex(String day) {
        if (day.compareTo("Mon") == 0) return 1;
        if (day.compareTo("Tue") == 0) return 2;
        if (day.compareTo("Wed") == 0) return 3;
        if (day.compareTo("Thu") == 0) return 4;
        if (day.compareTo("Fri") == 0) return 5;
        if (day.compareTo("Sat") == 0) return 6;
        if (day.compareTo("Sun") == 0) return 7;
        return 0;
    }

    int convertDayIndexToStartMinute(int dayIndex) {
        return (dayIndex - 1) * MINUTES_IN_DAY;
    }

    int convertTimeStringToMinutes(String time) {
        String[] timeSplitToHoursAndMinutes = time.split(":");
        String hourString = timeSplitToHoursAndMinutes[0];
        String minuteString = timeSplitToHoursAndMinutes[1];
        int hour = Integer.parseInt(hourString);
        int minute = Integer.parseInt(minuteString);
        return hour * 60 + minute;
    }
}
