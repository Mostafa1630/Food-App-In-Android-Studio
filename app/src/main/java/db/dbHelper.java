package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

 public class dbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Food.db";
    public static final int DATABASE_VERSION=3;
     public static final String Table_customer="customer";
     public static final String Table_order="orders";
     //public static final String Table_payment="payment";
     public static final String Table_food="food";
     public static final String Table_category="category";
     public static final String Table_order_food="order_foo";

public dbHelper(Context context){
    super(context,DATABASE_NAME,null,DATABASE_VERSION);

}
    @Override

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    String sql1="create table "+Table_customer+"("
            +"id integer primary key autoincrement,"
        +"name varchar(50),"
        +"password varchar(20) ,"
        +"email varchar(15) unique not null,"
        +"phone varchar(11) ,"
         +"address varchar(50) not null )";
    sqLiteDatabase.execSQL(sql1);
        String sql2="create table "+Table_order+"("
                +"id integer primary key autoincrement,"
                +"date varchar(50),"
                +"customer_id integer,"
                +"FOREIGN KEY(customer_id) REFERENCES "+Table_customer+"(id) )";
        sqLiteDatabase.execSQL(sql2);
        String sql3="create table "+Table_food+"("
                +"id integer primary key autoincrement,"
                +"name varchar(50),"
                +"price integer,"
                +"category_id integer,"
                +"FOREIGN KEY(category_id) REFERENCES "+Table_category+"(id) )";
        sqLiteDatabase.execSQL(sql3);
        String sql4="create table "+Table_order_food+"("
                +"id integer primary key autoincrement,"
                +"order_id integer,"
                +"food_id integer,"
                +"FOREIGN KEY(order_id) REFERENCES "+Table_order+"(id),"
                +"FOREIGN KEY(food_id) REFERENCES "+Table_food+"(id) )";

        sqLiteDatabase.execSQL(sql4);

            String sql5="create table "+Table_category+"("
                    +"id integer primary key autoincrement,"
                    +"name varchar(50),"
                    +"image integer unique)";
            sqLiteDatabase.execSQL(sql5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+Table_customer);
        sqLiteDatabase.execSQL("drop table if exists "+Table_order);
        sqLiteDatabase.execSQL("drop table if exists "+Table_food);
        sqLiteDatabase.execSQL("drop table if exists "+Table_order_food);
        sqLiteDatabase.execSQL("drop table if exists "+Table_category);
        onCreate(sqLiteDatabase);
  }
}