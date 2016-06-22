package com.example.son.a20160511_son;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        //Simple list view
        //1. Init Array datasource
        final String arr[]={"Teo","Ty","Bin","Bo"};
        //2. Referent Listview base on control id
        ListView lv=(ListView) findViewById(R.id.lvperson);
        //3. Assign Data source to ArrayAdapter
        ArrayAdapter<String>adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arr);
        //4. Assign adapter into ListView
        lv.setAdapter(adapter);
        final TextView txt=(TextView) findViewById(R.id.txtselection);
        //5. Establish cho Listview even
        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> arg0,
                                            View arg1,
                                            int arg2,
                                            long arg3) {
                        //đối số arg2 là vị trí phần tử trong Data Source (arr)
                        txt.setText("position :"+arg2+" ; value ="+arr[arg2]);
                    }
                });
*/
        List<Country> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, image_details));

        // Khi người dùng click vào các ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Country country = (Country) o;
                //Toast.makeText(MainActivity.this, "Selected :" + " " + country, Toast.LENGTH_LONG).show();

                Intent myIntent=new Intent(MainActivity.this,Country_detail.class);
                myIntent.putExtra("CountryName",country.getCountryName());
                myIntent.putExtra("Population",country.getPopulation());

                startActivity(myIntent);
            }
        });
    }

    private  List<Country> getListData() {
        List<Country> list = new ArrayList<>();
        Country vietnam = new Country("Vietnam", "vn", 98000000);
        Country usa = new Country("United States", "us", 320000000);
        Country russia = new Country("Russia", "ru", 142000000);


        list.add(vietnam);
        list.add(usa);
        list.add(russia);

        return list;
    }
}