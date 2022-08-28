//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: The class tests method in ExceptionalShoppingCart
// Course: CS 300 Spring 2022
//
// Author: Pranav Sharma
// Email: pnsharma@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: n/a
// Online Sources: n/a
//
///////////////////////////////////////////////////////////////////////////////
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * The class tests method in ExceptionalShoppingCart
 * 
 * @author pranav sharma
 */
public class ExceptionalShoppingCartTester {
  
  /**
   * The main method the class
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    runAllTests();
  }

  /**
   * runs all test methods
   * 
   * @return true if all tests are passed
   */
  public static boolean runAllTests() {
    System.out.println("testLookupMethods: " + testLookupMethods());
    System.out.println("testAddItemToMarketCatalog: " + testAddItemToMarketCatalog());
    System.out.println("testSaveCartSummary: " + testSaveCartSummary());
    System.out.println("testLoadCartSummary: " + testLoadCartSummary());
    return true;

  }

  /**
   * Tests both lookup methods in ExceptionalShoppingCart Class
   * 
   * @return true if all tests are passed
   */
  public static boolean testLookupMethods() {
    // test 1: tests testLookupById() when the key entered is not 4 digits
    boolean passed = false;
    try {
      int key = 55520;
      ExceptionalShoppingCart.lookupProductById(key);
      passed = false;
    } catch (IllegalArgumentException e) {
      passed = true;
    } catch (NoSuchElementException e) {
      passed = false;
    }
    if (passed == false) {
      System.out
          .println("Error: when testing testLookupById() when the key entered is not 4 digits");
      return false;
    }
    // test 2: tests testLookupById() when the key entered is not valid
    try {
      int key = 9998;
      ExceptionalShoppingCart.lookupProductById(key);
      passed = false;
    } catch (IllegalArgumentException e) {
      passed = false;
    } catch (NoSuchElementException e) {
      passed = true;
    }
    if (passed == false) {
      System.out.println("Error: when testing testLookupById() when the key entered is not valid ");
      return false;
    }
    // test 3: tests testLookupById() when they key entered is valid
    try {
      int key = 4131;
      ExceptionalShoppingCart.lookupProductById(key);
      passed = true;
    } catch (IllegalArgumentException e) {
      passed = false;
    } catch (NoSuchElementException e) {
      passed = false;
    }
    if (passed == false) {
      System.out.println("Error: when testing testLookupById() when the key entered is valid ");
      return false;
    }

    // test 4: tests testLookupByName() when no match is found
    try {
      String item = "Lemonade";
      ExceptionalShoppingCart.lookupProductByName(item);
      passed = false;
    } catch (NoSuchElementException e) {
      passed = true;
    }
    if (passed == false) {
      System.out
          .println("Error: when testing testLookupByName() when the item found is not found ");
      return false;
    }

    // test 5: tests testLookupByName() when match is found
    try {
      String item = "Carrot";
      ExceptionalShoppingCart.lookupProductByName(item);
      passed = true;
    } catch (NoSuchElementException e) {
      passed = false;
    }
    if (passed == false) {
      System.out.println("Error: when testing testLookupByName() when the item is found  ");
      return false;
    }
    // return true if all tests pass
    return true;
  }

  /**
   * Tests AddItemToMarketCatalog() method
   * 
   * @return true if all tests are passed
   */
  public static boolean testAddItemToMarketCatalog() {
    boolean passed = false;
    // test 1: tests testAddItemToMarketCatalog() when the id is not parsable
    try {
      String id = "17Y9";
      String item = "Pepsi";
      String price = "$5.00";
      ExceptionalShoppingCart.addItemToMarketCatalog(id, item, price);
      passed = false;
    } catch (IllegalArgumentException e) {
      passed = true;
    }
    if (passed == false) {
      System.out
          .println("Error: when testing testAddItemToMarketCatalog() when the id is not parsable");
      return false;
    }

    // test 2: tests testAddItemToMarketCatalog() when the name is null
    try {
      String id = "1729";
      String item = null;
      String price = "$5.00";
      ExceptionalShoppingCart.addItemToMarketCatalog(id, item, price);
      passed = false;
    } catch (IllegalArgumentException e) {
      passed = true;
    }
    if (passed == false) {
      System.out.println("Error: when testing testAddItemToMarketCatalog() when the name is null");
      return false;
    }

    // test 3: tests testAddItemToMarketCatalog() when the name is empty
    try {
      String id = "1729";
      String item = "";
      String price = "$5.00";
      ExceptionalShoppingCart.addItemToMarketCatalog(id, item, price);
      passed = false;
    } catch (IllegalArgumentException e) {
      passed = true;
    }
    if (passed == false) {
      System.out.println("Error: when testing testAddItemToMarketCatalog() when the name is empty");
      return false;
    }

    // test 4: tests testAddItemToMarketCatalog() when the first char of price is not '?'
    try {
      String id = "1729";
      String item = "";
      String price = "&5.00";
      ExceptionalShoppingCart.addItemToMarketCatalog(id, item, price);
      passed = false;
    } catch (IllegalArgumentException e) {
      passed = true;
    }
    if (passed == false) {
      System.out.println(
          "Error: when testing testAddItemToMarketCatalog() when the the first char of price "
              + "is not '?'");
      return false;
    }

    // test 5: tests testAddItemToMarketCatalog() when the price is under 0
    try {
      String id = "1729";
      String item = "Lemonade";
      String price = "$-5.00";
      ExceptionalShoppingCart.addItemToMarketCatalog(id, item, price);
      passed = false;
    } catch (IllegalArgumentException e) {
      passed = true;
    }
    if (passed == false) {
      System.out
          .println("Error: when testing testAddItemToMarketCatalog() when the price is under 0");
      return false;
    }

    // test 6: tests testAddItemToMarketCatalog() when inputs are valid
    try {
      String id = "1729";
      String item = "Lemonade";
      String price = "$5.00";
      ExceptionalShoppingCart.addItemToMarketCatalog(id, item, price);
      passed = true;
    } catch (IllegalArgumentException e) {
      passed = false;
    }
    if (passed == false) {
      System.out
          .println("Error: when testing testAddItemToMarketCatalog() when the price is under 0");
      return false;
    }


    return true;
  }

  /**
   * Tests SaveCartSummary() method
   * 
   * @return true if all tests are passed
   */
  public static boolean testSaveCartSummary() {
    boolean passed = false;
    // test 1: tests saveCartSummary() when size is less than 0
    try {
      String[] cart = new String[] {"Milk", "Carrot", null, null};
      int size = -3;
      File file = new File("input.txt");
      ExceptionalShoppingCart.saveCartSummary(cart, size, file);
      passed = false;
    } catch (IllegalArgumentException e) {
      passed = true;
    }
    if (passed == false) {
      System.out.println("Error: when testing saveCartSummary() when size is less than 0");
      return false;
    }

    // test 2: tests saveCartSummary() with correct inputs
    try {
      String[] cart = new String[] {"Milk", "Carrot", null, null};
      int size = 2;
      File file = new File("input.txt");
      ExceptionalShoppingCart.saveCartSummary(cart, size, file);
      passed = true;
    } catch (IllegalArgumentException e) {
      passed = false;
    }
    if (passed == false) {
      System.out.println("Error: when testing saveCartSummary() with correct inputs");
      return false;
    }

    return true;
  }

  /**
   * Tests LoadCartSummary() method
   * 
   * @return true if all tests are passed
   */
  public static boolean testLoadCartSummary() {
    boolean passed = false;
    // test 1: tests LoadCartSummary() when some lines in the file are unreadable
    try {
      String[] cart = new String[] {"Carrot", null, null, null, null, null, null, null, null, null};
      int size = 1;
      int expectedSize = 8;
      File file = new File("input.txt");
      String input = "( 2 ) Apple\r\n" + "( 1 ) Milk\r\n" + "( 2 ) \r\n" + "( one ) Chocolate\r\n"
          + "( 3 ) Pizza\r\n" + "( 1 ) Unknown\r\n" + "( 1 ) Grape";
      FileWriter writer = new FileWriter(file);
      writer.write(input);
      writer.close();
      if (ExceptionalShoppingCart.loadCartSummary(file, cart, size) == expectedSize) {
        passed = true;
      } else {
        passed = false;
      }
    } catch (IllegalArgumentException e) {
      passed = false;
    } catch (IllegalStateException e) {
      passed = false;
    } catch (IOException e) {
      passed = false;
    }
    if (passed == false) {
      System.out
          .println("Error: when LoadCartSummary() when some lines in the file are unreadable");
      return false;
    }

    // test 2: tests LoadCartSummary() when all lines in the file are readable
    try {
      String[] cart = new String[] {"Carrot", null, null, null, null, null, null, null, null, null};
      int size = 1;
      int expectedSize = 4;
      File file = new File("input.txt");
      String input = "( 2 ) Apple\r\n" + "( 1 ) Milk\r\n";
      FileWriter writer = new FileWriter(file);
      writer.write(input);
      writer.close();
      if (ExceptionalShoppingCart.loadCartSummary(file, cart, size) == expectedSize) {
        passed = true;
      } else {
        passed = false;
      }
    } catch (IllegalArgumentException e) {
      passed = false;
    } catch (IllegalStateException e) {
      passed = false;
    } catch (IOException e) {
      passed = false;
    }
    if (passed == false) {
      System.out.println("Error: when LoadCartSummary() when all lines in the file are readable");
      return false;
    }
    
    // test 3: tests LoadCartSummary() when the cart becomes full
    try {
      String[] cart = new String[] {"Carrot", null, null};
      int size = 1;
      int expectedSize = 4;
      File file = new File("input.txt");
      String input = "( 2 ) Apple\r\n" + "( 1 ) Milk\r\n";
      FileWriter writer = new FileWriter(file);
      writer.write(input);
      writer.close();
      if (ExceptionalShoppingCart.loadCartSummary(file, cart, size) == expectedSize) {
        passed = false;
      } else {
        passed = false;
      }
    } catch (IllegalArgumentException e) {
      passed = false;
    } catch (IllegalStateException e) {
      passed = true;
    } catch (IOException e) {
      passed = false;
    }
    if (passed == false) {
      System.out.println("Error: when LoadCartSummary() when the cart is full");
      return false;
    }
    return true;
  }
}
