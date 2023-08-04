package com.java.reflection.coding_exercises.section05_testing_framework.example_input_class;

/**
 * Represents a test suite for testing the PaymentService
 */
public class PaymentServiceTest {

    private PaymentService service;

    public static void beforeClass() {
        // Called in the beginning of the test suite only once
        // Used for all tests need to share computationally expensive setup
    }

    public static void afterClass() {
        // Called once in the end of the entire test suite
        // Used for closing and cleaning up common resources
    }

    public void setupTest() {
        // Called before every test
        // Used for setting up resource before every test
    }

    public void testCreditCardPayment() {
        // Test case 1
    }

    public void testWireTransfer() {
        // Test case 2
    }

    public void testInsufficientFunds() {
        // Test case 3
    }

}
