package space.space.first.visual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import space.space.first.MainActivity;
import space.space.first.R;

public class Shop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Window w = getWindow();
       // w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|//скрываем нижнюю панель
               // View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);// появляется поверх игры и исзчезает
        setContentView(R.layout.activity_shop);

        Button bacr = findViewById(R.id.bacr);
        bacr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Shop.this, MainActivityVisual.class);
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