package in.ac.iiitd.veronica1428.savingdata_assignment3;

/**
 * Created by veronica on 02/10/16.
 */

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

public class saveFilesActivity extends Activity{

    private static final String TAG = "saveFilesActivity";
    public static final String nameIntent = "in.ac.iiitd.veronica1428.savefilesactivity.nameIntent";
    public static final String rollIntent = "in.ac.iiitd.veronica1428.savefilesactivity.rollIntent";
    public static final String interestIntent = "in.ac.iiitd.veronica1428.savefilesactivity.interestIntent";

    private Button internal_file;
    private Button external_file;
    private TextView showData;

    private String name;
    private String roll;
    private String interest;

    public boolean isExternalStorageWritable(){
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_files);

        name = getIntent().getStringExtra(nameIntent);
        roll = getIntent().getStringExtra(rollIntent);
        interest = getIntent().getStringExtra(interestIntent);

        showData = (TextView) findViewById(R.id.showData_textViewID);

        internal_file = (Button) findViewById(R.id.internal_buttonID);
        internal_file.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){

               FileOutputStream outputStream;
               File file;

               try{

                   String combine = name + "\n" + roll + "\n" + interest;
                   outputStream = openFileOutput("form.txt", MODE_PRIVATE);
                   outputStream.write(combine.getBytes());
                   outputStream.close();

                   file = new File(getFilesDir(), "form.txt");
                   String data = readFromFile(file);

                   showData.setText(data);

               }catch(Exception e){
                   e.printStackTrace();
               }
           }
        });

        external_file = (Button) findViewById(R.id.external_buttonID);
        external_file.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){

               boolean isWritable = isExternalStorageWritable();
               File file  = makeFile("form.txt");

               FileOutputStream outputStream;

               try{
                   String combine = name + "\n" + roll + "\n" + interest;
                   outputStream = new FileOutputStream(file);
                   outputStream.write(combine.getBytes());
                   outputStream.close();

                   file = new File(Environment.getExternalStoragePublicDirectory(
                           Environment.DIRECTORY_DOCUMENTS)+"/Assignment3", "form.txt");
                   String data = readFromFile(file);

                   showData.setText(data);

               }catch(Exception e){
                   e.printStackTrace();
               }
           }
        });
    }

    private String readFromFile(File file){

        BufferedReader reader;
        StringBuffer sb = new StringBuffer();

        try{
            reader = new BufferedReader(new FileReader(file));
            String line = "";
            while((line = reader.readLine())!=null){
                sb.append(line + "\n");
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return sb.toString();
    }

    private File makeFile(String fileName){
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString();
        Log.d(TAG, path);

        File dir = new File(path + "/Assignment3");
        File file = new File(dir, fileName);
        if(file.exists()){
            file.delete();
        }

        return file;
    }
}
