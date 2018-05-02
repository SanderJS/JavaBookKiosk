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

    private LiteratureStorage literatureStorage;

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
        this.literatureStorage = new LiteratureStorage();
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
                        //Lists all of the products stored.
                        this.listAllProducts();
                        break;

                    case 2:
                        //Lets the user input a new product.
                        this.addNewProduct();
                        break;

                    case 3:
                        //Lets the user search up a text by name.
                        this.findProductByName();
                        break;

                    case 4:
                        //Exits the loop and ends the program.
                        System.out.println("\nThank you for using Application v0.1. Bye!\n");
                        quit = true;
                        break;

                    default:
                        //If the user inputs something else than a numeral.
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
        if (this.literatureStorage.listSize() > 0) {
            System.out.println(literatureStorage.listAllTexts());
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

                        //Takes the terminal input and defines the title as string.
                        System.out.println("Please type the title of the book: ");
                        title = reader.nextLine();

                        //Takes the terminal input and defines the author as string.
                        System.out.println("Please type the author of the book: ");
                        author = reader.nextLine();

                        //Takes the terminal input and defines the publisher as string.
                        System.out.println("Please type the publisher of the book: ");
                        publisher = reader.nextLine();

                        //Takes the terminal input and defines the edition as string.
                        System.out.println("Please type the edition of the book: ");
                        edition = reader.nextLine();

                        //Takes the terminal input and defines the reference number as string, but must be more than 2 characters.
                        System.out.println("Please type the reference number of the book");
                        System.out.println("This should be at least 3 characters long:");
                        refNumber = reader.nextLine();
                        if (refNumber.length() < 3) {
                            System.out.println("This book will fail due to user error. Not Sorry.");
                        }

                        //Takes the terminal input and defines the genre as string.
                        System.out.println("Please type the genre of the book: ");
                        genre = reader.nextLine();

                        //Takes the terminal input and defines the release date as string.
                        System.out.println("Please type the release date of the book:");
                        releaseDate = reader.nextLine();

                        //Takes the terminal input and defines what object it belongs to.
                        System.out.println("Is the book part of a series? [Y/n]");
                        if (reader.nextLine().equals("Y")) {
                            isSeries = true;
                        }
                        //Takes the terminal input and defines the name of the series as string.
                        if (isSeries) {
                            System.out.println("What is the name of the series?");
                            seriesName = reader.nextLine();
                        }

                        //Takes the terminal input and defines the number of pages as int.
                        System.out.println("Please type the number of pages of the book: ");
                        pages = reader.nextInt();

                        //Takes the terminal input and defines the price as int.
                        System.out.println("Please type the price of the Book in USD ");
                        price = reader.nextInt();

                        //Adds the book to the storage if all fields are valid.
                       if (refNumber.length() >= 3 && isSeries) {
                            System.out.println("Book Added");
                            literatureStorage.addText(new BookSeries(title, author,publisher, edition, genre,refNumber, releaseDate, pages, price, seriesName));
                        } else {
                            if (refNumber.length() >= 3) {
                                literatureStorage.addText(new Book(title, author,publisher, edition, genre,refNumber, releaseDate, pages, price));
                            } else {
                                System.out.println("Reference number too short");
                            }
                        }
                        quit = true;
                        break;

                    case 2:
                        doNotUse = reader.nextLine();   //This grabs the previous input. Temp fix, please fix later.

                        //Takes the terminal input and defines the title as string.
                        System.out.println("Please type the title of the magazine: ");
                        title = reader.nextLine();

                        //Takes the terminal input and defines the author as string.
                        System.out.println("Please type the main editor/author of the magazine: ");
                        author = reader.nextLine();

                        //Takes the terminal input and defines the publisher as string.
                        System.out.println("Please type the publisher of the magazine: ");
                        publisher = reader.nextLine();

                        //Takes the terminal input and defines the reference number as string, but must be more than 2 characters.
                        System.out.println("Please type the reference number of the magazine.");
                        System.out.println("This should be at least 3 characters long:");
                        refNumber = reader.nextLine();

                        //Takes the terminal input and defines the release date as string.
                        System.out.println("Please type the release date of the magazine: ");
                        releaseDate = reader.nextLine();

                        //Takes the terminal input and defines the number of pages as int.
                        System.out.println("Please type the number of pages of the magazine: ");
                        pages = reader.nextInt();

                        //Takes the terminal input and defines the price as int.
                        System.out.println("Please type the price of the magazine in USD ");
                        price = reader.nextInt();

                        //Adds the magazine to the storage if all fields are valid.
                        if (refNumber.length() >= 3) {
                            literatureStorage.addText(new Magazine(title, publisher, releaseDate, pages, price));
                        } else {
                            System.out.println("Ref number too short, magazine not added.");
                        }
                        quit = true;
                        break;

                    case 3:
                        doNotUse = reader.nextLine();   //This grabs the previous input. Temp fix, please fix later. //No >:(

                        //Takes the terminal input and defines the title as string.
                        System.out.println("Please type the title of the newspaper: ");
                        title = reader.nextLine();

                        //Takes the terminal input and defines the editor as string.
                        System.out.println("Please type the editor/author of the newspaper: ");
                        author = reader.nextLine();

                        //Takes the terminal input and defines the publisher as string.
                        System.out.println("Please type the publisher of the newspaper: ");
                        publisher = reader.nextLine();

                        //Takes the terminal input and defines the release date as string.
                        System.out.println("Please type the release date of the newspaper:");
                        releaseDate = reader.nextLine();

                        //Takes the terminal input and defines the number of pages as int.
                        System.out.println("Please type the number of pages of the newspaper: ");
                        pages = reader.nextInt();

                        //Takes the terminal input and defines the price as int.
                        System.out.println("Please type the price of the newspaper in USD ");
                        price = reader.nextInt();

                        //Adds the newspaper to the storage if all fields are valid.
                        literatureStorage.addText(new Newspaper(title, publisher, releaseDate, pages, price));
                        quit = true;
                        break;

                    case 4:
                        doNotUse = reader.nextLine();   //This grabs the previous input. Temp fix, please fix later. // Might have to be like this, don't touch.

                        //Takes the terminal input and defines the title as string.
                        System.out.println("Please type the title of the wiki: ");
                        title = reader.nextLine();

                        //Takes the terminal input and defines the main author as string.
                        System.out.println("Please type the main author of the wiki: ");
                        author = reader.nextLine();

                        //Takes the terminal input and defines the publishing site as string.
                        System.out.println("Please type the website of the wiki: ");
                        publisher = reader.nextLine();

                        //Takes the terminal input and defines the release date as string.
                        System.out.println("Please type the release date of the wiki:");
                        releaseDate = reader.nextLine();

                        //Takes the terminal input and defines the wiki project name as string.
                        System.out.println("Please type the project for this wiki: ");
                        project = reader.nextLine();

                        //Adds the newspaper to the storage.
                        //literatureStorage.addText(new Wiki(project, author, title, publisher, releaseDate));
                        quit = true;
                        break;

                    case 5:
                        //Adds the pre-generated books to the storage.
                        System.out.println("All the pre-generated books has been added");
                        literatureStorage.addPremadeBooks();
                        quit = true;
                        break;

                    default:
                        System.out.println("Please input a valid numeral");
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nERROR: Please provide a number between 1 and" + numberOfProducts + "\n");
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
        //Shows the user the options he has.
        System.out.println("What do you want to search for?\n");
        System.out.println("1: Book\n");
        System.out.println("2: Magazine\n");
        System.out.println("3: Newspaper\n");
        System.out.println("4: Wiki\n");
        System.out.println("5: Author");
        System.out.println();

        //
        int numberOfOptions = 1;
        Scanner reader = new Scanner(System.in);

        boolean quit = false;

        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > numberOfOptions)) {
            throw new InputMismatchException();
        }

        while (!quit) {
            try {
                switch (menuSelection) {
                    case 1:
                        //Searches for the author defined by the user.
                        String author = reader.nextLine();
                        System.out.println("What is the authors name? This search is case sensitive:");
                        System.out.println(literatureStorage.getTextByAuthor(author));
                        quit = true;
                        break;

                    default:
                        System.out.println("That isn't a choice.");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nERROR: Please provide a number between 1 and " + numberOfOptions + "\n");
            }
        }
    }
}
