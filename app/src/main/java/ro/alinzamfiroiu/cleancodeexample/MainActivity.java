package ro.alinzamfiroiu.cleancodeexample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        DatabaseHelper dbHelper = new DatabaseHelper(this.getApplicationContext());
        db = dbHelper.getWritableDatabase();
        c = db.rawQuery("SELECT ATM_ADRESS FROM atms WHERE ATM_SECTOR=1", null);
        int count = c.getCount();
        String locations[] = new String[count];
        int i = 0;
        while (c.moveToNext()) {
            locations[i] = c.getString(c.getColumnIndex("atm_adress"));
            i++;
        }

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,locations);

        ListView list = (ListView) findViewById(R.id.listViewBank1);

        list.setAdapter(adapter);
    }
}
