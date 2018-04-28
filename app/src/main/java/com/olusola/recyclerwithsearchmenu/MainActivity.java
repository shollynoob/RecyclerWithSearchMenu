package com.olusola.recyclerwithsearchmenu;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    String[] names ={"Taiwo", "Ojo", "Ade","Kemi","Sogo","Oke","Idowu", "David", "Oke", "Fred","Chuks","Sunday", "Mathhew", "Friday", "Edafe", "Henry"};
    int[] images = {R.drawable.abacus, R.drawable.abacus,R.drawable.abacus,R.drawable.abacus,R.drawable.abacus,R.drawable.abacus,R.drawable.abacus, R.drawable.abacus, R.drawable.abacus,R.drawable.abacus,R.drawable.abacus,R.drawable.abacus,R.drawable.abacus,R.drawable.abacus,R.drawable.abacus,R.drawable.abacus};
    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<RegisterList> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        int count = 0;
        for (String Name: names){
            arrayList.add(new RegisterList(Name, images[count]));
            count++;
        }

        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        newText = newText.toLowerCase();
        ArrayList<RegisterList> newList = new ArrayList<>();

        for (RegisterList registerList: arrayList){
            String names = registerList.getNames().toLowerCase();
            if (names.contains(newText))
                newList.add(registerList);
        }
        adapter.setFilter(newList);
        return true;
    }
}
