package com.moneybin.mortageplan.repository;

import com.moneybin.mortageplan.entity.Customer;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@Repository
public class FileRepository {

    public static ArrayList<Customer> readFile() {

        Scanner fileScanner = null;
        ArrayList<Customer> customers = new ArrayList<>();

        try {

            fileScanner = new Scanner(new File("./prospects.txt"));
            // Getting rid of first line which contains titles.
            if (fileScanner.hasNext()) {
                fileScanner.nextLine();
            }

            while (!fileScanner.hasNext(".")) {

                if (fileScanner.hasNext()) {

                    String line = fileScanner.nextLine();
                    customers.add(extractCustomerFromLine(line));
                }
            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {

            if (fileScanner != null)
                fileScanner.close();
        }

        return customers;
    }

    private static Customer extractCustomerFromLine(String line) {

        String[] lineSubStrings = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

        return new Customer(
                lineSubStrings[0],
                Double.parseDouble(lineSubStrings[1]),
                Double.parseDouble(lineSubStrings[2]),
                Integer.parseInt(lineSubStrings[3])
        );
    }
}
