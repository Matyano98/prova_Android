package com.mateusyano.prova_android;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Produto.class}, version = 1)
public abstract class ProdutoDatabase extends RoomDatabase {
    private static ProdutoDatabase instancia;

    public abstract ProdutoDao produtoDao();

    public static synchronized ProdutoDatabase getInstancia(Context contexto) {
        if (instancia == null) {
            instancia = Room.databaseBuilder(contexto.getApplicationContext(),
                    ProdutoDatabase.class, "produto_db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instancia;
    }
}
