package net.ubudog.tempconvert;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
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
    	final RadioButton fahrenheit = (RadioButton) findViewById(R.id.fahrenheit); 
    	final RadioButton celsius = (RadioButton) findViewById(R.id.celsius);
    	    	
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
			    	} else if (celsius.isChecked()) { 
			    		mode = "celsius"; 
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
    	} else if (mode.equals("celsius")) {
    		fraction = 1.8; 
    		value = (int) (value*fraction); 
    		result = value+32; 
    		Toast resultToastC = Toast.makeText(getApplicationContext(), "Result: " + result, Toast.LENGTH_LONG); 
    	//	 °C  x  9/5 + 32 = °F
    		resultToastC.show(); 
    	} else { 
    		Toast modeError = Toast.makeText(getApplicationContext(), "Not a valid mode.", Toast.LENGTH_LONG); 
    		modeError.show(); 
    	}
    }
    
    public void versionInfo() { 
        AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
        
        alertbox.setTitle("Version"); 
        alertbox.setMessage("TempConvert Version 1.0\nSource code: \nhttp://github.com/ubudog/tempconvert");
       
        alertbox.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            
            public void onClick(DialogInterface arg0, int arg1) {
            		
            }
        });
        
        alertbox.show();
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {

    	super.onCreateOptionsMenu(menu);
    	MenuInflater awesome = getMenuInflater();
    	awesome.inflate(R.menu.menu, menu);
    	return true;
    	
    }

    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	switch (item.getItemId()) {
    	case R.id.version:
    		versionInfo(); 
    		return true; 
    	}
    	
    	return false;
    }; 
}