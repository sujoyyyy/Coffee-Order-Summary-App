package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        boolean isCheckedWhip = ((CheckBox) findViewById(R.id.check_whip_cream)).isChecked();
        boolean isCheckedChoc = ((CheckBox) findViewById(R.id.check_chocolate)).isChecked();
        EditText name = (EditText) findViewById(R.id.plain_text_input);
        double price= quantity*5;
        if(isCheckedWhip)
        {
            price=price+2*quantity;
        }
        if (isCheckedChoc)
            price = price+2.5*quantity;
        String priceMessage = "Name : "+name.getText().toString()+"\nAdded whip cream? "+isCheckedWhip+"\nAdded Chocolate? "+isCheckedChoc+"\nQuantity : "+quantity+"\nTotal : $"+price+"\n\n\nThank you";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL,"sujoydatta.2009@gmail.com"); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee order for "+name.getText().toString()+".");
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        quantity--;
        if (quantity < 0) {
            quantity = 0;
        }
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */


}