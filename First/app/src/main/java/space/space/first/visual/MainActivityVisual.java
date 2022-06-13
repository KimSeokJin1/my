package space.space.first.visual;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import space.space.first.MainActivity;
import space.space.first.R;
import space.space.first.noted.Todo;
import space.space.first.recipes.Recipes2;

public class MainActivityVisual extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_visual);

        CardView tools = (CardView) findViewById(R.id.tools);
        tools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(MainActivityVisual.this, Shop.class);

                    startActivity(intent);
                    finish();

                //Конец конструкции
            }
        });

        ImageButton button2= (ImageButton) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivityVisual.this, MainActivity.class);
                    //Есть намерение перейти из файла GameLevel в файл главного меню
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //Конец конструкции
            }
        });
        ImageButton button3= (ImageButton) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivityVisual.this, Todo.class);
                    //Есть намерение перейти из файла GameLevel в файл главного меню
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //Конец конструкции
            }
        });
        ImageButton button4= (ImageButton) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivityVisual.this, Recipes2.class);
                    //Есть намерение перейти из файла GameLevel в файл главного меню
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //Конец конструкции
            }
        });



    }}




