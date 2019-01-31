package com.example.thomaswilkinson.program1;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int continent=0;
    private NavigationView navView;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerlayout;
    private RecyclerView mRecyclerView;
    private CountryData ctryData;
    List<String> myList= new ArrayList<>();
    myAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        ctryData=new CountryData();
        mRecyclerView = (RecyclerView)findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new myAdapter(ctryData.getlist(0), R.layout.my_row, this );
        mRecyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = LayoutInflater.from(MainActivity.this);
                View promptsView = li.inflate(R.layout.custom_dialog, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        MainActivity.this);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.edit1);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("Add",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        ctryData.add(userInput.getText().toString(),continent);
                                        Collections.sort(ctryData.listsoflist.get(continent), new Comparator<String>() {
                                            @Override
                                            public int compare(String u1, String u2) {
                                                return u1.compareToIgnoreCase(u2);
                                            }
                                        });
                                        mRecyclerView = (RecyclerView)findViewById(R.id.list);
                                        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                                        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                                        mAdapter = new myAdapter(ctryData.getlist(continent), R.layout.my_row, MainActivity.this );
                                        mRecyclerView.setAdapter(mAdapter);
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        //standard navigation drawer setup.
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerToggle = new ActionBarDrawerToggle(this,  // host activity
                mDrawerlayout,  //drawerlayout object
                R.string.drawer_open,  //open drawer description  required!
                R.string.drawer_close) {  //closed drawer description

            //called once the drawer has closed.
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Categories");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            //called when the drawer is now open.
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle(R.string.app_name);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };


        navView = (NavigationView)findViewById(R.id.navview);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id == R.id.navigation_item_1)
                {
                    mRecyclerView = (RecyclerView)findViewById(R.id.list);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                    mAdapter = new myAdapter(ctryData.getlist(0), R.layout.my_row, MainActivity.this );
                    mRecyclerView.setAdapter(mAdapter);
                    mDrawerlayout.closeDrawers();
                    continent=0;
                    return true;
                }
                if(id == R.id.navigation_item_2)
                {
                    mRecyclerView = (RecyclerView)findViewById(R.id.list);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                    mAdapter = new myAdapter(ctryData.getlist(1), R.layout.my_row, MainActivity.this );
                    mRecyclerView.setAdapter(mAdapter);
                    mDrawerlayout.closeDrawers();
                    continent=1;
                    return true;
                }
                if(id == R.id.navigation_item_3)
                {
                    mRecyclerView = (RecyclerView)findViewById(R.id.list);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                    mAdapter = new myAdapter(ctryData.getlist(2), R.layout.my_row, MainActivity.this );
                    mRecyclerView.setAdapter(mAdapter);
                    mDrawerlayout.closeDrawers();
                    continent=2;
                    return true;
                }
                if(id == R.id.navigation_item_4)
                {
                    mRecyclerView = (RecyclerView)findViewById(R.id.list);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                    mAdapter = new myAdapter(ctryData.getlist(3), R.layout.my_row, MainActivity.this );
                    mRecyclerView.setAdapter(mAdapter);
                    mDrawerlayout.closeDrawers();
                    continent=3;
                    return true;
                }
                if(id == R.id.navigation_item_5)
                {
                    mRecyclerView = (RecyclerView)findViewById(R.id.list);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                    mAdapter = new myAdapter(ctryData.getlist(4), R.layout.my_row, MainActivity.this );
                    mRecyclerView.setAdapter(mAdapter);
                    mDrawerlayout.closeDrawers();
                    continent=4;
                    return true;
                }
                if(id == R.id.navigation_item_6)
                {
                    mRecyclerView = (RecyclerView)findViewById(R.id.list);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                    mAdapter = new myAdapter(ctryData.getlist(5), R.layout.my_row, MainActivity.this );
                    mRecyclerView.setAdapter(mAdapter);
                    mDrawerlayout.closeDrawers();
                    continent=5;
                    return true;
                }
                if(id == R.id.navigation_item_7)
                {
                    mRecyclerView = (RecyclerView)findViewById(R.id.list);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                    mAdapter = new myAdapter(ctryData.getlist(6), R.layout.my_row, MainActivity.this );
                    mRecyclerView.setAdapter(mAdapter);
                    mDrawerlayout.closeDrawers();
                    continent=6;
                    return true;
                }
                return false;
            }
        });

    }
}
