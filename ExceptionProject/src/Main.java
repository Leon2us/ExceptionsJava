import java.io.*;

public class Main {
    public static void main(String[] args) {

        int a, b = 0;
        String[] names = {"John Smith", "Mike Friedman", "Frank Naka", "Joel Bennis"};
        try {
            a = 10 / b;
        } catch (ArithmeticException arc) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("ExceptionFile.txt"));
                writer.write(arc.toString());
                for (String name : names)
                    writer.write("\n" + name);
                writer.write("\nProgram closed successfully.");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("End.");
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("ExceptionFile.txt"));
            String line;
            while ((line = reader.readLine()) != null)
                System.out.println(line);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}