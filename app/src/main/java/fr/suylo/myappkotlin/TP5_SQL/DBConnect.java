package fr.suylo.myappkotlin.TP5_SQL;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.text.MessageFormat;
import java.util.ArrayList;

public class DBConnect extends SQLiteOpenHelper {

    public static final String DB_TABLE_NAME = "country";
    public static final String TABLE_COL_ID = "id";
    public static final String TABLE_COL_COUNTRY = "country";
    public static final String TABLE_COL_CURRENCY = "currency";
    private static DBConnect dbInstance = null;

    DBConnect(Context context){
        super(context, DB_TABLE_NAME, null, 1);
    }

    public static synchronized DBConnect getInstance(Context context){
        if (dbInstance == null){
            dbInstance = new DBConnect(context.getApplicationContext());
        }
        return dbInstance;
    }

    public DBConnect(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(MessageFormat.format((
                "CREATE TABLE {0} (" +
                        "{1} integer primary key autoincrement," +
                        "{2} varchar(50)," +
                        "{3} varchar(50))"),
                DB_TABLE_NAME, TABLE_COL_ID, TABLE_COL_COUNTRY, TABLE_COL_CURRENCY)
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertCountryAndCurrency(String country, String currency){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TABLE_COL_COUNTRY, country);
        cv.put(TABLE_COL_CURRENCY, currency);
        db.insert(DB_TABLE_NAME, null, cv);
        return true;
    }

    public ArrayList<String> getAllCountriesAndCurrencies(){
        ArrayList<String> res = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor q = db.rawQuery("SELECT * FROM " + DB_TABLE_NAME, null);
        q.moveToFirst();
        while (!q.isAfterLast()){
            @SuppressLint("Range") String id = q.getString(q.getColumnIndex(TABLE_COL_ID));
            @SuppressLint("Range") String country = q.getString(q.getColumnIndex(TABLE_COL_COUNTRY));
            @SuppressLint("Range") String currency = q.getString(q.getColumnIndex(TABLE_COL_CURRENCY));
            res.add("[" + id + "] " + country + " : " + currency);
            q.moveToNext();
        }
        return res;
    }
}