package in.ac.iiitd.veronica1428.savingdata_assignment3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by veronica on 02/10/16.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "form.db";
    public static final String TABLE_NAME = "form";
    public static final String COLUMN_ROLL = "roll";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_INTEREST = "interest";
    public static final String TEXT_TYPE = " TEXT";
    public static final String COMMA_SEP = ",";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String create_query = "CREATE TABLE " + DBHandler.TABLE_NAME + "(" +
                DBHandler.COLUMN_ROLL + DBHandler.TEXT_TYPE + DBHandler.COMMA_SEP +
                DBHandler.COLUMN_NAME + DBHandler.TEXT_TYPE + DBHandler.COMMA_SEP +
                DBHandler.COLUMN_INTEREST + DBHandler.TEXT_TYPE + " )";

        db.execSQL(create_query);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String delete_query = "DROP TABLE IF EXISTS " + DBHandler.TABLE_NAME;

        db.execSQL(delete_query);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
