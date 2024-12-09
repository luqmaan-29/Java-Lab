class CIA2B {
    public static void main(String[] args) {
         
    Thread chef = new Thread(new Cook());
    Thread waiter = new Thread(new Serve());
    
    chef.start(); 
    waiter.start(); 
   }
   }
   
   class Cook implements Runnable {
    private int order = 1;
   
    public void run() {
   try {
           for (int i = 0; i < 10; i++) {
               System.out.println("Chef adding: " + order++);
        Thread.sleep(1000); 
       } 
   } catch (InterruptedException e) {
        System.out.println("Cook was stopped");
   }
   }
   }
   
   class Serve implements Runnable {
   
    public void run() {
   try {
        for (int i = 0; i < 10; i++) {
           System.out.println("Waiter serving: " + (i + 1));
             Thread.sleep(1500);
    }
   } catch (InterruptedException e){
   System.out.println("Waiter was stopped");
   }
   }
   }
   