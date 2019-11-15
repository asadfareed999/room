package com.example.asad.room;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ViewModel extends AndroidViewModel {

    private UserRepository mRepository;

    private static LiveData<List<User>> mAllUsers;

    public ViewModel (Application application) {
        super(application);
        mRepository = new UserRepository(application);
        mAllUsers = mRepository.getAllWords();
    }

    static LiveData<List<User>> getAllUsers() {
        return mAllUsers;
    }

    public void insert(User word) {
        mRepository.insert(word);
    }
}




