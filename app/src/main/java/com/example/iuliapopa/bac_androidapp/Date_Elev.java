package com.example.iuliapopa.bac_androidapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class Date_Elev extends AppCompatActivity {

    int id;
    private ElevDTO elev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date__elev);
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
        Intent intent=getIntent();
        id= intent.getIntExtra("id",0);

        getDateElev(id);
    }

    public void updateView(){
        TextView tvNotaModerna=(TextView)this.findViewById(R.id.notaModerna);
        TextView tvElev=(TextView)this.findViewById(R.id.elev);
        TextView tvUnitate=(TextView)this.findViewById(R.id.unitate);
        TextView tvSpecializare=(TextView)this.findViewById(R.id.specializare);
        TextView tvNotaMaterna=(TextView)this.findViewById(R.id.notaMaterna);
        TextView tvNotaObligatorie=(TextView)this.findViewById(R.id.notaObligatorie);
        TextView tvNotaAlegere=(TextView)this.findViewById(R.id.notaAlegere);
        TextView tvContModerna=(TextView)this.findViewById(R.id.contModerna);
        TextView tvContObligatorie=(TextView)this.findViewById(R.id.contObligatorie);
        TextView tvContMaterna=(TextView)this.findViewById(R.id.contMaterna);
        TextView tvContAlegere=(TextView)this.findViewById(R.id.contAlegere);
        TextView tvFinalaModerna=(TextView)this.findViewById(R.id.finalaModerna);
        TextView tvFinalaMaterna=(TextView)this.findViewById(R.id.finaalaMaterna);
        TextView tvFinalaAlegere=(TextView)this.findViewById(R.id.finalaAlegere);
        TextView tvFinalaObligatorie=(TextView)this.findViewById(R.id.finalaObligatorie);
        TextView tvObligatorie=(TextView)this.findViewById(R.id.obligatorie);
        TextView tvAlegere=(TextView)this.findViewById(R.id.alegere);
        TextView tvMaterna=(TextView)this.findViewById(R.id.materna);
        TextView tvModerna=(TextView)this.findViewById(R.id.moderna);
        //TextView tvTotal=(TextView)this.findViewById(R.id.total);

        tvAlegere.setText(elev.getProbaAlegere().getNume());
        tvObligatorie.setText(elev.getProbaObligatorie().getNume());
        tvMaterna.setText(elev.getLimbaMaterna().getNume());
        tvModerna.setText(elev.getLimbaModerna().getNume());

        tvElev.setText(elev.getNume()+" "+elev.getInitialaTatalui()+" "+elev.getPrenume());
        tvSpecializare.setText(elev.getSpec().getNume());
        tvUnitate.setText(elev.getLiceu().getNume());

        tvNotaModerna.setText(String.valueOf(elev.getLimbaModerna().getNota()));
        tvNotaAlegere.setText(String.valueOf(elev.getProbaAlegere().getNota()));
        tvNotaMaterna.setText(String.valueOf(elev.getLimbaMaterna().getNota()));
        tvNotaObligatorie.setText(String.valueOf(elev.getProbaObligatorie().getNota()));

        tvContAlegere.setText(String.valueOf(elev.getProbaAlegere().getNotaContestatie()));
        tvContMaterna.setText(String.valueOf(elev.getLimbaMaterna().getNotaContestatie()));
        tvContModerna.setText(String.valueOf(elev.getLimbaModerna().getNotaContestatie()));
        tvContObligatorie.setText(String.valueOf(elev.getProbaObligatorie().getNotaContestatie()));


        tvFinalaAlegere.setText(String.valueOf(elev.getLimbaModerna().getNotaFinala()));
        tvFinalaMaterna.setText(String.valueOf(elev.getLimbaMaterna().getNotaFinala()));
        tvFinalaModerna.setText(String.valueOf(elev.getLimbaModerna().getNotaFinala()));
        tvFinalaObligatorie.setText(String.valueOf(elev.getProbaObligatorie().getNotaFinala()));

    }

    public void getDateElev(int id){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2:8080/ProiectBAC/getElevById";
        url=url.concat("/?id="+Integer.toString(id));
        Context ctx=getApplicationContext();
        Toast toast=Toast.makeText(ctx,url,Toast.LENGTH_LONG);
        toast.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ObjectMapper om=new ObjectMapper();
                        try {
                            elev=om.readValue(response,ElevDTO.class);
                            updateView();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, error.toString(), Toast.LENGTH_LONG);
                toast.show();
            }
        });
        queue.add(stringRequest);
    }
}
