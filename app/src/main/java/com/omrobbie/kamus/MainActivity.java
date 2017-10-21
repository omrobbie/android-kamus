package com.omrobbie.kamus;

import android.database.SQLException;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.omrobbie.kamus.adapter.SearchAdapter;
import com.omrobbie.kamus.data.helper.KamusHelper;
import com.omrobbie.kamus.data.model.KamusModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer_layout;

    @BindView(R.id.nav_view)
    NavigationView nav_view;

    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;

    private KamusHelper kamusHelper;
    private SearchAdapter adapter;

    private ArrayList<KamusModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer_layout.setDrawerListener(toggle);
        toggle.syncState();

        nav_view.setNavigationItemSelectedListener(this);

        kamusHelper = new KamusHelper(this);

        setupList();
        loadData(true);
        nav_view.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_english_indonesia) {
            loadData(true);
        } else if (id == R.id.nav_indonesia_english) {
            loadData(false);
        }

        drawer_layout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setupList() {
        adapter = new SearchAdapter();
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.setAdapter(adapter);
    }

    private void loadData(boolean isEnglish) {
        try {
            kamusHelper.open();
            list = kamusHelper.getAllData(isEnglish);

            if (isEnglish) {
                getSupportActionBar().setSubtitle(getResources().getString(R.string.english_indonesia));
            } else {
                getSupportActionBar().setSubtitle(getResources().getString(R.string.indonesia_english));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            kamusHelper.close();
        }
        adapter.replaceAll(list);
    }
}
