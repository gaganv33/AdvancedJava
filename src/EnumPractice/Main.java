package EnumPractice;

public class Main {
    public static void main(String[] args) {
        DaysOfTheWeek monday = DaysOfTheWeek.MONDAY;
        print(String.format("Previous of %s", monday.name()), monday.getPreviousDayOfTheWeek());
        print(String.format("Next of %s", monday.name()), monday.getNextDayOfTheWeek());
        print(String.format("Ordinal of %s", monday.name()), Integer.toString(monday.ordinal()));
        print(String.format("Value of %s", monday.name()), Integer.toString(monday.getValue()));
        print(String.format("Comment of %s", monday.name()), monday.getComment());
        print(String.format("Index of %s", monday.name()), Integer.toString(DaysOfTheWeek.getTheIndex(monday)));
    }

    private static void print(String comment, DaysOfTheWeek dayOfWeek) {
        System.out.printf("%s: %s\n", comment, dayOfWeek.name());
    }

    private static void print(String comment, String data) {
        System.out.printf("%s: %s\n", comment, data);
    }
}
