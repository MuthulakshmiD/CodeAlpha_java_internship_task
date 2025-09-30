import java.util.*;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Portfolio {
    Map<String, Integer> holdings = new HashMap<>();
    double balance;

    Portfolio(double balance) {
        this.balance = balance;
    }

    void buy(Stock stock, int qty) {
        double cost = stock.price * qty;
        if (balance >= cost) {
            holdings.put(stock.name, holdings.getOrDefault(stock.name, 0) + qty);
            balance -= cost;
            System.out.println("Bought " + qty + " shares of " + stock.name);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void sell(Stock stock, int qty) {
        if (holdings.getOrDefault(stock.name, 0) >= qty) {
            holdings.put(stock.name, holdings.get(stock.name) - qty);
            balance += stock.price * qty;
            System.out.println("Sold " + qty + " shares of " + stock.name);
        } else {
            System.out.println("Not enough shares to sell!");
        }
    }

    void viewPortfolio() {
        System.out.println("Balance: $" + balance);
        System.out.println("Holdings: " + holdings);
    }
}

public class StockTrading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stock apple = new Stock("AAPL", 150.0);
        Stock google = new Stock("GOOGL", 2800.0);

        Portfolio portfolio = new Portfolio(10000.0);

        while (true) {
            System.out.println("\n1. Buy 2. Sell 3. View Portfolio 4. Exit");
            int choice = sc.nextInt();
            if (choice == 4) break;

            System.out.println("Select Stock: 1. AAPL 2. GOOGL");
            int stockChoice = sc.nextInt();
            Stock selectedStock = (stockChoice == 1) ? apple : google;

            if (choice == 1) {
                System.out.println("Quantity to buy:");
                int qty = sc.nextInt();
                portfolio.buy(selectedStock, qty);
            } else if (choice == 2) {
                System.out.println("Quantity to sell:");
                int qty = sc.nextInt();
                portfolio.sell(selectedStock, qty);
            } else if (choice == 3) {
                portfolio.viewPortfolio();
            }
        }

        sc.close();
        System.out.println("Exiting Stock Trading Platform.");
    }
}
