package com.example.asad.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {User.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract UserDao UserDao();

    static AppDatabase getDatabase(final Context context) {

        AppDatabase INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "word_database")
                // Wipes and rebuilds instead of migrating
                // if no Migration object.
                // Migration is not part of this practical.
                .fallbackToDestructiveMigration()
                .build();

        return INSTANCE;
    }

    }


