package space.space.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import space.space.first.visual.MainActivityVisual;

public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=(Button) findViewById(R.id.button);//кнопка с именем button и также это кнока находиться на экране ее можно найти по айди
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent =new Intent(MainActivity.this,GameLevels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }

            }//чтобыигра не вылетала
        });
        Button btton5=(Button) findViewById(R.id.btton5);
        btton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent intent =new Intent(MainActivity.this,MainActivityVisual.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }

            }

        });
    }





        // Системна кнопка "Назад"-конец
    }