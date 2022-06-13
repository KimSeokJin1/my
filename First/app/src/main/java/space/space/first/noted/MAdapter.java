package space.space.first.noted;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import space.space.first.R;

public class MAdapter extends RecyclerView.Adapter<MAdapter.ViewHolder>  {

    private List<MainData>dataList;
    private Activity context;
    private RoomDB  database;

    //Создаем конструктор


    public MAdapter( Activity context,List<MainData> dataList ) {
        this.dataList = dataList;
        this.context = context;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_main,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Основные даннные
        MainData data =dataList.get(position);
        //Основные база данных
        database=RoomDB.getInstance(context);
        //Устанавливаем  текст
        holder.textView.setText((data.getText()));

        holder.btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Добавляем базу данных
                MainData d = dataList.get(holder.getAdapterPosition());
                //Получаем id
                int sID =d.getID();
                //Получаем текст
                String sText = d.getText();

                //Добавляем диалог
                Dialog dialog =new Dialog(context);

                dialog.setContentView(R.layout.dialog_update);
                //Добавляем ширину
                int width = WindowManager.LayoutParams.MATCH_PARENT;
                //Добавляем высоту
                int height = WindowManager.LayoutParams.WRAP_CONTENT;
                //Лэяут
                dialog.getWindow().setLayout(width,height);
                //Показываем диалоговое окно
                dialog.show();

                //Создать  и назначить переменную
                EditText editText = dialog.findViewById(R.id.edit_text);
                Button btUpdate= dialog.findViewById(R.id.bt_update);

                //Набираем текст на эдит текст
                editText.setText(sText);

                btUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        //Возьмем текст из эдит текста
                        String uText = editText.getText().toString().trim();
                        //Обновляем текст в базе данных
                        database.mainDao().update(sID,uText);
                        //Уведобление когда данные обновляються
                        dataList.clear();
                        dataList.addAll(database.mainDao().getAll());
                        notifyDataSetChanged();

                    }
                });


            }
        });
        holder.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Создаем главные данные
                MainData d =  dataList.get(holder.getAdapterPosition());
                //Удаляем текст из базы данных
                database.mainDao().delete(d);
                //Уведобление когда в база данных удалена
                int position = holder.getAdapterPosition();
                dataList.remove(position);
                notifyItemRemoved(position);
                notifyItemChanged(position,dataList.size());
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView btEdit;
        ImageView btDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Назначаем переменную
            textView= itemView.findViewById(R.id.text_view);
            btEdit=itemView.findViewById(R.id.bt_edit);
            btDelete=itemView.findViewById(R.id.bt_delet);



        }
    }
}
