package space.space.first.noted;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MainDao {
    //Вставка запрос
    @Insert(onConflict = REPLACE)
    void insert(MainData mainData);
    //Удаляем запрос
    @Delete
    void delete(MainData mainData);
    
    //Удаляем все запросы
    @Delete
    void reset(List<MainData> mainData);
    
    //Обнавляем запрос
    @Query("UPDATE table_name SET text=:sText WHERE ID =:sID")
    void update(int sID, String sText);

    //Получить все данные запроса
    @Query("SELECT * FROM table_name")
    List<MainData> getAll();
}
