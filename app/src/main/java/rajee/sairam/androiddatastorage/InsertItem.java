package rajee.sairam.androiddatastorage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertItem extends AppCompatActivity {

    EditText name;
    EditText desc;
    EditText price;
    EditText review;

    MyDbHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_item);

        name = (EditText) findViewById(R.id.name);
        desc = (EditText) findViewById(R.id.desc);
        price = (EditText) findViewById(R.id.price);
        review = (EditText) findViewById(R.id.review);

        Button btnAdd = (Button) findViewById(R.id.add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler = new MyDbHandler(InsertItem.this, null, null, 1);
                Product product = new Product(name.getText().toString(),
                        desc.getText().toString(),
                        price.getText().toString(),
                        review.getText().toString());
                dbHandler.addProduct(product);

                //clear up UI
                name.setText("");
                desc.setText("");
                price.setText("");
                review.setText("");
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
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }


}
