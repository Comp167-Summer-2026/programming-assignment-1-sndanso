import java.util.Scanner;

public class TemperatureConverter {

    // Method used to convert a temperature to the opposite unit
    public static double convertTemperature(double temperature, String unit) {

        // If the unit is Celsius, convert to Fahrenheit
        if (unit.equalsIgnoreCase("C")) {
            return (temperature * 9 / 5) + 32;
        }

        // Convert Fahrenheit to Celsius
        else {
            return (temperature - 32) * 5 / 9;
        }
    }

    public static void main(String[] args) {

        // Create Scanner object to read user input
        Scanner input = new Scanner(System.in);

        // Decides whether the program keeps running or not
        boolean keepGoing = true;

        // Keeps repeating until the user enters stop
        while (keepGoing) {

            // Ask the user for a temperature value
            System.out.print("Enter a temperature value or type stop to quit: ");

            // Store the user's input
            String tempInput = input.nextLine();

            // Double checks if the user decides to end the program
            if (tempInput.equalsIgnoreCase("stop")) {
                keepGoing = false;
            }

            // Check if the temperature entered is valid
            else if (!tempInput.matches("-?\\d+(\\.\\d+)?")) {
                System.out.println("Invalid temperature input.");
            }

            else {


                double temperature = Double.parseDouble(tempInput);

                // Ask the user for the temperature unit
                System.out.print("Enter unit (C or F): ");

                // Store the unit entered by the user
                String unit = input.nextLine();

                // Make sure the unit is either C or F
                if (unit.equalsIgnoreCase("C") || unit.equalsIgnoreCase("F")) {

                    //
                    double result = convertTemperature(temperature, unit);

                    // Display Celsius to Fahrenheit conversion
                    if (unit.equalsIgnoreCase("C")) {

                        System.out.printf("%.2fC is equal to %.2fF%n",
                                temperature, result);

                    }

                    // Display Fahrenheit to Celsius conversion
                    else {

                        System.out.printf("%.2fF is equal to %.2fC%n",
                                temperature, result);
                    }

                }

                // Display an error message for invalid unit
                else {
                    System.out.println("Invalid unit.");
                }
            }
        }

        // Closes the Scanner
        input.close();
    }
}

