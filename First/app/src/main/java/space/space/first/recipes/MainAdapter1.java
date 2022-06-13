package space.space.first.recipes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import space.space.first.R;

public class MainAdapter1  extends RecyclerView.Adapter<MainAdapter1.ViewHolder>{
    Activity activity;

    ArrayList<String> arrayList;

    public MainAdapter1(Activity activity, ArrayList<String> arrayList) {
        this.activity= activity;
        this.arrayList =arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_drawer_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(arrayList.get(position));

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                switch (position){
                    case 0:
                        activity.startActivity(new Intent(activity,Favourites.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 1:
                        activity.startActivity(new Intent(activity,Entree.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 2:
                        activity.startActivity(new Intent(activity,SecondDish.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 3:
                        activity.startActivity(new Intent(activity,Dessert.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;

                }
            }
        });
    }


    @Override
    public int getItemCount() {

            return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Назначить переменную
            textView=itemView.findViewById(R.id.text_view);

        }
    }
}
