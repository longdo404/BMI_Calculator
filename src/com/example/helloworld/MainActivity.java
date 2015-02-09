package com.example.helloworld;

import java.text.DecimalFormat;

import org.w3c.dom.Text;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements OnClickListener {

	Button btn_CalBMI;
	EditText editName, editHeight, editWeight, editBMI, editResult;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);
        btn_CalBMI = (Button) findViewById(R.id.btn_CalBMI);
        btn_CalBMI.setOnClickListener(this);
        editName = (EditText) findViewById(R.id.editName);
        editHeight = (EditText) findViewById(R.id.editHeight);
        editWeight = (EditText) findViewById(R.id.editWeight);
        editBMI = (EditText) findViewById(R.id.editBMI);
        editResult = (EditText) findViewById(R.id.editResult);
    }
    
    public void onClick(View arg0) {
    	double H = Double.parseDouble(editHeight.getText() + "");
    	double W = Double.parseDouble(editWeight.getText() + "");
    	double BMI = W/Math.pow(H, 2);
    	String result = "";
    	if(BMI<18)
    	{
    		result = "Bạn gầy";
    	}
    	else if(BMI<=24.9)
    	{
    		result = "Bạn bình thường";
    	}

    	else if(BMI<=29.9)
    	{
    		result = "Bạn béo phì độ 1";
    	}
    	else if(BMI<=34.9)
    	{
    		result = "Bạn béo phì độ 2";
    	}
    	else
    	{
    		result = "Bạn béo phì độ 3";
    	}
    	DecimalFormat dcf = new DecimalFormat("#.0");
    	editBMI.setText(dcf.format(BMI));
    	editResult.setText(result + "");
    }
    
    public void btn_tong2so(View v) {
    	EditText editA = (EditText)findViewById(R.id.txt_soA);
    	int a = Integer.parseInt(editA.getText().toString());
    	
    	EditText editB = (EditText)findViewById(R.id.txt_soB);
    	int b = Integer.parseInt(editB.getText().toString());
    	
    	TextView txtkq = (TextView) findViewById(R.id.txt_Result);
    	txtkq.setText((a+b) + "");
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
