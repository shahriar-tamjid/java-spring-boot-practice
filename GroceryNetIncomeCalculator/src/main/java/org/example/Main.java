package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);

        // ----- Sales Data -----
        System.out.println("--- Sales Data ---");

        System.out.print("Enter selling price per kg of Potato: ");
        double potatoSellPrice = input.nextDouble();
        System.out.print("Enter kg of Potato sold: ");
        double potatoSoldQty = input.nextDouble();

        System.out.print("Enter selling price per kg of Onion: ");
        double onionSellPrice = input.nextDouble();
        System.out.print("Enter kg of Onion sold: ");
        double onionSoldQty = input.nextDouble();

        System.out.print("Enter selling price per liter of Oil: ");
        double oilSellPrice = input.nextDouble();
        System.out.print("Enter liters of Oil sold: ");
        double oilSoldQty = input.nextDouble();

        double potatoRevenue = potatoSellPrice * potatoSoldQty;
        double onionRevenue = onionSellPrice * onionSoldQty;
        double oilRevenue = oilSellPrice * oilSoldQty;
        double totalSoldPrice = potatoRevenue + onionRevenue + oilRevenue;

        System.out.println("\n--- Revenue ---");
        System.out.println("Potato Revenue: " + potatoRevenue);
        System.out.println("Onion Revenue: " + onionRevenue);
        System.out.println("Oil Revenue: " + oilRevenue);
        System.out.println("Total Sold Price (Revenue): " + totalSoldPrice);

        // ----- Cost Data -----
        System.out.println("\n--- Cost Data ---");

        System.out.print("Enter purchasing price per kg of Potato: ");
        double potatoBuyPrice = input.nextDouble();
        System.out.print("Enter kg of Potato purchased: ");
        double potatoBoughtQty = input.nextDouble();

        System.out.print("Enter purchasing price per kg of Onion: ");
        double onionBuyPrice = input.nextDouble();
        System.out.print("Enter kg of Onion purchased: ");
        double onionBoughtQty = input.nextDouble();

        System.out.print("Enter purchasing price per liter of Oil: ");
        double oilBuyPrice = input.nextDouble();
        System.out.print("Enter liters of Oil purchased: ");
        double oilBoughtQty = input.nextDouble();

        System.out.print("Enter total transportation cost: ");
        double transportationCost = input.nextDouble();

        double potatoCost = potatoBuyPrice * potatoBoughtQty;
        double onionCost = onionBuyPrice * onionBoughtQty;
        double oilCost = oilBuyPrice * oilBoughtQty;
        double totalPurchaseCost = potatoCost + onionCost + oilCost;

        System.out.println("\n--- Purchase Costs ---");
        System.out.println("Potato Purchase Cost: " + potatoCost);
        System.out.println("Onion Purchase Cost: " + onionCost);
        System.out.println("Oil Purchase Cost: " + oilCost);
        System.out.println("Total Purchase Cost (COGS): " + totalPurchaseCost);
        System.out.println("Transportation Cost: " + transportationCost);

        double netIncome = totalSoldPrice - (totalPurchaseCost + transportationCost);

        System.out.println("\n--- Final Result ---");
        System.out.println("Net Income: " + netIncome);

        input.close();
    }
}