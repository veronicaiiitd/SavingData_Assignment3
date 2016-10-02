package in.ac.iiitd.veronica1428.savingdata_assignment3;

/**
 * Created by veronica on 30/09/16.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SaveData_Fragment extends Fragment{

    private static final String TAG = "SaveData_Fragment";

    private EditText nameEditText;
    private EditText rollNumberEditText;
    private EditText interestedEditText;
    private Button submitButton;
    private Button saveButton;
    private Button sqlButton;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Inside onCreate method");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        super.onCreateView(inflater, parent, savedInstanceState);
        Log.d(TAG, "Inside onCreateView method");

        final View view = inflater.inflate(R.layout.fragment_save_data, parent, false);

        final SharedPreferences sharedPreference = getActivity().getSharedPreferences(getString(
                R.string.SHARED_PREFERENCE_FILE_KEY), getActivity().MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreference.edit();

        nameEditText = (EditText) view.findViewById(R.id.name_editTextID);
        rollNumberEditText = (EditText) view.findViewById(R.id.roll_editTextID);
        interestedEditText = (EditText) view.findViewById(R.id.interest_editTextID);

        saveButton = (Button) view.findViewById(R.id.save_buttonID);
        saveButton.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){

               String name = nameEditText.getText().toString();
               String roll = rollNumberEditText.getText().toString();
               String interest = interestedEditText.getText().toString();

               editor.putString(getString(R.string.Name), name);
               editor.putString(getString(R.string.Roll), roll);
               editor.putString(getString(R.string.interest), interest);
               editor.commit();

               String nameDefault = getResources().getString(R.string.Name);
               String rollDefault = getResources().getString(R.string.Roll);
               String interestDefault = getResources().getString(R.string.interest);

               String n = sharedPreference.getString(getString(R.string.Name), nameDefault);
               String r = sharedPreference.getString(getString(R.string.Roll), rollDefault);
               String i = sharedPreference.getString(getString(R.string.interest), interestDefault);

               //Toast.makeText(getContext(), n , Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(getActivity(), ShowFieldsActivity.class);
               intent.putExtra(ShowFieldsActivity.nameIntent, n);
               intent.putExtra(ShowFieldsActivity.rollIntent, r);
               intent.putExtra(ShowFieldsActivity.interestIntent, i);
               startActivity(intent);
           }
        });

        submitButton = (Button) view.findViewById(R.id.submit_buttonID);
        submitButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
               String name = nameEditText.getText().toString();
               String roll = rollNumberEditText.getText().toString();
               String interest = interestedEditText.getText().toString();

                Intent intent = new Intent(getActivity(), saveFilesActivity.class);
                intent.putExtra(saveFilesActivity.nameIntent, name);
                intent.putExtra(saveFilesActivity.rollIntent, roll);
                intent.putExtra(saveFilesActivity.interestIntent, interest);
                startActivity(intent);
            }
        });

        sqlButton = (Button) view.findViewById(R.id.sql_buttonID);
        sqlButton.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               String name = nameEditText.getText().toString();
               String roll = rollNumberEditText.getText().toString();
               String interest = interestedEditText.getText().toString();

               Intent intent = new Intent(getActivity(), SQLiteSaveActivity.class);
               intent.putExtra(SQLiteSaveActivity.nameIntent, name);
               intent.putExtra(SQLiteSaveActivity.rollIntent, roll);
               intent.putExtra(SQLiteSaveActivity.interestIntent, interest);
               startActivity(intent);
           }
        });

        return view;
    }
}
