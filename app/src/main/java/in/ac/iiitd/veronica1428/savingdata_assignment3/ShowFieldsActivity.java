package in.ac.iiitd.veronica1428.savingdata_assignment3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

/**
 * Created by veronica on 01/10/16.
 */
public class ShowFieldsActivity extends Activity{

    private static final String TAG = "ShowFieldsActivity";

    public static final String nameIntent = "in.ac.iiitd.veronica1428.showfieldsactivity.nameIntent";
    public static final String rollIntent = "in.ac.iiitd.veronica1428.showfieldsactivity.rollIntent";
    public static final String interestIntent = "in.ac.iiitd.veronica1428.showfieldsactivity.interestIntent";

    private String name;
    private String roll;
    private String interest;

    private Button showFields;
    private TextView fieldsView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_fields);

        name = getIntent().getStringExtra(nameIntent);
        roll = getIntent().getStringExtra(rollIntent);
        interest = getIntent().getStringExtra(interestIntent);

        fieldsView = (TextView) findViewById(R.id.fields_textViewID);

        final String appendedString = name.toString() + "\n" +
                roll.toString() + "\n" + interest.toString();

        showFields = (Button) findViewById(R.id.showFields_buttonID);
        showFields.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
                fieldsView.setText(appendedString);
           }
        });
    }
}
