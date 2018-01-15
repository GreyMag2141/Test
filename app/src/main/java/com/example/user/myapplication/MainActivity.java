package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] tests;
    ArrayAdapter<String> adapter;
    ListView listView;
    private Button button5;
    int select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        button5 = (Button) findViewById(R.id.button5);

        // получаем экземпляр элемента ListView
        listView = findViewById(R.id.ListView);
        final EditText editText = (EditText) findViewById(R.id.editText);
        // Создаём пустой массив для хранения имен котов
        final ArrayList<String> catNames = new ArrayList<>();

//       tests = new String[]{"Java", "Android", "Windows"};
//        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, tests);
//        listView.setAdapter(adapter);

        // Создаём адаптер ArrayAdapter, чтобы привязать массив к ListView
        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, catNames);
        // Привяжем массив через адаптер к ListView
        listView.setAdapter(adapter);

        // Прослушиваем нажатия клавиш
        editText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if (keyCode == KeyEvent.KEYCODE_ENTER) {
                        catNames.add(0, editText.getText().toString());
                        adapter.notifyDataSetChanged();
                        editText.setText("");
                        return true;
                    }
                return false;
            }
        });
    }
}

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick (AdapterView<?> parent, View itemClicked, int position, long id) {
//                Toast.makeText(getApplicationContext(), ((TextView) itemClicked).getText(), Toast.LENGTH_SHORT).show();
//
//                select =   position;
////                Intent intent = new Intent(MainActivityTest.this, MainActivityQuestion.class);
////                startActivity(intent);
//            }
//        });
//        button5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, MainActivityQuestion.class);
//                intent.putExtra("position",select);
//                startActivity(intent);
//            }
//        });
//    }
//}
