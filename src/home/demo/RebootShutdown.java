package home.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class RebootShutdown extends Activity{
    
	Button reboot;
	Button shutDown;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        reboot = (Button)findViewById(R.id.reboot);
        shutDown = (Button)findViewById(R.id.shutdown);
        
        if(shutDown != null){
        	Toast.makeText(this, "Your android is Shutting down....", Toast.LENGTH_LONG);
        	shutDown.setOnClickListener(new OnClickListener() {
    			public void onClick(View v) {
    				Intent i_shutdown = new Intent(Intent.ACTION_SCREEN_OFF);
    				//i_shutdown.putExtra("nowait", 1); 
    				//i_shutdown.putExtra("interval", 1); 
    				//i_shutdown.putExtra("window", 0); 
    		        i_shutdown.setAction(Intent.ACTION_SHUTDOWN); 
    		        sendBroadcast(i_shutdown); 
    			}
    		});
        }else{
        	Toast.makeText(this, "Your android is Rebooting....", Toast.LENGTH_LONG);
        	reboot.setOnClickListener(new OnClickListener() {
    			public void onClick(View v) {
    				Intent i_reboot = new Intent(Intent.ACTION_REBOOT);
    				i_reboot.putExtra("nowait", 1); 
    				i_reboot.putExtra("interval", 1); 
    				i_reboot.putExtra("window", 0); 
    				i_reboot.setAction(Intent.ACTION_REBOOT); 
    		        sendBroadcast(i_reboot);
    			}
    		});
        }
    }
}