import java.util.Scanner;

public class Main
{
    public static StepTracker stepTracker;

    public static void main(String[] args)
    {
        stepTracker = new StepTracker(false, 2000);


        while(true)
        {
            printMenu();
            System.out.println("Ваш выбор:");
            int userInput = getInput();

            if(userInput == 1)
            {
                getMonthStats();
            }
            else if(userInput == 2)
            {
                enterStats();
            }
            else if(userInput == 3)
            {
                int steps;
                while(true)
                {
                    System.out.println("Введите количество шагов:");
                    steps = getInput();
                    if(steps < 0)
                    {
                        System.out.println("Количество шагов не должно быть ниже 0.");
                    }
                    else
                    {
                        break;
                    }
                }
                stepTracker.targetedSteps = steps;
                System.out.println("Целевое количество шагов назначено.");
            }
            else if (userInput == 0)
            {
                break;
            }
            else
            {
                System.out.println("Такого пункта нет.");
            }
        }
    }

    public static int getInput()
    {
        Scanner scanner = new Scanner(System.in);
        try {return scanner.nextInt();}
        catch (Throwable t)
        {
            System.out.println("Ошибка ввода.");
            return Integer.MIN_VALUE;
        }
    }

    public static void printMenu()
    {
        System.out.println("Выберете опцию введя соответствующую цифру:");
        System.out.println("1) Просмотреть статистику за определённый месяц.");
        System.out.println("2) Ввести статистику за определённый месяц.");
        System.out.println("3) Ввести целевое количество шагов в день.");
        System.out.println("0) Выйти из программы.");
    }

    public static int getMonth()
    {
        System.out.println("Выберете месяц, введя число от 1 до 12, январь - 1, декабрь - 12.");
        int month;
        while(true)
        {
            System.out.println("Ваш выбор:");
            month = getInput();
            if(month < 1)
            {
                System.out.println("Номер месяца не должен быть ниже 1.");
            }
            else if (month > 12)
            {
                System.out.println("Номер месяца не должен выше 12.");
            }
            else
            {
                month = month - 1;
                System.out.println("Вы выбрали: " + stepTracker.monthToData[month].monthName() + ".");
                return month;
            }
        }
    }

    public static void getMonthStats()
    {
        int month = getMonth();

        System.out.println("Какая статистика вас интересует?");
        System.out.println("1) Количество пройденных шагов по дням.");
        System.out.println("2) Общее количество шагов за месяц.");
        System.out.println("3) Максимальное пройденное количество шагов в месяце.");
        System.out.println("4) Среднее количество шагов.");
        System.out.println("5) Пройденная дистанция.");
        System.out.println("6) Количество сожжённых килокалорий.");
        System.out.println("7) Лучшая серия.");
        boolean condition = true;
        while(condition)
        {
            condition = false;

            System.out.println("Ваш выбор:");
            int choice = getInput();
            switch(choice)
            {
                case 1:
                    stepTracker.printAllStepsPerDay(month, 6);
                    break;
                case 2:
                    System.out.println("За этот месяц вы прошли " + stepTracker.getAllStepsByMonth(month) + " шагов.");
                    break;
                case 3:
                    stepTracker.printMaxStepsByMonth(month);
                    break;
                case 4:
                    stepTracker.printAverageSteps(month);
                    break;
                case 5:
                    System.out.println("За этот месяц вы прошли " + Converter.stepsToKM(stepTracker.getAllStepsByMonth(month)) + " КМ.");
                    break;
                case 6:
                    System.out.println("За этот месяц вы сожгли " + Converter.stepsToKcal(stepTracker.getAllStepsByMonth(month)) + " ккал.");
                    break;
                case 7:
                    stepTracker.printBestStreak(month);
                    break;
                default:
                    System.out.println("Такого пункта нет в списке.");
                    condition = true;
                    break;
            }
        }
    }

    public static void enterStats()
    {
        int month = getMonth();

        System.out.println("Выберете дату.");
        int day;
        while(true)
        {
            System.out.println("Ваш выбор:");
            day = getInput();
            if(day < 1)
            {
                System.out.println("Число не может быть ниже 1.");
            }
            else if (day > stepTracker.monthToData[month].stepsPerDay.length)
            {
                System.out.println("В этом месяце " + stepTracker.monthToData[month].stepsPerDay.length + " дня");
            }
            else
            {
                day = day - 1;

                int steps;
                while(true)
                {
                    System.out.println("Введите количество пройденых шагов:");
                    steps = getInput();
                    if(steps < 0)
                    {
                        System.out.println("Количество пройденых шагов не должно быть ниже 0.");
                    }
                    else
                    {
                        break;
                    }
                }
                stepTracker.setStepsPerDay(month, day, steps);
                System.out.println("Данные записаны.");
                break;
            }
        }
    }
}
