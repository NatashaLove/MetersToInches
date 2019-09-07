package com.example.meterstoinches;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
    1m=39.3701 in
    */
//creating objects of the widgets (created in design):
    private EditText enterMeters;
    private Button convertButton;
    private EditText enterInches;
    private Button convertButton2;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //attaching the object to the widget by id:
        enterMeters=(EditText) findViewById(R.id.editMetersTextID);//(EditText) - casting to the correct obj type
        enterInches=(EditText) findViewById(R.id.editMetersTextID2);//(EditText) - casting to the correct obj type
        resultTextView= (TextView) findViewById(R.id.resultID);
        convertButton=(Button) findViewById(R.id.convertButtonID);
        convertButton2=(Button) findViewById(R.id.convertButtonID2);
//adding method to the button - onClick- event-handler (after clicking should convert number from text editor into number in text view)
        //creating object onclicklistener with method
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //conversion logic
                double multiplier=39.37;
                double result = 0.0;

//using .equals - method, because enterMeters is an object, can't use ==:
                //also MUST convert toString! otherwise won't see empty "" string! and won't show error, but close app!
                if (enterMeters.getText().toString().equals("")){

                    resultTextView.setText(R.string.error_message);
                    resultTextView.setTextColor(Color.RED);
                }else{

                    //to convert text string from editText into double: use method for Double- .parseDouble--
//it takes string as a parameter - but need to get that string with help of getText method and (in case there are numbers)-
//need to convert toString the text entered by the user..
//then the Double method works with the returned String:
                    double meterValue = Double.parseDouble(enterMeters.getText().toString());

                    result= meterValue*multiplier;

                    //to display:
                /*
                1.
                resultTextView.setText(Double.toString(result)+ " inches");//can't put "result" itself,because it's double type-
                //need to convert double -toString.

                2. variant below is better- method String.format - it's shorter and helps to reduce the amount of decimals:

                 */
                    //parameter "%.2f" - syntax from c++ - tells to the method to convert the "result" to 2 decimal points
                    //and return String
                    resultTextView.setTextColor(Color.rgb(33,150,243));
                    resultTextView.setText(String.format("%.2f", result)+" inches");
                }




            }
        });
        convertButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {

                //conversion logic
                double factor=39.37;
                double result = 0.0;

//using .equals - method, because enterMeters is an object, can't use ==:
                //also MUST convert toString! otherwise won't see empty "" string! and won't show error, but close app!
                if (enterInches.getText().toString().equals("")){

                    resultTextView.setText(R.string.error_message);
                    resultTextView.setTextColor(Color.RED);
                }else{

                    //to convert text string from editText into double: use method for Double- .parseDouble--
//it takes string as a parameter - but need to get that string with help of getText method and (in case there are numbers)-
//need to convert toString the text entered by the user..
//then the Double method works with the returned String:
                    double inchesValue = Double.parseDouble(enterInches.getText().toString());

                    result= inchesValue/factor;

                    //to display:
                /*
                1.
                resultTextView.setText(Double.toString(result)+ " inches");//can't put "result" itself,because it's double type-
                //need to convert double -toString.

                2. variant below is better- method String.format - it's shorter and helps to reduce the amount of decimals:

                 */
                    //parameter "%.2f" - syntax from c++ - tells to the method to convert the "result" to 2 decimal points
                    //and return String
                    resultTextView.setTextColor(Color.rgb(33,150,243));
                    resultTextView.setText(String.format("%.2f", result)+" meters");
                }




            }
        });
    }
}
