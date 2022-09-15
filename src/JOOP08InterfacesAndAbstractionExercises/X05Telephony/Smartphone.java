package X05Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();

        for (String url : this.urls) {

            if (hasNumbers(url)) {
                sb.append("Invalid URL!")
                        .append(System.lineSeparator());
            } else {
                sb.append(String.format("Browsing: %s!%n", url));
            }
        }

        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder stb = new StringBuilder();

        for (String number : this.numbers) {

            if (!hasOnlyNumbers(number)) {
                stb.append("Invalid number!")
                        .append(System.lineSeparator());
            } else {
                stb.append(String.format("Calling... %s%n", number));
            }
        }

        return stb.toString().trim();
    }

    private boolean hasNumbers(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    private boolean hasOnlyNumbers(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
