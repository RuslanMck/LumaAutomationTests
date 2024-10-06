package helpers;

import java.io.*;


public class EmailIncrementHelper {

    private static final String FILE_PATH = "src/test/resources/email_increment.txt";

    /**
     * Gets the value from the email_increment.txt file
     * @return int vale from email_increment.txt file
     */
    public static int readEmailIncrement() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            return 1;
        }
    }


    /**
     * Gets the increment and writes it to the email_increment.txt file
     * @param increment As int value represents email address increment
     */
    public static void writeEmailIncrement(int increment) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            writer.write(String.valueOf(increment));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
