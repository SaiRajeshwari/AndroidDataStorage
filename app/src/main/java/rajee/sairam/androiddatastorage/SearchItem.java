package rajee.sairam.androiddatastorage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchItem extends AppCompatActivity {

    EditText searchName;
    ListView listView;

    MyDbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_item);

        searchName = (EditText) findViewById(R.id.name);
        listView = (ListView) findViewById(R.id.list_view);

        Button btnSearch = (Button) findViewById(R.id.search);
        btnSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText name = new EditText(SearchItem.this);
                EditText desc = new EditText(SearchItem.this);

                dbHandler = new MyDbHandler(SearchItem.this, null, null, 1);
                Product product = dbHandler.findProduct(searchName.getText().toString());

                listView.setAdapter(new ArrayAdapter<Product>
                        (SearchItem.this, android.R.layout.simple_list_item_1, new ArrayList<Product>()));
                ((ArrayAdapter<Product>)listView.getAdapter()).add(product);
            }
        });

        Button btnCancel = (Button) findViewById(R.id.cancel);
        btnCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onDestroy() {
        dbHandler.close();
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }


}
