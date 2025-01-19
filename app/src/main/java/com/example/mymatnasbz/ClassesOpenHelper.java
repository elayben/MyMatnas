package com.example.mymatnasbz;


    import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

    public class ClassesOpenHelper  extends SQLiteOpenHelper {
        public static final String DATABASENAME = "ClassesDB2120091211";//שם מסד נתונים
        public static final String TABLE_USERClASSES = "tblClasses2120901211";//שם הטבלה
        public static final int DATABASEVERSION = 1;

        public static final String COLUMN_ID = "ID";//מפתח ראשי - מספור אוטומטי
        //פירוט שדות(שמות עמודות)
        public static final String COLUMN_NAME ="name";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_DESC = "descrip";





        //יצירת טבלה
        private static final String CREATE_TABLE_ALL_USERClASSES = "CREATE TABLE IF NOT EXISTS " +
                TABLE_USERClASSES + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +  COLUMN_NAME + " VARCHAR, "+ COLUMN_IMAGE + " BLOB,"  + COLUMN_DESC + " VARCHAR " + ");";

        //מערך כולל שמות השדות(עמודות)
        String[] allColumns = {COLUMN_ID,  COLUMN_NAME, COLUMN_IMAGE,COLUMN_DESC};
        //אובייקט מובנה אחראי מסד נתונים Sql Lite
        SQLiteDatabase database;

        public ClassesOpenHelper(Context context) {//פעולה בונה
            super(context, DATABASENAME, null, DATABASEVERSION);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onCreate(SQLiteDatabase db) {//יצירת מסד נתונים
            db.execSQL(CREATE_TABLE_ALL_USERClASSES);
            Log.i("data", "טבלת חוגים נוצרה");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERClASSES);
            onCreate(db);
        }

        public void open() {//פתיחת מסד נתונים
            database = this.getWritableDatabase();
            Log.i("data", "Database connection open");
        }

        //quearies ......
        public Classes createClass(Classes c) {//יצירת רשומה- מכונית בתוך DB
            ContentValues values = new ContentValues();

            values.put(COLUMN_NAME, c.getName());
            values.put(COLUMN_IMAGE, c.getPicture());
            values.put(COLUMN_DESC, c.getDesc());


            long insertId = database.insert(ClassesOpenHelper.TABLE_USERClASSES, null, values);
            Log.i("data", "UserClass" + insertId + "insert to database");
           c.setId(insertId);
            return c;
        }

        public ArrayList<Classes> getAllClasses() {// שליפת רשימת מכוניות מתוך טבלה

            ArrayList<Classes> l = new ArrayList<Classes>();//אתחול רשימה
            //שאילתת בחירה
            Cursor cursor = database.query(ClassesOpenHelper.TABLE_USERClASSES, allColumns, null, null, null, null, null);
            //אם מספר שורות גדול מ0
            if (cursor.getCount() > 0) {
                //כל עוד שניתן להתקדם בטבלה
                while (cursor.moveToNext()) {
                    //העתקת נתונים למשתנים
                    int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));

                    String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                    byte[] image = cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE));
                    String descrip = cursor.getString(cursor.getColumnIndex(COLUMN_DESC));

                    //יצירת מכונית
                    Classes c = new Classes(id, name, descrip , image);
                    //עדכון מפתח ראשי
                    c.setId(id);
                    //הוספת מכונית לרשימת מכוניות
                    l.add(c);
                }
            }
            Log.i("data", "כל החוגים");
            return l;
        }
        //שליפת נתונים עם קריטריון לחיפוש
        public ArrayList<Classes> getAllClassesByFilter(String selection, String OrderBy) {
            Cursor cursor = database.query(TABLE_USERClASSES    , allColumns, selection, null, null, null, OrderBy);
            ArrayList<Classes> l = convertCursorToList(cursor);
            return l;
        }

        private ArrayList<Classes> convertCursorToList(Cursor cursor) {
            ArrayList<Classes> l = new ArrayList<Classes>();

            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                    String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                    byte[] image = cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE));
                    String descrip = cursor.getString(cursor.getColumnIndex(COLUMN_DESC));


                    Classes c = new Classes( name, descrip , image);


                    c.setId(id);
                    l.add(c);

                }

            }
            return l;
        }








        //שליפת חוגים לפי ID
        public Classes getClassbyID(long id) {
            Cursor cursor = database.query(ClassesOpenHelper.TABLE_USERClASSES, allColumns, null, null, null, null, null);
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    int idc = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                    if (idc == id) {

                        String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                        byte[] image = cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE));
                        String desc = cursor.getString(cursor.getColumnIndex(COLUMN_DESC));


                        Classes c = new Classes( name, desc , image);
                        c.setId(id);
                        return c;
                    }
                }
            }
            return null;
        }


        //=============update======================
        public long updateByRow(Classes c) {//יצירת רשומה- מכונית בתוך DB
            ContentValues values = new ContentValues();

            values.put(COLUMN_NAME, c.getName());
            values.put(COLUMN_DESC, c.getDesc());


            return database.update(ClassesOpenHelper.TABLE_USERClASSES, values, ClassesOpenHelper.COLUMN_ID +"=" + c.getId(), null);

        }
        //=============delete all======================
        public long deleteAll()

        {
            return database.delete(ClassesOpenHelper.TABLE_USERClASSES, null, null);
        }
        //=============delete one row by id======================
        public long deleteByRow(long rowId)
        {
            return database.delete(ClassesOpenHelper.TABLE_USERClASSES, ClassesOpenHelper.COLUMN_ID + "=" + rowId, null);
        }
    }

