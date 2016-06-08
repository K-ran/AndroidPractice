package ankita.myapplication.sqlLiteDatabasePractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ankita on 7/6/16.
 */
public class MyDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "MysqlliteDatabase.db";
    public static final String NAME_COLUMN = "name";
    public static final String ID_COLUMN = "id";
    public static final String MARKS_COLUMN = "marks";

    public MyDBHelper(Context context){
//        The database is not actually created or opened until one of getWritableDatabase() or getReadableDatabase() is called.
        super(context,DB_NAME,null,1);
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        db.execSQL("create table students " +
                "(id integer primary key AUTOINCREMENT, name text,marks INTEGER);");
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS students");
        onCreate(db);
    }

    public boolean insert(String name,int marks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues ();
        contentValues.put (MyDBHelper.NAME_COLUMN,name);
        contentValues.put(MyDBHelper.MARKS_COLUMN, marks);
        db.insert("students", null, contentValues);
        return true;
    }

    public Cursor getData(){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery ("select * from students",null);
    }

    public boolean remove(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete ("students","id = ?",new String[]{id+""});
        return true;
    }

    public boolean update(int id,String name,int marks){
        SQLiteDatabase db = this.getWritableDatabase ();
        ContentValues contentValues = new ContentValues();
        contentValues.put (MyDBHelper.NAME_COLUMN,name);
        contentValues.put(MyDBHelper.MARKS_COLUMN, marks);
        db.update("students",contentValues,"id = ?",new String[]{id+""});
        return true;
    }

}
