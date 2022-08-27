public class Converter
{
    public static double stepsToKcal(int steps)
    {
        return Double.valueOf(steps) * 0.05;
    }
    public static double stepsToKM(int steps)
    {
        return Double.valueOf(steps) * 0.00075;
    }
}
