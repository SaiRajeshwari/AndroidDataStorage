package rajee.sairam.androiddatastorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rajee on 4/3/17.
 */

public class MyDbHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "productDB.db";
    private static final String TABLE_PRODUCT = "product";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESC = "desc";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_REVIEW = "review";


    String CREATE_PRODUCT_TABLE = "CREATE TABLE " + TABLE_PRODUCT
            + "("
            + COLUMN_NAME + " TEXT,"
            + COLUMN_DESC + " TEXT,"
            + COLUMN_PRICE + " TEXT,"
            + COLUMN_REVIEW + " TEXT"
            + ")";

    String DELETE_PRODUCT_TABLE = "DROP TABLE IF EXISTS " + TABLE_PRODUCT;

    public MyDbHandler(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PRODUCT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_PRODUCT_TABLE);
        onCreate(db);
    }

    public void addProduct(Product product){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, product.getName());
        values.put(COLUMN_DESC, product.getDesc());
        values.put(COLUMN_PRICE, product.getPrice());
        values.put(COLUMN_REVIEW, product.getReview());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_PRODUCT, null, values);
        db.close();
    }

    public Product findProduct(String name){
        Product product = new Product();
        String search_query = "SELECT * FROM " + TABLE_PRODUCT
                + " WHERE " + COLUMN_NAME + " = "
                + "\"" + name + "\"";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(search_query, null);
        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            product.setName(cursor.getString(0));
            product.setDesc(cursor.getString(1));
            product.setPrice(cursor.getString(2));
            product.setReview(cursor.getString(3));
        }
        return product;
    }


}
