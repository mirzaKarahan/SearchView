package com.mirzakarahan.searchviewsampel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mirzakarahan.searchview.ISearchView;
import com.mirzakarahan.searchview.SearchView;


public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.searchView);
        searchView.setBtnSearchEnable(true);
        searchView.setBtnSortEnable(true);
        searchView.setListener(new ISearchView() {
            @Override
            public void onSearch(String data) {
                Toast.makeText(getApplicationContext(),data,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSort() {
                //Open sort modal dialog vs.
            }
        });
    }
}
