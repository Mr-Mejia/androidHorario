package com.example.ejemplo;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class pantalla2 extends AppCompatActivity {

    private PersonaAdapter adapter;
    private List<Persona> personasList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pantalla2);


        // inicializar el ListView y la lista de personas
        ListView listView = findViewById(R.id.listView);
        personasList = new ArrayList<>();
        adapter = new PersonaAdapter(this, personasList);
        listView.setAdapter(adapter);

        // Llamar al método para recibir los datos
        recibirDatos();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private void recibirDatos() {
        // URL del servidor
        String url = "http://172.21.59.105:8081/lista1";

        // Crear la cola de solicitudes con Volley
        RequestQueue queue = Volley.newRequestQueue(this);

        // Crear la solicitud JSON
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                this::onResponse,
                error -> Log.e("Volley", "Error en la solicitud: " + error.toString()));

        // Agregar la solicitud a la cola
        queue.add(jsonArrayRequest);
    }

    private void onResponse(JSONArray response) {
        try {
            // Itera sobre los datos JSON y agrega las personas a la lista
            for (int i = 0; i < response.length(); i++) {
                JSONObject jsonObject = response.getJSONObject(i);
                String nombre = jsonObject.getString("nombre");
                String apellido = jsonObject.getString("apellido");
                String telefono = jsonObject.getString("telefono");
                String imagenUrl = jsonObject.getString("imagenurl");


                // Agregar persona a la lista
                personasList.add(new Persona(nombre, apellido, imagenUrl,telefono));
            }

            // Notificar al adaptador que los datos han cambiado
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}

