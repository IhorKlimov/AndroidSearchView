package com.myhexaville.androidsearchview2;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.myhexaville.androidsearchview2.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<String> countries;
    private Adapter adapter;
    private String currentQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);

        setupList();

        setupSearch();
    }

    private void setupSearch() {
        binding.searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                processQuery(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                processQuery(newText);
                return true;
            }
        });

        binding.searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                binding.searchView.setQuery(currentQuery, false);
            }

            @Override
            public void onSearchViewClosed() {
                currentQuery = "";
                adapter.setCountries(countries);
            }
        });
    }

    private void processQuery(String query) {
        currentQuery = query;
        ArrayList<String> result = new ArrayList<>();

        // case insensitive search
        for (String country : countries) {
            if (country.toLowerCase().contains(query.toLowerCase())) {
                result.add(country);
            }
        }

        adapter.setCountries(result);
    }

    private void setupList() {
        populateCountries();

        adapter = new Adapter(this, countries);
        binding.include.list.setLayoutManager(new LinearLayoutManager(this));
        binding.include.list.setAdapter(adapter);
    }

    private void populateCountries() {
        countries = new ArrayList<>();

        countries.add("Afghanistan");
        countries.add("Albania");
        countries.add("Algeria");
        countries.add("Andorra");
        countries.add("Angola");
        countries.add("Anguilla");
        countries.add("Antigua & Barbuda");
        countries.add("Argentina");
        countries.add("Armenia");
        countries.add("Australia");
        countries.add("Austria");
        countries.add("Azerbaijan");
        countries.add("Bahamas");
        countries.add("Bahrain");
        countries.add("Bangladesh");
        countries.add("Barbados");
        countries.add("Belarus");
        countries.add("Belgium");
        countries.add("Belize");
        countries.add("Benin");
        countries.add("Bermuda");
        countries.add("Bhutan");
        countries.add("Bolivia");
        countries.add("Bosnia & Herzegovina");
        countries.add("Botswana");
        countries.add("Brazil");
        countries.add("Brunei Darussalam");
        countries.add("Bulgaria");
        countries.add("Burkina Faso");
        countries.add("Myanmar/Burma");
        countries.add("Burundi");
        countries.add("Cambodia");
        countries.add("Cameroon");
        countries.add("Canada");
        countries.add("Cape Verde");
        countries.add("Cayman Islands");
        countries.add("Central African Republic");
        countries.add("Chad");
        countries.add("Chile");
        countries.add("China");
        countries.add("Colombia");
        countries.add("Comoros");
        countries.add("Congo");
        countries.add("Costa Rica");
        countries.add("Croatia");
        countries.add("Cuba");
        countries.add("Cyprus");
        countries.add("Czech Republic");
        countries.add("Democratic Republic of the Congo");
        countries.add("Denmark");
        countries.add("Djibouti");
        countries.add("Dominican Republic");
        countries.add("Dominica");
        countries.add("Ecuador");
        countries.add("Egypt");
        countries.add("El Salvador");
        countries.add("Equatorial Guinea");
        countries.add("Eritrea");
        countries.add("Estonia");
        countries.add("Ethiopia");
        countries.add("Fiji");
        countries.add("Finland");
        countries.add("France");
        countries.add("French Guiana");
        countries.add("Gabon");
        countries.add("Gambia");
        countries.add("Georgia");
        countries.add("Germany");
        countries.add("Ghana");
        countries.add("Great Britain");
        countries.add("Greece");
        countries.add("Grenada");
        countries.add("Guadeloupe");
        countries.add("Guatemala");
        countries.add("Guinea");
        countries.add("Guinea-Bissau");
        countries.add("Guyana");
        countries.add("Haiti");
        countries.add("Honduras");
        countries.add("Hungary");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        binding.searchView.setMenuItem(menu.findItem(R.id.action_search));
        return true;
    }

}
