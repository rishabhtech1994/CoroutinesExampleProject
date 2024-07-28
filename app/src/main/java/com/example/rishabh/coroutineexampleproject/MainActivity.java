package com.example.rishabh.coroutineexampleproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

   // val viewModel: MainActivityViewModel by viewModels()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        /*viewModel.data.observe(this, Observer { data ->
                textView.text = data
        })

        // Trigger data fetch
        viewModel.fetchData()*/




    }
}