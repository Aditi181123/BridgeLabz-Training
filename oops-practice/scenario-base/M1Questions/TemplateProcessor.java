package M1Questions;
import java.util.*;
import java.util.regex.*;

public class TemplateProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Pattern pattern = Pattern.compile("\\$\\{(\\w+):(.*?)\\}");

        while (n-- > 0) {
            String line = sc.nextLine();
            Matcher m = pattern.matcher(line);
            StringBuffer result = new StringBuffer();

            while (m.find()) {
                String type = m.group(1);
                String value = m.group(2);
                String replacement = "INVALID";

                switch (type) {
                    case "UPPER":
                        replacement = value.toUpperCase();
                        break;
                    case "LOWER":
                        replacement = value.toLowerCase();
                        break;
                    case "REPEAT":
                        String[] parts = value.split(",");
                        if (parts.length == 2) {
                            try {
                                int count = Integer.parseInt(parts[1]);
                                replacement = parts[0].repeat(count);
                            } catch (Exception e) {}
                        }
                        break;
                    case "DATE":
                        String[] date = value.split("-");
                        if (date.length == 3) {
                            try {
                                int d = Integer.parseInt(date[0]);
                                int mth = Integer.parseInt(date[1]);
                                int y = Integer.parseInt(date[2]);
                                if (d >= 1 && d <= 31 && mth >= 1 && mth <= 12) {
                                    replacement = y + "/" + String.format("%02d", mth) + "/" + String.format("%02d", d);
                                }
                            } catch (Exception e) {}
                        }
                        break;
                }

                m.appendReplacement(result, replacement);
            }
            m.appendTail(result);

            System.out.println(result);
        }
    }
}