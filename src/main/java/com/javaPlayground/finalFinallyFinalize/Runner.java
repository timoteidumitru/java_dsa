package com.javaPlayground.finalFinallyFinalize;

public class Runner {
    // final example -> cannot be reassigned
    private final int value = 10;
//    value = 20; -> value cannot be reinitialized if its declared as final

    // finally -> found in a try/catch/finally block code
    public void testMethod() {
        try {
            System.out.println("Try block gets executed.");
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Finally block gets executed regardless of either try or catch gets executed");
        }
    }

    // finalize -> used by garbage collector to clean up unused objects
    public static void main(String[] args) {
        Runner obj = new Runner();
        obj.testMethod();
        obj= null;
        System.gc();
    }

    @Override
    protected void finalize(){
        System.out.println("Finalize method gets called to destroy/remove unused objects");
    }
}
