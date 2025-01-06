import java.util.ArrayList;
import java.util.List;

// CoffeeCounter simulates the shared counter for coffee storage
class CoffeeCounter {
    private List<String> counter = new ArrayList<>();
    private final int capacity;

    // Constructor initializes the capacity of the counter
    public CoffeeCounter(int capacity) {
        this.capacity = capacity;
    }

    // Method to add coffee to the counter (Barista's task)
    public synchronized void addCoffee(String coffee) {
        while (counter.size() >= capacity) { // If counter is full, wait
            try {
                System.out.println("Barista is waiting. Counter is full.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter.add(coffee); // Add the coffee to the counter
        System.out.println("Barista prepared coffee. Counter: " + counter.size());
        notifyAll(); // Notify others that a coffee has been added
    }

    // Method for customers to pick up coffee
    public synchronized void pickCoffee(String consumer) {
        while (counter.isEmpty()) { // If the counter is empty, wait
            try {
                System.out.println(consumer + " is waiting. Counter is empty.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter.remove(0); // Customer picks a coffee
        System.out.println(consumer + " picked up coffee. Counter: " + counter.size());
        notifyAll(); // Notify others that a coffee has been taken
    }

    // Method for the reviewer to sample coffee
    public synchronized void sampleCoffee() {
        while (counter.isEmpty()) { // If the counter is empty, wait
            try {
                System.out.println("Reviewer is waiting. Counter is empty.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter.remove(0); // Reviewer samples the coffee
        System.out.println("Reviewer sampled coffee. Counter: " + counter.size());
        notifyAll(); // Notify others that the coffee has been sampled
    }
}

// Barista class prepares coffee and adds it to the counter
class Barista implements Runnable {
    private final CoffeeCounter counter;
    private final int coffeeCount;

    // Constructor initializes the CoffeeCounter and number of coffees to prepare
    public Barista(CoffeeCounter counter, int coffeeCount) {
        this.counter = counter;
        this.coffeeCount = coffeeCount;
    }

    @Override
    public void run() {
        // Barista prepares coffee
        for (int i = 0; i < coffeeCount; i++) {
            try {
                Thread.sleep(500); // Simulate time to prepare coffee
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter.addCoffee("Coffee"); // Add prepared coffee to the counter
        }
    }
}

// Customer class picks up coffee from the counter
class Customer implements Runnable {
    private final CoffeeCounter counter;
    private final int coffeeCount;
    private final String name;

    // Constructor initializes the CoffeeCounter, coffee count, and customer name
    public Customer(CoffeeCounter counter, int coffeeCount, String name) {
        this.counter = counter;
        this.coffeeCount = coffeeCount;
        this.name = name;
    }

    @Override
    public void run() {
        // Customer picks coffee
        for (int i = 0; i < coffeeCount; i++) {
            try {
                Thread.sleep(500); // Simulate time to pick coffee
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter.pickCoffee(name); // Customer picks coffee from the counter
        }
    }
}

// CoffeeReviewer samples the coffee from the counter
class CoffeeReviewer implements Runnable {
    private final CoffeeCounter counter;

    // Constructor initializes the CoffeeCounter
    public CoffeeReviewer(CoffeeCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000); // Simulate time to sample coffee
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counter.sampleCoffee(); // Reviewer samples coffee
    }
}

// Main class to simulate the coffee-making process
public class Lab6b {
    public static void main(String[] args) {
        CoffeeCounter counter = new CoffeeCounter(3); // Initialize coffee counter with a capacity of 3

        // Create threads for baristas and customers
        Thread barista1 = new Thread(new Barista(counter, 2), "Barista 1");
        Thread barista2 = new Thread(new Barista(counter, 3), "Barista 2");

        Thread customer1 = new Thread(new Customer(counter, 1, "Customer 1"));
        Thread customer2 = new Thread(new Customer(counter, 2, "Customer 2"));
        Thread customer3 = new Thread(new Customer(counter, 1, "Customer 3"));

        Thread reviewer = new Thread(new CoffeeReviewer(counter), "Reviewer");

        // Start all threads
        barista1.start();
        barista2.start();
        customer1.start();
        customer2.start();
        customer3.start();
        reviewer.start();

        // Wait for all threads to complete
        try {
            barista1.join();
            barista2.join();
            customer1.join();
            customer2.join();
            customer3.join();
            reviewer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print simulation complete message
        System.out.println("Simulation complete.");
    }
}
