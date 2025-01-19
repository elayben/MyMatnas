package com.example.mymatnasbz;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;


public class SqliteHelper extends SQLiteOpenHelper {

    //DATABASE NAME
    public static final String DATABASE_NAME = "dbUsers";


    //DATABASE VERSION
    public static final int DATABASE_VERSION = 1;

    //TABLE NAME
    public static final String TABLE_USERS = "users9";

    //TABLE USERS COLUMNS
    //ID COLUMN @primaryKey
    public static final String KEY_ID = "id";

    //COLUMN user name
    public static final String KEY_USER_NAME = "username";

    //COLUMN email
    public static final String KEY_EMAIL = "email";
    public static final String KEY_INSTRUCTOR = "instructor";
    //COLUMN password
    public static final String KEY_PASSWORD = "password";


    //SQL for creating users table
    public static final String SQL_TABLE_USERS = " CREATE TABLE " + TABLE_USERS
            + " ( "
            + KEY_ID + " INTEGER PRIMARY KEY, "
            + KEY_USER_NAME + " TEXT, "
            + KEY_EMAIL + " TEXT, "
            + KEY_INSTRUCTOR + " TEXT, "
            + KEY_PASSWORD + " TEXT "
            + " ) ";


    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    String[] allColumns = {KEY_ID,  KEY_USER_NAME,KEY_EMAIL,KEY_INSTRUCTOR, KEY_PASSWORD};
    SQLiteDatabase databaseUser;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Create Table when oncreate gets called
        sqLiteDatabase.execSQL(SQL_TABLE_USERS);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //drop table to create new one if database version updated
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_USERS);
    }

    public void open() {//פתיחת מסד נתונים
        databaseUser = this.getWritableDatabase();
        Log.i("data", "Database connection open");
    }
    public ArrayList<User> getAllUsers() {// שליפת רשימת משתמשים מתוך טבלה

        ArrayList<User> l = new ArrayList<User>();//אתחול רשימה
        //שאילתת בחירה
        Cursor cursor = databaseUser.query(SqliteHelper.TABLE_USERS , allColumns, null, null, null, null, null);
        //אם מספר שורות גדול מ0
        if (cursor.getCount() > 0) {
            //כל עוד שניתן להתקדם בטבלה
            while (cursor.moveToNext()) {
                //העתקת נתונים למשתנים
                String id = cursor.getString(cursor.getColumnIndex(KEY_ID));
                String name = cursor.getString(cursor.getColumnIndex(KEY_USER_NAME));
                String email = cursor.getString(cursor.getColumnIndex(KEY_EMAIL));
                String instuctor = cursor.getString(cursor.getColumnIndex(KEY_INSTRUCTOR));

                String password = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD));

                //יצירת משתמש
                User c = new User(id, name,  email,instuctor, password);
                //עדכון מפתח ראשי
                c.setId(id);
                //הוספת משתמש לרשימת משתמשים
                l.add(c);
            }
        }
        Log.i("data", "כל המשתמשים");
        return l;
    }
    //using this method we can add users to user table
    public User addUser(User user) {

        //get writable database
        SQLiteDatabase db = this.getWritableDatabase();

        //create content values to insert
        ContentValues values = new ContentValues();

        values.put(KEY_USER_NAME, user.userName);
        values.put(KEY_EMAIL, user.email);
        values.put(KEY_INSTRUCTOR, "false");
        values.put(KEY_PASSWORD, user.password);

        // insert row
        long todo_id = db.insert(TABLE_USERS, null, values);
        user.setId(String.valueOf(todo_id));
        return user;
    }

    public User Authenticate(User user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS,// Selecting Table
                new String[]{KEY_ID, KEY_USER_NAME, KEY_EMAIL,KEY_INSTRUCTOR, KEY_PASSWORD},//Selecting columns want to query
                KEY_EMAIL + "=?",
                new String[]{user.email},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email
            User user1 = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));

            //Match both passwords check they are same or not
            if (user.password.equalsIgnoreCase(user1.password)) {
                return user1;
            }
        }

        //if user password does not matches or there is no record with that email then return @false
        return null;
    }

    public boolean isEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS,// Selecting Table
                new String[]{KEY_ID, KEY_USER_NAME, KEY_EMAIL,KEY_INSTRUCTOR, KEY_PASSWORD},//Selecting columns want to query
                KEY_EMAIL + "=?",
                new String[]{email},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email so return true
            return true;
        }

        //if email does not exist return false
        return false;
    }
    //שליפת משתמשים לפי ID
     public User getUserID(long id) {
        Cursor cursor = databaseUser.query(SqliteHelper.TABLE_USERS, allColumns, null, null, null, null, null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int idc = cursor.getInt(cursor.getColumnIndex(KEY_ID));
                if (idc == id) {

                    String idU = cursor.getString(cursor.getColumnIndex(KEY_ID));
                    String name = cursor.getString(cursor.getColumnIndex(KEY_USER_NAME));
                    String email = cursor.getString(cursor.getColumnIndex(KEY_EMAIL));
                    String instructor = cursor.getString(cursor.getColumnIndex(KEY_INSTRUCTOR));
                    String password=cursor.getString(cursor.getColumnIndex(KEY_PASSWORD));


                    User c = new User(idU, name,  email,instructor, password);
                    return c;
                }
            }
        }
        return null;
    }
    public boolean getUserEmailPassword(String email1,String password1) {
        Cursor cursor = databaseUser.query(SqliteHelper.TABLE_USERS, allColumns, null, null, null, null, null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int idc = cursor.getInt(cursor.getColumnIndex(KEY_ID));


                    String idU = cursor.getString(cursor.getColumnIndex(KEY_ID));
                    String name = cursor.getString(cursor.getColumnIndex(KEY_USER_NAME));
                    String email = cursor.getString(cursor.getColumnIndex(KEY_EMAIL));
                    String instructor = cursor.getString(cursor.getColumnIndex(KEY_INSTRUCTOR));
                    String password=cursor.getString(cursor.getColumnIndex(KEY_PASSWORD));
                if (email1.equals(email)&& (password1.equals(password))) {

                   // User c = new User(idU, name,  email,instructor, password);
                    return true;
                }
            }
        }
        return false;
    }
    //=============update======================
    public long updateByRow(User c) {//יצירת רשומה- מכונית בתוך DB
        ContentValues values = new ContentValues();

        values.put(KEY_USER_NAME, c.getUserName());
        values.put(KEY_EMAIL, c.getEmail());
        values.put(KEY_INSTRUCTOR, c.getInstructor());


        return databaseUser.update(SqliteHelper.TABLE_USERS, values, SqliteHelper.KEY_ID +"=" + c.getId(), null);

    }
    //=============delete all======================
    public long deleteAll()

    {
        return databaseUser.delete(SqliteHelper.TABLE_USERS, null, null);
    }
    //=============delete one row by id======================
    public long deleteByRow(long rowId)
    {
        return databaseUser.delete(SqliteHelper.TABLE_USERS, SqliteHelper.KEY_ID + "=" + rowId, null);
    }
}


