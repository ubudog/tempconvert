package net.ubudog.tempconvert;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class TempConvert extends Activity {
    	
	int value; 
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        main();
    }
    
    public void main() { 
   //  	final RadioGroup radgroup = (RadioGroup) findViewById(R.id.tempgroup); 
    	final RadioButton fahrenheit = (RadioButton) findViewById(R.id.fahrenheit); 
    	final RadioButton celcius = (RadioButton) findViewById(R.id.celcius);
    	    	
    	// Calculate it
    	Button calculatebtn = (Button) findViewById(R.id.calculate); 
    	calculatebtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Make sure everything is all set
			    	// Get the value to an int
			    	// Check modes
					String mode = "";  
			    	if (fahrenheit.isChecked()) { 
			    		mode = "fahrenheit"; 
			    	} else if (celcius.isChecked()) { 
			    		mode = "celcius"; 
			    	} else { 
			    		Toast errorToast = Toast.makeText(getApplicationContext(), "Please select a conversion.", Toast.LENGTH_LONG); 
			    		errorToast.show(); 
			    	}
			    	
			    	EditText valueText = (EditText) findViewById(R.id.value); 
			    	if (valueText.getText().toString().equals("")) { 
			    		Toast errorToast = Toast.makeText(getApplicationContext(), "Please enter a value.", Toast.LENGTH_LONG); 
			    		errorToast.show(); 
			    	} else { 
			    		value = Integer.parseInt(valueText.getText().toString()); 
			    		calculate(mode, value); 
			    	}
			}
		});
    }
    
    public void calculate(String mode, int value) { 
    	int result; 
    	double fraction;
    	
    	// Do the calculating
    	if (mode.equals("fahrenheit")) { 
    		fraction = 0.55555555555555555556;
    		value = value-32;
    		result = (int) (value*fraction); 
    		Toast resultToastF = Toast.makeText(getApplicationContext(), "Result: " + result, Toast.LENGTH_LONG); 
    		resultToastF.show(); 
    	} else if (mode.equals("celcius")) {
    		fraction = 1.8; 
    		value = (int) (value*fraction); 
    		result = value+32; 
    		Toast resultToastC = Toast.makeText(getApplicationContext(), "Result: " + result, Toast.LENGTH_LONG); 
    	//	 °C  x  9/5 + 32 = °F
    		resultToastC.show(); 
    	}
    }
    
    
    
}