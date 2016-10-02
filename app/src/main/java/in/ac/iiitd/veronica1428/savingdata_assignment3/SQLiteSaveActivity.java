package in.ac.iiitd.veronica1428.savingdata_assignment3;

/**
 * Created by veronica on 02/10/16.
 */

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.content.ContentValues;
import android.util.Log;

public class SQLiteSaveActivity extends Activity{

    private static final String TAG = "SQLiteSaveActivity";
    public static final String nameIntent = "in.ac.iiitd.veronica1428.sqlite_save_activity.nameIntent";
    public static final String rollIntent = "in.ac.iiitd.veronica1428.sqlite_save_activity.rollIntent";
    public static final String interestIntent = "in.ac.iiitd.veronica1428.sqlite_save_activity.interestIntent";

    private TextView fieldsTextView;
    private Button showSqlFieldsButton;
    private String name;
    private String roll;
    private String interest;

    DBHandler db_handler = new DBHandler(getApplicationContext());

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_save);

        name = getIntent().getStringExtra(nameIntent);
        roll = getIntent().getStringExtra(rollIntent);
        interest = getIntent().getStringExtra(interestIntent);

        fieldsTextView = (TextView) findViewById(R.id.sqlFields_textViewID);

        showSqlFieldsButton = (Button) findViewById(R.id.showSqlFields_buttonID);
        showSqlFieldsButton.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
               SQLiteDatabase db = db_handler.getWritableDatabase();

               ContentValues values = new ContentValues();
               values.put(db_handler.COLUMN_ROLL, roll);
               values.put(db_handler.COLUMN_NAME, name);
               values.put(db_handler.COLUMN_INTEREST, interest);

               Log.d(TAG, values.toString());

               long newRowId = db.insert(db_handler.TABLE_NAME, null, values);

           }
        });


    }
}
