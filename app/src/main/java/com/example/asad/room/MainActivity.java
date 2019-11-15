package com.example.asad.room;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user=new User();
        user.uid=9;
        user.firstName="asad";
        user.lastName="fareed";


       // mUserDao.deleteAll();
        ViewModel viewModel= ViewModelProviders.of(this).get(ViewModel.class);;

        viewModel.insert(user);

        //LiveData<List<User>> list= (LiveData<List<User>>) viewModel.getAllUsers();

        ViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable final List<User> users) {
                // Update the cached copy of the words in the adapter.

                if (users.size()>0) {
                    TextView textView = (TextView) findViewById(R.id.textview);
                    TextView textView2 = (TextView) findViewById(R.id.textview2);
                    User user1 = users.get(0);
                    textView.setText(user1.firstName);
                    textView2.setText(user1.lastName);
                }
            }
        });




    }
}
