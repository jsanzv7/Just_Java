/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int numberOfCoffees = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        numberOfCoffees=numberOfCoffees+1;
        displayQuantity(numberOfCoffees);
            }
    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        numberOfCoffees=numberOfCoffees-1;
        displayQuantity(numberOfCoffees);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        displayPriceMessage(createOrderSummary(price));

    }

    /**
     * Calculates the price of the order.
     * @return returning the total price
     */
    private int calculatePrice() {
        int price = numberOfCoffees * 5;
        return price;
    }

    private String createOrderSummary(int price) {
        String priceMessage = "Name: Juan Sanz";
        priceMessage += "\nQuantity: " + numberOfCoffees;
        priceMessage += "\nTotal:$"+ price;
        priceMessage += "\nThank You!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPriceMessage(String message) {
        TextView orderSummaryTextView= (TextView) findViewById(
                R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}