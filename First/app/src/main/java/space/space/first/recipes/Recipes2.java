package space.space.first.recipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import space.space.first.MainActivity;
import space.space.first.R;
import space.space.first.visual.MainActivityVisual;

public class Recipes2 extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageView btMenu;
    RecyclerView recyclerView;
    private OnClickListener   onClickListener;
    private Adapter adapter2List;

    private List<ListItem> listData; //хранит элементы с лист итема
    private RecyclerView rcView;

    static ArrayList<String> arrayList = new ArrayList<>();
    MainAdapter1 adapter;


    public static void closeDrawer(DrawerLayout drawerLayout) {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes2);

        setOnClickListener();
        init();

        drawerLayout =  findViewById(R.id.drawer_layout);
        btMenu =findViewById(R.id.bt_menu);
        recyclerView = findViewById(R.id.recycler_view);

        arrayList.clear();

        arrayList.add("Первое ");
        arrayList.add("Второе ");
        arrayList.add("Десерты");
        arrayList.add("Избраное");


        adapter =new MainAdapter1(this,arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
    private void init()
    {
        rcView=findViewById(R.id.rcView);
        rcView.setLayoutManager(new LinearLayoutManager(this));
        listData=new ArrayList<>();
        //Расположение элементов в rcview так как оно может быть разным

        //заполнение
        String[] firstArray= getResources().getStringArray(R.array.first);
        for(int i=0; i<firstArray.length;i++){
            ListItem item =new ListItem();
            item.setText(firstArray[i]);
            item.setFavorite(false);
            listData.add(item);
        }

        adapter2List = new Adapter(this,onClickListener,listData);
        rcView.setAdapter(adapter2List);//присваем
    }

    private void setOnClickListener() {
        onClickListener = new OnClickListener() {
            @Override
            public void onItemClicked(int pos) {
                Toast.makeText(Recipes2.this, "Position=" + pos, Toast.LENGTH_SHORT).show();

            }
        };
       ImageView bt= (ImageView) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Recipes2.this, MainActivityVisual.class);
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