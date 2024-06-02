package eu.deic.io;

public class ScreenTime {
    public static void main(String[] args) {
        int[][] screenTime = {
        	{220, 240, 210, 180, 250, 230, 200},   
        	{280, 270, 260, 220, 290, 310, 300},  
        	{250, 260, 270, 280, 290, 300, 310}   
        };

        int minTime = Integer.MAX_VALUE;
        int maxTime = Integer.MIN_VALUE;
        int minDay = -1;
        int maxDay = -1;

        for (int week = 0; week < screenTime.length; week++) {
            for (int day = 0; day < screenTime[week].length; day++) {
                if (screenTime[week][day] < minTime) {
                    minTime = screenTime[week][day];
                    minDay = (week * 7) + day + 1;
                }
                if (screenTime[week][day] > maxTime) {
                    maxTime = screenTime[week][day];
                    maxDay = (week * 7) + day + 1;
                }
            }
        }

        System.out.println("Cel mai putin timp petrecut în fața ecranului: " + minTime + " de minute în ziua " + minDay);
        System.out.println("Cel mai mare timp petrecut în fața ecranului: " + maxTime + " de minute în ziua " + maxDay);
    }
}

