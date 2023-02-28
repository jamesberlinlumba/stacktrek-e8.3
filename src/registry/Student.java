package registry;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String firstName;
    private String lastName;
    private String birthday;
    private String course;
    private String email;

    private boolean validateText(String text) {
        Pattern textPattern = Pattern.compile("^([a-zA-Z\\s](?=[a-zA-Z\\s])){0,48}[a-zA-Z]$");
        Matcher textMatcher = textPattern.matcher(text);

        if (textMatcher.find()) {
            return true;
        }

        System.out.println("Invalid Input. Should not contain numerals and special characters.");
        return false;
    }
    public boolean setFirstName(String text) {
        if (validateText(text)) {
            this.firstName = text;
            return true;
        }

        return false;
    }

    public boolean setLastName(String text) {
        if (validateText(text)) {
            this.lastName = text;
            return true;
        }

        return false;
    }

    public boolean setDate(String date) {
        Pattern datePattern = Pattern.compile("^[0-9]{4}/[0-9]{2}/[0-9]{2}$");
        Matcher dateMatcher = datePattern.matcher(date);

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        if (
                dateMatcher.find()
                && Integer.parseInt(date.split("/")[0]) <= currentYear - 19
                && Integer.parseInt(date.split("/")[1]) <= 12
        ) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, Integer.parseInt(date.split("/")[0]));
            calendar.set(Calendar.MONTH, Integer.parseInt(date.split("/")[1]));

            if (Integer.parseInt(date.split("/")[2]) <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                this.birthday = date;
                return true;
            }
        }

        System.out.println("Invalid Date.");
        return false;
    }

    public boolean setCourse(String text) {
        if (validateText(text)) {
            this.course = text;
            return true;
        }

        return false;
    }

    public boolean setEmail(String email) {
        Pattern pattern = Pattern.compile("^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,}$");
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            this.email = email;
            return true;
        }

        System.out.println("Invalid email address.");
        return false;
    }

    public String getResult() {
        LocalDate currentDate = LocalDate.now();

        return currentDate.getYear() + "-" + birthday.split("/")[2] + "01-" + lastName.split("")[0].toLowerCase();
    }
}
