package in.ac.iiitd.veronica1428.savingdata_assignment3;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.util.Log;

public class MainActivity extends FragmentActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Inside onCreate method");

        //if fragment exists in activity
        if(findViewById(R.id.activity_mainID) != null){

            //if some device configuration changed
            if(savedInstanceState != null){
                return;
            }

            //create a new fragment if the savedInstanceState is null
            SaveData_Fragment saveDataFragment = new SaveData_Fragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_mainID, saveDataFragment).commit();
        }

    }
}
