package space.space.first;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.slice.SliceItem;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.logging.Level;

public class Level1 extends AppCompatActivity {


    Dialog dialogEnd;

    public int numLeft;//доступ к переменной открые,тип переменной,название переменной//переменная для левой картинки
    public int numRight;//переменная для правой  картинки
    Array array= new Array();// Создали новый объект из класса эрей
    Random random=new Random();//Для генерации случайных чисел
   public int count=0;//счетчик правильных ответов

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //Создаем переменную text_levels
        TextView text_levels= findViewById(R.id.text_levels);
        text_levels.setText(R.string.level1);//Установили текст

        TextView tv = findViewById(R.id.task);
        tv.setText(R.string.level_one);

        final ImageView image_left= (ImageView)findViewById(R.id.image_left);// работать с это картинкой на языке Java(макет при режиме джава код не работает
       //код который скругляет углы
        image_left.setClipToOutline(true);
        final ImageView image_right= (ImageView)findViewById(R.id.image_right);// работать с это картинкой на языке Java
        //код который скругляет углы
        image_right.setClipToOutline(true);
        //Развернуть игру на весь экран - начало

        //Путь к левой TextView
        final TextView text_let=findViewById(R.id.text_left);
        //Путь к правой TextView
        final TextView text_right=findViewById(R.id.text_right);

        Window w= getWindow(); //Окно w= получить окно Окно w= получить окно
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //Развернуть игру на весь экран - конец
//вызов диалогового окна в начале игры




        dialogEnd =new Dialog(this);//создаем новое дилоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialogEnd.setContentView(R.layout.dialogend);//Путь к макету дилогового окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT ));//Прозрачный фон диалогового окна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false);//Окно нельзя закрыть кнопкой назад

        //Копка которая закрывает диалоговое окно-начало
        TextView btn_close2= (TextView)dialogEnd.findViewById(R.id.btn_close);
        btn_close2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Обрабатывае нажатие кнопки - начало
                try {//Вернутьсяназад к выбору уровня_ начало
                    Intent intent =new Intent(Level1.this,Level2.class);
                    //Намерение переход из окна первого уровня к меню выбора других уровней
                    startActivity(intent);//Старт намереней
                    finish();//Закрыть этот класс
                    //Вернуться назад к выбору уровня-конец
                }catch (Exception e){//Он нужен для того что, если сложная программа она выводила ошибки

                }
                dialogEnd.dismiss();//Закрываем диалоговое окно
            }
        });
        //Кнопка которая зкрывает диалоговое окно конец

        //Кнопка подолжить - начало
        Button button_continue2 =(Button) dialogEnd.findViewById(R.id.btn_continue);
        button_continue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogEnd.dismiss();
                try {//Вернутьсяназад к выбору уровня_ начало
                    Intent intent =new Intent(Level1.this,Level2.class);
                    //Намерение переход из окна первого уровня к меню выбора других уровней
                    startActivity(intent);//Старт намереней
                    finish();//Закрыть этот класс
                    //Вернуться назад к выбору уровня-конец
                }catch (Exception e){//Он нужен для того что, если сложная программа она выводила ошибки

                }

            }
        });
        //Кнопка подолжить - конец


        //Кнопка Назад -начало
        Button button2_back= (Button)findViewById(R.id.button2_back);
        button2_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {//Вернуться назад к выбору уровня_ начало
                    Intent intent =new Intent(Level1.this,GameLevels.class);
                    //Намерение переход из окна первого уровня к меню выбора других уровней
                    startActivity(intent);//Старт намереней
                    finish();//Закрыть этот класс
                    //Вернуться назад к выбору уровня-конец
                }catch (Exception e){//Он нужен для того что, если сложная программа она выводила ошибки

                }
                dialogEnd.dismiss();//Закрываем диалоговое окно
            }

        });
        //Массив для прогресса игры - начало
        final int [] progress={
                R.id.point1, R.id.point2, R.id.point3,R.id.point4,R.id.point5,R.id.point6,R.id.point7,
                R.id.point8,R.id.point9,R.id.point10,R.id.point11,R.id.point12,R.id.point13,R.id.point14,
                R.id.point15,R.id.point16,

        };
        //Массив для прогресса игры - конец

        //Подключаем анимацию- начало
        final Animation a= AnimationUtils.loadAnimation(Level1.this, R.anim.alpha);//Теперь через переменную а можно обратиться к файлу с анимацией и анимация будет загружена в java
        //Подключаем анимацию- конец

        numLeft=random.nextInt(array.image1.length-1);//генерирум случайное число от 0 до 9
        image_left.setImageResource(array.image1[numLeft]);
        //достаем из массива картинку
        text_let.setText(array.texts1[numLeft]);// Достаем из массива текст

        numRight=random.nextInt(array.image1.length-1);//генерирум случайное число от 0 до 9
        //Цикл
        while(numLeft==numRight){
            numRight=random.nextInt(array.image1.length-1);
        }
        image_right.setImageResource(array.image1[numRight]);
        //достаем из массива картинку
        text_right.setText(array.texts1[numRight]);//Достаем из массиа текст

//Обрабатываем нажатие на левую картинку - начало
        image_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Условие касание  картинки - начало
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    //Если коснулся картинки - начало
                    image_right.setEnabled(false);
                    if(numLeft>numRight){
                        image_left.setImageResource(R.drawable.image_true_);
                    }else{
                        image_left.setImageResource(R.drawable.img_false);
                    }
                }else if (event.getAction()==MotionEvent.ACTION_UP) {//палец убрали с картинки
                    //Если опустил палец - начало
                    if(numLeft>numRight){
                        //Если левая картинка больше
                        if (count < 16) {
                            count=count+1;
                        }
                            //Закрашиваем  прогресс серым цветом - начало
                            for (int i=0; i<16; i++){
                                TextView tv = findViewById(progress[i]);
                                tv.setBackgroundResource(R.drawable.style_points);
                            }
                            //Закрашиваем  прогресс серым цветом - начало
                        // Определяем правильный ответ и закрашиваем зеленым - начало
                            for(int i=0;i<count;i++) {
                                TextView tv = findViewById(progress[i]);
                                tv.setBackgroundResource(R.drawable.style_points_green);
                            }
                            //Закрашиваем прогресс серым цветом - конец
                        //Определяем правильный ответ и закрашиваем зеленым - конец
                    }else{
                        //Если левая картинка меньше
                        if(count>0){
                            if(count==1){
                                count=0;
                            }else{
                                count=count-2;
                            }
                        }
                        //Закрашиваем  прогресс серым цветом - начало
                        for (int i=0; i<15; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //Закрашиваем  прогресс серым цветом - начало
                        // Определяем правильный ответ и закрашиваем зеленым - начало
                        for(int i=0;i<count;i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Закрашиваем прогресс серым цветом - конец
                        //Определяем правильный ответ и закрашиваем зеленым - конец
                    }
                    //Если опустил палец - конец
                    if(count==16){
                        //ВЫХОД ИЗ УРОВНЯ

                        dialogEnd.show();//показать диалоговое окно
                    }else{
                        numLeft=random.nextInt(array.image1.length-1);//генерирум случайное число от 0 до 9
                        image_left.setImageResource(array.image1[numLeft]);
                        image_left.startAnimation(a);
                        //достаем из массива картинку
                           text_let.setText(array.texts1[numLeft]);// Достаем из массива текст

                        numRight=random.nextInt(array.image1.length-1);//генерирум случайное число от 0 до 9
                        //Цикл
                        while(numLeft==numRight){
                            numRight=random.nextInt(array.image1.length-1);
                        }
                        image_right.setImageResource(array.image1[numRight]);
                        image_right.startAnimation(a);
                        //достаем из массива картинку
                        text_right.setText(array.texts1[numRight]);//Достаем из массиа текст
                        image_right.setEnabled(true);//Включаем правую картинку
                    }
                }

                //Условие касание картинки - конец
                return true;
            }
        });
//Обрабатываем нажатие на левую картинку - начало


//Обрабатываем нажатие на правую картинку - конец

        image_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Условие касание  картинки - начало
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    //Если коснулся картинки - начало
                    image_left.setEnabled(false);//Блокируем левую картинку
                    if(numLeft<numRight){
                        image_right.setImageResource(R.drawable.image_true_);
                    }else{
                        image_right.setImageResource(R.drawable.img_false);
                    }
                }else if (event.getAction()==MotionEvent.ACTION_UP) {//палец убрали с картинки
                    //Если опустил палец - начало
                    if(numLeft<numRight){
                        //Если правая картинка больше
                        if (count < 16) {
                            count = count + 1;
                        }
                            //Закрашиваем  прогресс серым цветом - начало
                            for (int i=0; i<16; i++){
                                TextView tv = findViewById(progress[i]);
                                tv.setBackgroundResource(R.drawable.style_points);
                            }
                            //Закрашиваем  прогресс серым цветом - начало
                            // Определяем правильный ответ и закрашиваем зеленым - начало
                            for(int i=0;i<count;i++) {
                                TextView tv = findViewById(progress[i]);
                                tv.setBackgroundResource(R.drawable.style_points_green);
                            }
                            //Закрашиваем прогресс серым цветом - конец
                            //Определяем правильный ответ и закрашиваем зеленым - конец
                    }else{
                        //Если правая картинка меньше
                        if(count>0){
                            if(count==1){
                                count=0;
                            }else{
                                count=count-2;
                            }
                        }
                        //Закрашиваемпрогресс серым цветом - начало
                        for (int i=0; i<15; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //Закрашиваем прогресс серым цветом - конец
                        //Определяем правильный ответ и закрашиваем зеленым - начало
                        for (int i=0; i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }
                    //Если опустил палец - конец
                    if(count==16){
                        //ВЫХОД ИЗ УРОВНЯ

                        dialogEnd.show();//показать диалоговое окно
                    }else{
                        numLeft=random.nextInt(array.image1.length-1);//генерирум случайное число от 0 до 9

                        image_left.setImageResource(array.image1[numLeft]);
                        image_left.startAnimation(a);
                        //достаем из массива картинку
                        text_let.setText(array.texts1[numLeft]);// Достаем из массива текст

                        numRight=random.nextInt(array.image1.length-1);//генерирум случайное число от 0 до 9
                        //Цикл
                        while(numLeft==numRight){
                            numRight=random.nextInt(array.image1.length-1);
                        }

                        image_right.setImageResource(array.image1[numRight]);
                        image_right.startAnimation(a);
                        //достаем из массива картинку
                        text_right.setText(array.texts1[numRight]);//Достаем из массиа текст
                        image_left.setEnabled(true);//Включаем левую картинку
                    }
                }

                //Условие касание картинки - конец
                return true;
            }
        });

//Обрабатываем нажатие на правую картинку - конец

    }

    // Системна кнопка "Назад"-начало
    @Override
    public void onBackPressed(){
        try {//Вернуться назад к выбору уровня_ начало
            Intent intent =new Intent(Level1.this,GameLevels.class);
            //Намерение переход из окна первого уровня к меню выбора других уровней
            startActivity(intent);//Старт намереней
            finish();//Закрыть этот класс
            //Вернуться назад к выбору уровня-конец
        }catch (Exception e){//Он нужен для того что, если сложная программа она выводила ошибки

        }
    }
    // Системна кнопка "Назад"-конец
    }


