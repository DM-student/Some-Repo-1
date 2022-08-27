public class MonthData
{
    int monthNum;
    public int stepsPerDay[];

    public MonthData(int month, boolean isItLeapYear)
    {
        monthNum = month;
        if (month + 1 == 2)
        {
            if(isItLeapYear){
                stepsPerDay = new int[29];}
            else {
                stepsPerDay = new int[28];}
        }
        else if((month + 1) % 2 == 0)
        {
            stepsPerDay = new int[30];
        }
        else
        {
            stepsPerDay = new int[31];
        }
    }

    public String monthName()
    {
        switch(monthNum)
        {
            case 0:
                return "Январь";
            case 1:
                return "Февраль";
            case 2:
                return "Март";
            case 3:
                return "Апрель";
            case 4:
                return "Май";
            case 5:
                return "Июнь";
            case 6:
                return "Июль";
            case 7:
                return "Август";
            case 8:
                return "Сентябрь";
            case 9:
                return "Октябрь";
            case 10:
                return "Ноябрь";
            case 11:
                return "Декабрь";
            default:
                return null;
        }
    }
}
