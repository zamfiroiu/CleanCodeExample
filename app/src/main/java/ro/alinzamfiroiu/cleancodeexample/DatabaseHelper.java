package ro.alinzamfiroiu.cleancodeexample;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="bazadedate.bd";
    private static final String TABLE_NAME="users";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_FIRST_NAME="first_name";
    private static final String COLUMN_LAST_NAME="last_name";
    private static final String COLUMN_USERNAME="username";
    private static final String COLUMN_IS_CURRENT="is_current";
    private static final String COLUMN_EMAIL="email";
    private static final String COLUMN_PASSWORD="password";
    private static final String COLUMN_CONFIRM_PASSWORD="confirm_password";
    private static final String COLUMN_BANK_NAME="bank_name";
    private static final String COLUMN_CITY="city";
    private static final String COLUMN_STREET_NAME="street_name";
    private static final String COLUMN_STREET_NUMBER="street_number";

    //TABELA BANCI
    private static final String TABLE_NAME_BANKS="banks";
    private static final String COLUMN_BANK_ID="bank_id";
    private static final String COLUMN_BANK_NAME_BANK="bank_name_bank";

    //TABELA BANCOMATE
    private static final String TABLE_NAME_ATMS="atms";
    private static final String COLUMN_ATM_ID="atm_id";
    private static final String COLUMN_ATM_SECTOR="atm_sector";
    private static final String COLUMN_ATM_ADRESS="atm_adress";
    private static final String COLUMN_BANK_ID_ATMS="bank_id_atms";

    private static final String TABLE_CREATE="create table " + TABLE_NAME + "("
            + COLUMN_ID + " integer primary key not null, "
            + COLUMN_FIRST_NAME + " text not null, "
            + COLUMN_LAST_NAME + " text not null, "
            + COLUMN_USERNAME + " text unique not null, "
            + COLUMN_IS_CURRENT + " text not null, "
            + COLUMN_EMAIL + " text not null unique, "
            + COLUMN_PASSWORD + " text not null, "
            + COLUMN_CONFIRM_PASSWORD + " text not null, "
            + COLUMN_BANK_NAME + " text not null, "
            + COLUMN_CITY + " text not null, "
            + COLUMN_STREET_NAME + " text not null, "
            + COLUMN_STREET_NUMBER + " integer not null)";

    //FUNCTIE CREARE TABELA BANKS
    private static final String TABLE_CREATE_BANKS = "create table " + TABLE_NAME_BANKS + "("
            + COLUMN_BANK_ID + " integer primary key not null, "
            + COLUMN_BANK_NAME_BANK + " text not null)";

    //FUNCTIE CREARE TABELA ATMS
    private static final String TABLE_CREATE_ATMS = "create table " + TABLE_NAME_ATMS + "("
            + COLUMN_ATM_ID + " integer primary key not null, "
            + COLUMN_ATM_SECTOR + " integer not null, "
            + COLUMN_ATM_ADRESS + " text not null, "
            + COLUMN_BANK_ID_ATMS + " integer not null)";




    SQLiteDatabase db;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATE_BANKS);
        db.execSQL(TABLE_CREATE_ATMS);

        db.execSQL("INSERT INTO " + TABLE_NAME_BANKS + " VALUES(0, 'BRD')");
        db.execSQL("INSERT INTO " + TABLE_NAME_BANKS + " VALUES(1, 'BCR')");
        db.execSQL("INSERT INTO " + TABLE_NAME_BANKS + " VALUES(2, 'Raiffeisen Bank')");
        db.execSQL("INSERT INTO " + TABLE_NAME_BANKS + " VALUES(3, 'Transilvania Bank')");
        db.execSQL("INSERT INTO " + TABLE_NAME_BANKS + " VALUES(4, 'ING Bank')");
        db.execSQL("INSERT INTO " + TABLE_NAME_BANKS + " VALUES(5, 'CEC Bank')");

        db.execSQL("INSERT INTO " + TABLE_NAME_ATMS + " VALUES(0, 1, 'Bulevardul General Gheorghe Magheru 32-36', 3)");
        db.execSQL("INSERT INTO " + TABLE_NAME_ATMS + " VALUES(1, 1, 'Calea Dorobanți 135-145', 3)");
        db.execSQL("INSERT INTO " + TABLE_NAME_ATMS + " VALUES(2, 1, 'Calea Victoriei 46', 3)");
        //===
        db.execSQL("INSERT INTO " + TABLE_NAME_ATMS + " VALUES(3, 2, 'Soseaua Mihai Bravu 107-119', 3)");
        db.execSQL("INSERT INTO " + TABLE_NAME_ATMS + " VALUES(4, 2, 'Soseaua Colentina 24', 3)");
        db.execSQL("INSERT INTO " + TABLE_NAME_ATMS + " VALUES(5, 2, 'Soseaua Pantelimon 256', 3)");
        //===
        db.execSQL("INSERT INTO " + TABLE_NAME_ATMS + " VALUES(6, 3, 'Bulevardul Corneliu Coposu 3', 3)");
        db.execSQL("INSERT INTO " + TABLE_NAME_ATMS + " VALUES(7, 3, 'Bulevardul Theodor Pallady 2', 3)");
        db.execSQL("INSERT INTO " + TABLE_NAME_ATMS + " VALUES(8, 3, 'Bulevardul Nicolae Grigorescu 31A', 3)");
        //===
        db.execSQL("INSERT INTO " + TABLE_NAME_ATMS + " VALUES(9, 4, 'Soseaua Oltenitei 208', 3)");
        db.execSQL("INSERT INTO " + TABLE_NAME_ATMS + " VALUES(10, 4, 'Bulevardul Gheorghe Sincai 2', 3)");
        db.execSQL("INSERT INTO " + TABLE_NAME_ATMS + " VALUES(11, 4, 'Soseaua Oltenitei 50-52', 3)");
        //===
        db.execSQL("INSERT INTO " + TABLE_NAME_ATMS + " VALUES(12, 5, 'Calea Rahovei 293', 3)");
        db.execSQL("INSERT INTO " + TABLE_NAME_ATMS + " VALUES(13, 5, 'Calea 13 Septembrie 221-225', 3)");
        db.execSQL("INSERT INTO " + TABLE_NAME_ATMS + " VALUES(14, 5, 'Bulevardul Nerva Traian 5', 3)");
        //===
        db.execSQL("INSERT INTO " + TABLE_NAME_ATMS + " VALUES(15, 6, 'Bulevardul Iuliu Maniu 7', 3)");
        db.execSQL("INSERT INTO " + TABLE_NAME_ATMS + " VALUES(16, 6, 'Soseaua Cotroceni 11', 3)");
        db.execSQL("INSERT INTO " + TABLE_NAME_ATMS + " VALUES(17, 6, 'Calea Crangasi 18', 3)");
        db.execSQL("INSERT INTO " + TABLE_NAME_ATMS + " VALUES(18, 6, ' Bulevardul Iuliu Maniu 16', 3)");


    }



   /* public void insertUser(User u) {


        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor c = db.rawQuery(query, null);
        int count = c.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_FIRST_NAME, u.getFirstName());
        values.put(COLUMN_LAST_NAME, u.getLastName());
        values.put(COLUMN_USERNAME, u.getUsername());
        values.put(COLUMN_IS_CURRENT, "OFFLINE");
        values.put(COLUMN_EMAIL, u.geteMail());
        values.put(COLUMN_PASSWORD, u.getPassword());
        values.put(COLUMN_CONFIRM_PASSWORD, u.getConfirmPassword());
        values.put(COLUMN_BANK_NAME, u.getBankName());
        values.put(COLUMN_CITY, u.getCity());
        values.put(COLUMN_STREET_NAME, u.getStreetName());
        values.put(COLUMN_STREET_NUMBER, u.getStreetNumber());

        db.insert(TABLE_NAME, null, values);

        db.close();
    }
*/
    public String searchPass(String username) {
        db = getReadableDatabase();
        String query = "SELECT " + COLUMN_USERNAME + ", " + COLUMN_PASSWORD + " FROM " + TABLE_NAME + ";";
        Cursor cursor = db.rawQuery(query, null);
        String a;
        String b;
        b = "Not found";

        if(cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);

                if(a.equals(username)) {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());

        }

        return b;
    }

    public int searchBankID( String username) {
        int idBank = 10;

        String bank = findBank(username);
        if(bank == "BRD") {
            idBank = 0;
        }
        else if(bank == "BCR") {
            idBank = 1;
        }

        return idBank;
    }

    public void goOnline(String username){
        db = getWritableDatabase();

        ContentValues c = new ContentValues();
        c.put(COLUMN_IS_CURRENT, "ONLINE");

        db.update(TABLE_NAME, c, COLUMN_USERNAME + "='" + username + "'", null);

        db.close();
    }

    public void goOffline(String username) {
        db = getWritableDatabase();
        String status = "OFFLINE";

        ContentValues c = new ContentValues();
        c.put(COLUMN_IS_CURRENT, status);

        db.update(TABLE_NAME, c, COLUMN_USERNAME + "='" + username + "'", null);

        db.close();
    }

    public String findEmail(String username) {
        db = getReadableDatabase();
        String email="";
        String query = "SELECT " + COLUMN_EMAIL + " FROM " + TABLE_NAME +
                " WHERE " + COLUMN_USERNAME + "='" + username + "';";

        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()){
            do{
                email = c.getString(0);

            }while(c.moveToNext());
        }

        return email;
    }

    public String findBank(String username) {
        db = getReadableDatabase();
        String bank = "";
        String query = "SELECT " + COLUMN_BANK_NAME + " FROM " + TABLE_NAME +
                " WHERE " + COLUMN_USERNAME + "='" + username + "';";

        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()) {
            do {
                bank = c.getString(0);
            }
            while(c.moveToNext());
        }

        return bank;
    }

    public String findCity(String username) {
        db = getReadableDatabase();
        String city = "";
        String query = "SELECT " + COLUMN_CITY + " FROM " + TABLE_NAME +
                " WHERE " + COLUMN_USERNAME + "='" + username + "';";

        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()) {
            do {
                city = c.getString(0);
            }
            while(c.moveToNext());
        }

        return city;
    }

    public String findStreetName(String username) {
        db = getReadableDatabase();
        String streetName = "";
        String query = "SELECT " + COLUMN_STREET_NAME + " FROM " + TABLE_NAME +
                " WHERE " + COLUMN_USERNAME + "='" + username + "';";

        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()) {
            do {
                streetName = c.getString(0);
            }
            while(c.moveToNext());
        }

        return streetName;
    }

    public String findStreetNumber(String username) {
        db = getReadableDatabase();
        String streetNumber = "";
        String query = "SELECT " + COLUMN_STREET_NUMBER + " FROM " + TABLE_NAME +
                " WHERE " + COLUMN_USERNAME + "='" + username + "';";

        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()) {
            do {
                streetNumber = c.getString(0);
            }
            while(c.moveToNext());
        }

        return streetNumber;
    }

    public void saveChanges(String username, String city, String streetName, int streetNumber) {
        db = getWritableDatabase();

        ContentValues c = new ContentValues();
        c.put(COLUMN_CITY, city);
        c.put(COLUMN_STREET_NAME, streetName);
        c.put(COLUMN_STREET_NUMBER, streetNumber);

        db.update(TABLE_NAME, c, COLUMN_USERNAME + "='" + username + "'", null);

        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        //String query2 = "DROP TABLE IF EXITS" + TABLE_NAME_BANKS;
        db.execSQL(query);
        //db.execSQL(query2);

        onCreate(db);
    }

    public ArrayList<String> getATMAddressesBySector(String sector)
    {
        db = getWritableDatabase();
        Cursor cursor=db.query(false,TABLE_NAME_ATMS,new String[]{COLUMN_ATM_ADRESS},COLUMN_ATM_SECTOR + "=" + sector,null,null,null,null,null);

        ArrayList<String> adreseATM=new ArrayList<String>();
        while (cursor.moveToNext()) {
            adreseATM.add(cursor.getString(cursor.getColumnIndex("atm_adress")));
        }
        return adreseATM;
    }
}
