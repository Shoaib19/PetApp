package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android.pets.data.petContract.petEntry;

import static android.content.ContentValues.TAG;


/**
 * Database helper Class for Pets app.It Manages database creation(for the first time the app opens) and version management.
 */
public class PetDbHelper extends SQLiteOpenHelper {

    //This is a Constant varialble for database name and Version.
    //Name of the Database file.
    private static final String DATABASE_NAME = "Pets.db";

    //If you change the database schema, then you must update the version.
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link PetDbHelper}.
     *
     * @param context of the app
     */
    public PetDbHelper(Context context) {
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }


    //This is called when the database is created for the first time.
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //Creating the SQL statement for creating the Table.
        String CREATE_PET_TABLE = "CREATE TABLE " + petEntry.TABLE_NAME + "("
                + petEntry.COLUMN_ID + " INTEGER " + "PRIMARY KEY " + "AUTOINCREMENT,"
                + petEntry.COLUMN_NAME + " TEXT NOT NULL,"
                + petEntry.COLUMN_BREED + " TEXT,"
                + petEntry.COLUMN_GENDER + " INTEGER NOT NULL,"
                + petEntry.COLUMN_WEIGHT + " INTEGER " + ")";


        Log.d(TAG, "onCreate: " + CREATE_PET_TABLE);

        //creating the table
      sqLiteDatabase.execSQL(CREATE_PET_TABLE);
    }

    //This method is called when the database table needs to upgraded
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
/*
        // Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);

        // Create tables again
        onCreate(sqLiteDatabase);*/
    }
}
