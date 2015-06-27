package com.thenewboston.allison;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Layout
        RelativeLayout buckysLayout = new RelativeLayout(this); //Create Layout
        buckysLayout.setBackgroundColor(Color.GREEN); //set background green

        //Button
        Button redButton = new Button(this);  //Create Button
        redButton.setText("Log In");
        redButton.setBackgroundColor(Color.RED); //set button red

        //Username input
        EditText username = new EditText(this);
            //Set ID to button in order to reference it later on
            redButton.setId(1);
            //Set ID to username-input in order to reference it later on
            username.setId(2);

            //Positioning the widgets(the red button)
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams ( //Set container, put button in container
            RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL); //Center Button horizontally
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);   //Center Button vertically


            //Positioning the username-input(the red button)
        RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams ( //Set container, put button in container
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

                 //Give rules to position widgets
                 usernameDetails.addRule(RelativeLayout.ABOVE, redButton.getId()); //position username-input (ABOVE, red Button)
                 usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL); //center username-input horizontally
        usernameDetails.setMargins(0,0,0,50); //position button a little bit above "red button" with some margin space (left,top,right,bottom) as per usual

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL); //Center Button horizontally
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);   //Center Button vertically


        //convert DIP to pixels. once you have the px value you can pass it into username.setWidth so it would be the same size on every single device
        Resources r = getResources(); //getResources essentially gets a bunch of info about your app
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, //converrt DIP to pixels (convert DIPs, [how many DIPS:) 200,
            r.getDisplayMetrics()
        );

        username.setWidth(px);

        //Add Widgets to Layout
        buckysLayout.addView(redButton, buttonDetails); //add Button to Layout (Button is now Child of Layout), add button Details
        buckysLayout.addView(username, usernameDetails); //add Username=input to Layout

        //Set this activities content/display to this view
        setContentView(buckysLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
