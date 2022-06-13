package space.space.first.noted;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//Добавляем субъекты(сущность)
@Database(entities = {MainData.class},version = 1, exportSchema = false)
public abstract class RoomDB  extends RoomDatabase {
    private static RoomDB database;
    private static String DATEBASE_NAME ="database";

    public synchronized static RoomDB getInstance(Context context){
        if(database==null){
            database= Room.databaseBuilder(context.getApplicationContext()
                    ,RoomDB.class,DATEBASE_NAME)//имя
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }
    public abstract MainDao mainDao();
}
