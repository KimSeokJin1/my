package space.space.first.recipes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import space.space.first.R;

public class Adapter extends RecyclerView.Adapter<Adapter.DataHolder> {

    private Context context;

    private OnClickListener onClickListener;//нажатие интерфейс

    private   List<ListItem> listItemArray;

    public Adapter(Context context, OnClickListener onClickListener,List<ListItem> listItemArray){
        this.context=context;
        this.onClickListener=onClickListener;
        this.listItemArray =listItemArray;
    }
    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {////рисовать итем
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {////загружаться данные

        holder.setData(listItemArray.get(position));
    }

    @Override
    public int getItemCount() {
        // сколько элеметов будет для отрисовки
        return listItemArray.size();
    }


    public class DataHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvText;
        private ImageButton imageButton;


        public DataHolder(@NonNull View itemView) {
            super(itemView);
            tvText= itemView.findViewById(R.id.tvText);
            imageButton= itemView.findViewById(R.id.imageButton);
            itemView.setOnClickListener(this);
        }

        public void setData(ListItem item) {
            //будет приходить состояние картинки и текст
            tvText.setText(item.getText());}

        @Override
        public void onClick(View view) {
            onClickListener.onItemClicked(getAdapterPosition());
        }
    }
    }