package eu.deic.io;

public class ScreenTimeOop {
    public static void main(String[] args) {
    	WeeklyScreenTime[] weeklyScreenTimes = {
                new WeeklyScreenTime(new int[]{220, 240, 210, 180, 250, 230, 200}),
                new WeeklyScreenTime(new int[]{280, 270, 260, 220, 290, 310, 300}),
                new WeeklyScreenTime(new int[]{250, 260, 270, 280, 290, 300, 310})
         };
    	
        int minTime = Integer.MAX_VALUE;
        int maxTime = Integer.MIN_VALUE;
        int minDay = -1;
        int maxDay = -1;

        for (int i = 0; i < weeklyScreenTimes.length; i++) {
            int minDayOfWeek = weeklyScreenTimes[i].getMinDay();
            int minTimeOfWeek = weeklyScreenTimes[i].getMinTime();
            int maxDayOfWeek = weeklyScreenTimes[i].getMaxDay();
            int maxTimeOfWeek = weeklyScreenTimes[i].getMaxTime();

            if (minTimeOfWeek < minTime) {
                minTime = minTimeOfWeek;
                minDay = minDayOfWeek + (i * 7);
            }

            if (maxTimeOfWeek > maxTime) {
                maxTime = maxTimeOfWeek;
                maxDay = maxDayOfWeek + (i * 7);
            }
        }

        System.out.println("Cel mai putin timp petrecut în fața ecranului: " + minTime + " de minute în ziua " + minDay);
        System.out.println("Cel mai mult timp petrecut în fața ecranului: " + maxTime + " de minute în ziua " + maxDay);
    }
}

class WeeklyScreenTime {
    private int[] screenTime;

    public WeeklyScreenTime(int[] screenTime) {
        this.screenTime = screenTime;
    }

    public int getMinTime() {
        int min = Integer.MAX_VALUE;
        for (int time : screenTime) {
            if (time < min) {
                min = time;
            }
        }
        return min;
    }

    public int getMaxTime() {
        int max = Integer.MIN_VALUE;
        for (int time : screenTime) {
            if (time > max) {
                max = time;
            }
        }
        return max;
    }

    public int getMinDay() {
        int min = Integer.MAX_VALUE;
        int minDay = -1;
        for (int i = 0; i < screenTime.length; i++) {
            if (screenTime[i] < min) {
                min = screenTime[i];
                minDay = i + 1;
            }
        }
        return minDay;
    }

    public int getMaxDay() {
        int max = Integer.MIN_VALUE;
        int maxDay = -1;
        for (int i = 0; i < screenTime.length; i++) {
            if (screenTime[i] > max) {
                max = screenTime[i];
                maxDay = i + 1;
            }
        }
        return maxDay;
    }
}

