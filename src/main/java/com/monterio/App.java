package com.monterio;

import com.monterio.business.CheckingAccount;
import com.monterio.business.CheckingAccountManager;
import com.monterio.business.Customer;
import com.monterio.business.CustomerManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static CustomerManager customerManager;
    static CheckingAccountManager accountManager;

    public static void main(String[] args) {

        initializeBankSystem();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter customer ID: ");
                    int customerId = scanner.nextInt();
                    Customer customer = customerManager.findCustomerById(customerId);

                    if (customer != null)
                        System.out.println(customer);
                    else
                        System.out.println("Customer not found!");

                    newLine();
                    break;

                case 2:
                    System.out.print("Enter account ID: ");
                    int accountId = scanner.nextInt();
                    CheckingAccount account = accountManager.findAccountById(accountId);

                    if (account != null)
                        System.out.println(account);
                    else
                        System.out.println("Account not found!");

                    newLine();
                    break;

                case 3:
                    System.out.print("Enter customer ID: ");
                    int customerIdToActivate = scanner.nextInt();
                    Customer customerToActivate = customerManager.findCustomerById(customerIdToActivate);

                    if (customerToActivate != null) {
                        customerToActivate.setActive(true);
                        System.out.println("Customer successfully activated!");
                    } else {
                        System.out.println("Customer not found!");
                    }

                    newLine();
                    break;

                case 4:
                    System.out.print("Enter customer ID: ");
                    int customerIdToDeactivate = scanner.nextInt();
                    Customer customerToDeactivate = customerManager.findCustomerById(customerIdToDeactivate);

                    if (customerToDeactivate != null) {
                        customerToDeactivate.setActive(false);
                        System.out.println("Customer successfully deactivated!");
                    } else {
                        System.out.println("Customer not found!");
                    }

                    newLine();
                    break;

                case 5:
                    running = false;
                    System.out.println("################# System terminated #################");
                    break;

                default:
                    System.out.println("Invalid option.\n");
                    break;
            }
        }
        scanner.close();
    }

    private static void newLine() {
        System.out.println("\n");
    }

    /**
     * Displays main menu options.
     */
    private static void printMenu() {
        System.out.println("What would you like to do?\n");
        System.out.println("1) Find a customer");
        System.out.println("2) Find a checking account");
        System.out.println("3) Activate a customer");
        System.out.println("4) Deactivate a customer");
        System.out.println("5) Exit");
        System.out.println();
    }

    private static void initializeBankSystem() {
        List<CheckingAccount> bankAccounts = createMockAccounts();
        List<Customer> bankCustomers = createMockCustomers(bankAccounts);

        customerManager = new CustomerManager(bankCustomers);
        accountManager = new CheckingAccountManager(bankAccounts);
    }

    private static List<CheckingAccount> createMockAccounts() {
        List<CheckingAccount> accounts = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            accounts.add(new CheckingAccount(i, 1000.0 * i, true));
        }
        return accounts;
    }

    private static List<Customer> createMockCustomers(List<CheckingAccount> accounts) {
        List<String> customerNames = List.of(
                "Albert Einstein",
                "Isaac Newton",
                "Marie Curie",
                "Richard Feynman",
                "Stephen Hawking",
                "Galileo Galilei",
                "Niels Bohr",
                "Max Planck",
                "James Clerk Maxwell",
                "Erwin Schrödinger"
        );

        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < customerNames.size(); i++) {
            String name = customerNames.get(i);
            int age = 35 + i; // só para variar um pouco
            String email = name.toLowerCase().replace(" ", "") + "@physics.com";

            final CheckingAccount account = accounts.get(i);
            customers.add(new Customer(i + 1, name, age, email, account.getId(), true));
        }

        return customers;
    }
}