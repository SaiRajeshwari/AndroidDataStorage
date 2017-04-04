package rajee.sairam.androiddatastorage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnInsert = (Button) findViewById(R.id.insert);
        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent insertIntent = new Intent(MainActivity.this, InsertItem.class);
                startActivity(insertIntent);
            }
        });

        Button btnSearch = (Button) findViewById(R.id.search);
        btnSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(MainActivity.this, SearchItem.class);
                startActivity(searchIntent);
            }
        });

    }



}
