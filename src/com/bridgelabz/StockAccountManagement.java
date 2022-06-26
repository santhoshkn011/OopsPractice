/*
1. Stock Account Management
a. Desc -> Write a program to read in Stock Names, Number of Share, Share Price.
Print a Stock Report with the total value of each Stock and the total value of
Stock.
b. I/P -> N number of Stocks, for Each Stock Read In the Share Name, Number of
Share, and Share Price
c. Logic -> Calculate the value of each stock and the total value
d. O/P -> Print the Stock Report.
e. Hint -> Create Stock and Stock Portfolio Class holding the list of Stocks read
from the input file. Have functions in the Class to calculate the value of each
stock and the value of total stocks.
 */
package com.bridgelabz; // package
import java.util.Scanner;  //Importing Scanner
import java.util.Formatter; //importing formatter

public class StockAccountManagement {
    //main method
    public static void main(String[] args) {
        StockDetails myStocks = new StockDetails(); //Created an Object for class StockDetails
        myStocks.totalStocks(); //calling method
    }
}
//StockDetails class
class StockDetails {
    //declaring variables
    static int noOfStocks;
    static int totalStockValue;
    //method
    public void totalStocks() {
        System.out.printf("The total number of stocks: ");
        Scanner sc = new Scanner(System.in);
        noOfStocks = sc.nextInt();
        //Array declaration
        int shareValue[] = new int[noOfStocks];
        int noOfShares[] = new int[noOfStocks];
        int stockPrice[] = new int[noOfStocks];
        String stockName[] = new String[noOfStocks];
        //assigning the elements in the array
        for (int i = 0; i < noOfStocks; i++) {
            System.out.print("Enter the Stock Name: ");
            stockName[i] = sc.next();
            System.out.print("Enter number of " + stockName[i] + " shares: ");
            noOfShares[i] = sc.nextInt();
            System.out.print("Enter " + stockName[i] + " Share Price: ");
            shareValue[i] = sc.nextInt();
            stockPrice[i] = noOfShares[i] * shareValue[i];
            totalStockValue += stockPrice[i]; //Adding to total stock value in the portfolio.
            System.out.println();
        }
        //Using Java Formatter Class to print the date in tabular form
        Formatter row1 = new Formatter(); //creating the objects for formatter class.
        Formatter row2 = new Formatter();
        System.out.println("---------------------------------------------------------------------");
        row1.format("%15s %15s %15s %15s", "Stock Name", "No Of Shares", "Share Price", "Stock Price");
        System.out.println(row1); //printing row1
        System.out.println("---------------------------------------------------------------------");
        for (int i = 0; i < noOfStocks; i++){
            row2.format("%14s %10s %16s %15s\n", stockName[i], noOfShares[i], shareValue[i], stockPrice[i]);
        }
        System.out.println(row2);//printing row2
        System.out.println("---------------------------------------------------------------------\n");
        System.out.println("Total value of your Stocks: " + totalStockValue); //printing total portfolio value
    }
}