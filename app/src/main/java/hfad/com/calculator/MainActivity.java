package hfad.com.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // populate spinner

        String [] items = {"Lagos"," Outside Lagos","Pickup"};
        // create adapter
        // grab the views

        Spinner dropDown = findViewById(R.id.delivery);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,items);
        dropDown.setAdapter(adapter);



    }

    public void calculateButton(View view){

        // grab views
        TextView calculate = (TextView)findViewById(R.id.calculate_view);
        EditText numCards = (EditText) findViewById(R.id.card);
        EditText numMpos = (EditText) findViewById(R.id.mpos);
        Spinner delivery = (Spinner) findViewById(R.id.delivery);

        int numOfCards = Integer.parseInt(numCards.getText().toString().trim());
        int numOfMpos = Integer.parseInt(numMpos.getText().toString().trim());
        String deliveryHandler = String.valueOf(delivery.getSelectedItem());


        // cards
        double cards = 268.75;
        double mpos = 21500.00;
        double total, totalCards, totalMpos;

        totalCards = numOfCards * cards;
        totalMpos = numOfMpos * mpos;
        total = totalCards + totalMpos;

        if (deliveryHandler.equals("Lagos")){
            total = total + 1500;
        }else if (deliveryHandler.equals("Pickup")){
            total = total + 0;
        }else {
            total =  total + 3500;
        }

        calculate.setText(String.format("%,.2f", total));
    }


    public void accountDetailsButton(View view) {

        String ACCOUNT_MESSAGE = "Ajocard Limited \n Sterling Bank \n 0071499795\n\n";

        // share account details
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(intent.EXTRA_TEXT, ACCOUNT_MESSAGE);
        startActivity(intent);
    }

    public void formButton(View view) {

        String FORM_MESSAGE = "https://docs.google.com/forms/d/e/1FAIpQLSce8pBS_h-RYykM_ALtxVFZ2ryHtfcoz472eEdSYiewU4kJFQ/viewform?usp=sf_link";

        // share account details
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(intent.EXTRA_TEXT, FORM_MESSAGE);
        startActivity(intent);
    }
}