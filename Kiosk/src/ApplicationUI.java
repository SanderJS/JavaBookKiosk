import jdk.nashorn.internal.ir.IfNode;
import sun.swing.StringUIClientPropertyKey;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Makes up the user interface (text based) of the application.
 * Responsible for all user interaction, like displaying the menu
 * and receiving input from the user.
 *
 * @author asty
 * @version 1.0
 */
public class ApplicationUI {

    private TextStorage textStorage;

    // The menu tha will be displayed. Please edit/alter the menu
    // to fit your application (i.e. replace "prodct" with "litterature"
    // etc.
    private String[] menuItems = {
            "1. List all products",
            "2. Add new product",
            "3. Find a product by name",

    };

    /**
     * Creates an instance of the ApplicationUI User interface and a new book storage.
     */
    public ApplicationUI() {
        this.textStorage = new TextStorage();
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start() {
        this.init();

        boolean quit = false;

        while (!quit) {
            try {
                int menuSelection = this.showMenu();
                switch (menuSelection) {
                    case 1:
                        this.listAllProducts();
                        break;

                    case 2:
                        this.addNewProduct();
                        break;

                    case 3:
                        this.findProductByName();
                        break;

                    case 4:
                        System.out.println("\nThank you for using Application v0.1. Bye!\n");
                        quit = true;
                        break;

                    default:
                        System.out.println("Command not recognized");
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nERROR: Please provide a number between 1 and " + this.menuItems.length + "..\n");
            }
        }

    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items.
     * If the user inputs anything else, an InputMismatchException is thrown.
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number) provided by the user.
     * @throws InputMismatchException if user enters an invalid number/menu choice
     */
    private int showMenu() throws InputMismatchException {
        System.out.println("\n**** Application v0.1 ****\n");
        // Display the menu
        for (String menuItem : menuItems) {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

    // ------ The methods below this line are "helper"-methods, used from the menu ----
    // ------ All these methods are made privat, since they are only used by the menu ---

    /**
     * Initializes the application.
     * Typically you would create the LiteratureRegistrer-instance here
     */
    private void init() {
        System.out.println("init() was called");
    }

    /**
     * Lists all the products/literature in the register
     */
    public void listAllProducts() {
        if (this.textStorage.listSize() > 0) {
            System.out.println(textStorage.listAllTexts());
        } else {
            System.out.println("There are nothing stored at the moment.");
        }
    }

    /**
     * Add a new product/literature to the register.
     * In this method you have to add code to ask the
     * user for the necessary information you need to
     * create an instance of the product, which you
     * then send as a parameter to the addNewspaper()-
     * method of the register.
     * Remember to also handle invalid input from the
     * user!!
     */
    private void addNewProduct() throws InputMismatchException {
        int numberOfProducts = 5;
        String doNotUse = "";
        String title = "";
        String author = "";
        String publisher = "";
        String edition = "";
        String refNumber = "";
        String genre = "";
        String releaseDate = "";
        String project = "";
        String seriesName = "";

        int pages;
        int price;

        boolean isSeries = false;

        System.out.println("Which product");
        System.out.println("1: Book");
        System.out.println("2: Magazine");
        System.out.println("3: Newspaper");
        System.out.println("4: wiki");
        System.out.println("5: 3 pre generated books");

        boolean quit = false;

        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > numberOfProducts)) {
            throw new InputMismatchException();
        }

        while (!quit) {
            try {
                switch (menuSelection) {
                    case 1:
                        doNotUse = reader.nextLine();   //This grabs the previous input. Temp fix, please fix later.

                        System.out.println("Please type the title of the book: ");
                        title = reader.nextLine();

                        System.out.println("Please type the author of the book: ");
                        author = reader.nextLine();

                        System.out.println("Please type the publisher of the book: ");
                        publisher = reader.nextLine();

                        System.out.println("Please type the edition of the book: ");
                        edition = reader.nextLine();

                        System.out.println("Please type the reference number of the book");
                        System.out.println("This should be at least 3 characters long:");
                        refNumber = reader.nextLine();
                        if (refNumber.length() < 3) {
                            System.out.println("This book will fail due to user error. Not Sorry.");
                        }

                        System.out.println("Please type the genre of the book: ");
                        genre = reader.nextLine();

                        System.out.println("Please type the release date of the book:");
                        releaseDate = reader.nextLine();

                        System.out.println("Is the book part of a series? [Y/n]");
                        if (reader.nextLine().equals("Y")) {
                            isSeries = true;
                        }
                        if (isSeries) {
                            System.out.println("What is the name of the series?");
                            seriesName = reader.nextLine();
                        }

                        System.out.println("Please type the number of pages of the book: ");
                        pages = reader.nextInt();

                        System.out.println("Please type the price of the Book in USD ");
                        price = reader.nextInt();

                       if (refNumber.length() >= 3 && isSeries) {
                            System.out.println("Book Added");
                            textStorage.addNewBookSeries(title, author,publisher, edition, genre,refNumber, releaseDate, pages, price, seriesName);
                        } else {
                            if (refNumber.length() >= 3) {
                                textStorage.addNewBook(title, author,publisher, edition, genre,refNumber, releaseDate, pages, price);
                            } else {
                                System.out.println("Referance number too short");
                            }
                        }
                        quit = true;
                        break;

                    case 2:
                        doNotUse = reader.nextLine();   //This grabs the previous input. Temp fix, please fix later.

                        System.out.println("Please type the title of the magazine: ");
                        title = reader.nextLine();

                        System.out.println("Please type the main editor/author of the magazine: ");
                        author = reader.nextLine();

                        System.out.println("Please type the publisher of the magazine: ");
                        publisher = reader.nextLine();

                        System.out.println("Please type the reference number of the magazine.");
                        System.out.println("This should be at least 3 characters long:");
                        refNumber = reader.nextLine();

                        System.out.println("Please type the release date of the magazine: ");
                        releaseDate = reader.nextLine();

                        System.out.println("Please type the number of pages of the magazine: ");
                        pages = reader.nextInt();

                        System.out.println("Please type the price of the magazine in USD ");
                        price = reader.nextInt();

                        if (refNumber.length() >= 3) {
                            textStorage.addNewMagazine(author, title, publisher, releaseDate, pages, price);
                        } else {
                            System.out.println("Ref number too short, magazine not added.");
                        }
                        quit = true;
                        break;

                    case 3:
                        doNotUse = reader.nextLine();   //This grabs the previous input. Temp fix, please fix later. //No >:(

                        System.out.println("Please type the title of the newspaper: ");
                        title = reader.nextLine();

                        System.out.println("Please type the editor/author of the newspaper: ");
                        author = reader.nextLine();

                        System.out.println("Please type the publisher of the newspaper: ");
                        publisher = reader.nextLine();

                        System.out.println("Please type the release date of the newspaper:");
                        releaseDate = reader.nextLine();

                        System.out.println("Please type the number of pages of the newspaper: ");
                        pages = reader.nextInt();

                        System.out.println("Please type the price of the newspaper in USD ");
                        price = reader.nextInt();

                        textStorage.addNewNewspaper(author, title, publisher, releaseDate, pages, price);
                        quit = true;
                        break;

                    case 4:
                        doNotUse = reader.nextLine();   //This grabs the previous input. Temp fix, please fix later.

                        System.out.println("Please type the title of the wiki: ");
                        title = reader.nextLine();

                        System.out.println("Please type the main author of the wiki: ");
                        author = reader.nextLine();

                        System.out.println("Please type the website of the wiki: ");
                        publisher = reader.nextLine();

                        System.out.println("Please type the release date of the wiki:");
                        releaseDate = reader.nextLine();

                        System.out.println("Please type the project for this wiki: ");
                        project = reader.nextLine();

                        textStorage.addNewWiki(project, author, title, publisher, releaseDate);
                        quit = true;
                        break;

                    case 5:
                        System.out.println("All the pre-generated books has been added");
                        textStorage.addPremadeBooks();
                        quit = true;
                        break;

                    default:
                        System.out.println("Please input a valid numeral");
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nERROR: Please provide a number between 1 and X..\n");
            }
        }
    }

    /**
     * Find and display a product based om name (title).
     * As with the addNewProduct()-method, you have to
     * ask the user for the string (name/title/publisher)
     * to search for, and then use this string as input-
     * parameter to the method in the register-object.
     * Then, upon return from the register, you need
     * to print the details of the found item.
     */
    private void findProductByName() throws InputMismatchException {
        System.out.println("What kind of product are you looking for?\n");
        System.out.println("1. Book");

        int numberOfProducts = 1;
        Scanner reader = new Scanner(System.in);

        boolean quit = false;

        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > numberOfProducts)) {
            throw new InputMismatchException();
        }

        while (!quit) {
            try {
                switch (menuSelection) {
                    case 1:
                        String author = reader.nextLine();
                        System.out.println("What is the authors name? This search is case sensitive:");
                        System.out.println(textStorage.getTextByAuthor(author));
                        quit = true;
                        break;

                    default:
                        System.out.println("That isn't a choice.");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nERROR: Please provide a number between 1 and X..\n");
            }
        }
    }
}
