package space.space.first.noted;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import space.space.first.MainActivity;
import space.space.first.R;
import space.space.first.recipes.MainAdapter1;
import space.space.first.visual.MainActivityVisual;

public class Todo extends AppCompatActivity {

     EditText editText;
     Button btAdd;
     Button btReset;
     RecyclerView recyclerView;

     List<MainData>dataList = new ArrayList<>();
     LinearLayoutManager linearLayoutManager;
     RoomDB database;
     MAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

//Назначить переменнную
        editText= findViewById(R.id.edit_text);
        btAdd=findViewById(R.id.bt_add);
        btReset = findViewById(R.id.bt_reset);
        recyclerView= findViewById(R.id.recycler_view);

        //Добавляем базу данных
        database = RoomDB.getInstance(this);
        //Сохранить базу данных в списке
        dataList = database.mainDao().getAll();


        //Иницилизируем линию лэяуте manager
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        //Иницилизирум адптер
         adapter= new MAdapter(Todo.this,dataList);
         recyclerView.setAdapter(adapter);
         btAdd.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 //Добавляем строки из эдит текста
                 String sText = editText.getText().toString().trim();
                 //Проверяем состояние
                 if(!sText.equals("")){
                     //Когда текст не пустой
                     //иницилизируем главные данные
                     MainData data = new MainData();
                     data.setText(sText);
                     //Установим текст на основные данные
                     database.mainDao().insert(data);
                     //Очистить текст для редактирования
                     editText.setText("");
                     //уведомления о вставке данных
                     dataList.clear();
                     dataList.addAll(database.mainDao().getAll());
                     adapter.notifyDataSetChanged();

                 }
             }
         });
        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    database.mainDao().reset(dataList);
                    //Уведомления когда база данных удалена
                dataList.clear();
                dataList.addAll(database.mainDao().getAll());
                adapter.notifyDataSetChanged();
            }
        });








        Button back7= (Button) findViewById(R.id.back7);
        back7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Todo.this, MainActivityVisual.class);
                    //Есть намерение перейти из файла GameLevel в файл главного меню
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //Конец конструкции
            }
        });
    }
}