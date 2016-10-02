package in.ac.iiitd.veronica1428.savingdata_assignment3;

/**
 * Created by veronica on 02/10/16.
 */

import android.provider.BaseColumns;

public class FormData {

    private String name;
    private String roll;
    private String interest;

    public FormData(){
    }

    public FormData(String r, String n, String i){
        this.name = n;
        this.roll = r;
        this.interest = i;
    }

    public void setName(String n){
        this.name = n;
    }

    public String getName(){
        return this.name;
    }

    public void setRoll(String r){
        this.roll = r;
    }

    public String getRoll(){
        return this.roll;
    }

    public void setInterest(String i){
        this.interest = i;
    }

    public String getInterest(){
        return this.interest;
    }
}
