package com.example.asad.room;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class UserRepository {

    private UserDao mUserDao;
    private LiveData<List<User>> mAllWords;

    UserRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mUserDao = db.UserDao();
        mAllWords = mUserDao.getAll();
    }

    LiveData<List<User>> getAllWords() {
        return mAllWords;
    }

    public void insert (User word) {
        new insertAsyncTask(mUserDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao mAsyncTaskDao;

        insertAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.deleteAll();
            mAsyncTaskDao.insertAll(params[0]);
            return null;
        }
    }
}
