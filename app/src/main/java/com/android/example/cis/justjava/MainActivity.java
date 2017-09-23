package com.android.example.cis.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int numberOfCoffices = 0;

    String whippedCream = "Don't Add Whipped Cream";

    String chocolate = "Don't Add Chocolate";

    EditText nameText;

    double extrsCho = 0;

    double extrsWhip = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void incQTY(View view) {

        numberOfCoffices = numberOfCoffices + 1;

        displayQuantity(numberOfCoffices);

    }

    public void decQTY(View view) {

        numberOfCoffices = numberOfCoffices - 1;

        displayQuantity(numberOfCoffices);

    }


    public void submitOrder(View view) {

        nameText = (EditText) findViewById(R.id.nameTextView);

        displayPrice();

    }

    private void displayPrice() {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.orderSummary_text_view);

        String text = orderSummary() + "\nTotal: $" + calPrice() + "\nThank you!";

        orderSummaryTextView.setText(text);

    }

    private double calPrice() {

        return numberOfCoffices * (5 + extrsWhip + extrsCho);
    }


    private void displayQuantity(int i) {
        TextView qty = (TextView) findViewById(R.id.quantiyt_text_view);
        qty.setText(i + "");
    }


    private String orderSummary() {
        return "Name : " + nameText.getText().toString() + "\n" + whippedCream + "\n" + chocolate + "\nQuantity : " + numberOfCoffices;
    }

    public void yesOrNo(View view) {

        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox1);

        if (checkBox.isChecked()) {

            whippedCream = "Add Whipped Cream";
            extrsWhip = 1;

        } else {

            whippedCream = "Don't Add Whipped Cream";
            extrsWhip = 0;


        }


    }

    public void yesOrNoCho(View view) {

        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox2);

        if (checkBox.isChecked()) {

            chocolate = "Add Chocolate";
            extrsCho = 2;


        } else {

            chocolate = "Don't Add Chocolate";
            extrsCho = 0;


        }
    }
}
