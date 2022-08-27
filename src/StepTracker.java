public class StepTracker
{
    public int targetedSteps;
    public boolean isItLeapYear;
    public MonthData[] monthToData;

    public StepTracker(boolean leapYear, int targetedsteps)
    {
        isItLeapYear = leapYear;
        targetedSteps = targetedsteps;

        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++)
        {
            monthToData[i] = new MonthData(i, isItLeapYear);
        }
    }

    public void printAllStepsPerDay(int month, int daysPerLine)
    {
        int d = 0;
        for(int i = 0; i < monthToData[month].stepsPerDay.length; i++)
        {
            if (d > 0) {System.out.print(", ");}
            System.out.print((i + 1) + " день: " + monthToData[month].stepsPerDay[i]);
            d++;
            if (d == daysPerLine)
            {
                System.out.println();
                d = 0;
            }
        }
        if(d > 0) {System.out.println();}
    }
    public void printBestStreak(int month)
    {
        int streak = 0;
        int maxStreak = 0;
        for(int i = 0; i < monthToData[month].stepsPerDay.length; i++)
        {
            if(monthToData[month].stepsPerDay[i] >= targetedSteps)
            {
                streak++;
                if (streak > maxStreak) {maxStreak = streak; }

            }
            else { streak = 0; }
        }

        if(maxStreak == 0) {System.out.println("У вас не было ни одной серии из дней, привысивших целевое количество шагов.");}
        else {System.out.println("В этом месяце лучшая серия дней, привысивших целевое значение шагов: " + (maxStreak) + ".");}
    }
    public int getAllStepsByMonth(int month)
    {
        int steps = 0;
        for(int i = 0; i < monthToData[month].stepsPerDay.length; i++)
        {
            steps = steps + monthToData[month].stepsPerDay[i];
        }
        return steps;
    }

    public void printAverageSteps(int month)
    {
        int steps = 0;
        int days = 0;
        for(int i = 0; i < monthToData[month].stepsPerDay.length; i++)
        {
            int stepsperday = monthToData[month].stepsPerDay[i];
            if(stepsperday > 0)
            {
                steps = steps + stepsperday;
                days++;
            }
        }
        if(days > 0) {System.out.println("Среднее количество шагов в день: " + (steps / days) + ". (Учитывались лишь те дни, в которые вы ходили.)");}
        else {System.out.println("Данные за месяц отсутствуют.");}
    }
    public void printMaxStepsByMonth(int month)
    {
        int maxsteps = 0;
        for(int i = 0; i < monthToData[month].stepsPerDay.length; i++)
        {
            if(monthToData[month].stepsPerDay[i] > monthToData[month].stepsPerDay[maxsteps])
            {
                maxsteps = i;
            }
        }
        System.out.println("Ваше максимальное пройденное количество шагов за этот месяц: " + monthToData[month].stepsPerDay[maxsteps] + ". Это было " + (maxsteps + 1)+ " числа.");
    }

    public void setStepsPerDay(int month, int day, int steps)
    {
         monthToData[month].stepsPerDay[day] = steps;
    }


}
