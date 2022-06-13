package space.space.first.recipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import space.space.first.R;

public class SecondDish extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView btMenu;
    RecyclerView recyclerView;
    private OnClickListener   onClickListener;
    private Adapter adapter2List;

    private List<ListItem> listData; //хранит элементы с лист итема
    private RecyclerView rcView;

    static ArrayList<String> arrayList = new ArrayList<>();
    MainAdapter1 adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_dish);
        new OnClickListener() {
            @Override
            public void onItemClicked(int pos) {
                
            }
        };
        init();

        drawerLayout =  findViewById(R.id.drawer_layout);
        btMenu =findViewById(R.id.bt_menu);
        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MainAdapter1(this, Recipes2.arrayList));

        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
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

    @Override
    protected void onPause() {
        super.onPause();
       Recipes2.closeDrawer(drawerLayout);
    }
}