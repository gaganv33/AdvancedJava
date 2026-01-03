package EnumPractice;

public enum DaysOfTheWeek {
    MONDAY(1, "Monday"){
        @Override
        public DaysOfTheWeek getPreviousDayOfTheWeek() {
            return SUNDAY;
        }

        @Override
        public DaysOfTheWeek getNextDayOfTheWeek() {
            return TUESDAY;
        }
    },
    TUESDAY(2, "Tuesday") {
        @Override
        public DaysOfTheWeek getPreviousDayOfTheWeek() {
            return MONDAY;
        }

        @Override
        public DaysOfTheWeek getNextDayOfTheWeek() {
            return WEDNESDAY;
        }
    },
    WEDNESDAY(3, "Wednesday") {
        @Override
        public DaysOfTheWeek getPreviousDayOfTheWeek() {
            return TUESDAY;
        }

        @Override
        public DaysOfTheWeek getNextDayOfTheWeek() {
            return THURSDAY;
        }
    },
    THURSDAY(4, "Thursday") {
        @Override
        public DaysOfTheWeek getPreviousDayOfTheWeek() {
            return WEDNESDAY;
        }

        @Override
        public DaysOfTheWeek getNextDayOfTheWeek() {
            return FRIDAY;
        }
    },
    FRIDAY(5, "Friday") {
        @Override
        public DaysOfTheWeek getPreviousDayOfTheWeek() {
            return THURSDAY;
        }

        @Override
        public DaysOfTheWeek getNextDayOfTheWeek() {
            return SATURDAY;
        }
    },
    SATURDAY(6, "Saturday") {
        @Override
        public DaysOfTheWeek getPreviousDayOfTheWeek() {
            return FRIDAY;
        }

        @Override
        public DaysOfTheWeek getNextDayOfTheWeek() {
            return SUNDAY;
        }
    },
    SUNDAY(7, "Sunday") {
        @Override
        public DaysOfTheWeek getPreviousDayOfTheWeek() {
            return SATURDAY;
        }

        @Override
        public DaysOfTheWeek getNextDayOfTheWeek() {
            return MONDAY;
        }
    };

    private final int value;
    private final String comment;

    DaysOfTheWeek(int value, String comment) {
        this.value = value;
        this.comment = comment;
    }

    public int getValue() {
        return this.value;
    }

    public String getComment() {
        return this.comment;
    }

    public static int getTheIndex(DaysOfTheWeek dayOfWeek) {
        return (1 + dayOfWeek.ordinal());
    }

    public abstract DaysOfTheWeek getPreviousDayOfTheWeek();
    public abstract DaysOfTheWeek getNextDayOfTheWeek();
}
