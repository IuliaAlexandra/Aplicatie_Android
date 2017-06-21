package com.example.iuliapopa.bac_androidapp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.iuliapopa.bac_androidapp.com.example.activity.LiceuActivity;
import com.example.iuliapopa.bac_androidapp.com.example.pojo.*;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdaugareElev extends AppCompatActivity {
    LiceePOJO liceePojo= new LiceePOJO();
    ObjectMapper objMapper = new ObjectMapper();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_elev);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getNumeLicee();
    }



    public void getNumeLicee(){


            // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2:8080/ProiectBAC/numeLicee";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        try {
                            Context context = getApplicationContext();
                            Toast toast = Toast.makeText(context, "licee", Toast.LENGTH_LONG);
                            toast.show();

                            liceePojo = objMapper.readValue(response, LiceePOJO.class);


                            List<String> listaLicee = new ArrayList<String>();

                            for (LiceuPOJO liceuPojo : liceePojo.getLicee()) {
                                listaLicee.add(liceuPojo.getNume());

                            }

                            Context context1 = getApplicationContext();
                            Toast toast1 = Toast.makeText(context1, "licee", Toast.LENGTH_LONG);
                            toast1.show();
                            Spinner spinnerLicee = (Spinner)findViewById(R.id.textLiceu);

                            ArrayAdapter adapter = new ArrayAdapter<String>(AdaugareElev.this,
                                    android.R.layout.simple_list_item_1, listaLicee);

                            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                            spinnerLicee.setAdapter(adapter);


                            spinnerLicee.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                                    String url = "http://10.0.2.2:8080/ProiectBAC/numeLicee";
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parentView) {
                                    // your code here
                                }

                            });

                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "doesn`tttt work", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        queue.add(stringRequest);
    }


}
