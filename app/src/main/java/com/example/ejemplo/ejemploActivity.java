package com.example.ejemplo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
//import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ejemploActivity extends AppCompatActivity {

    // variables envío de datos
    private EditText nombreEditText;
    private EditText apellidoEditText;
    private EditText urll;
    private EditText telefono1;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejemplo);


        // Inicializar las vistas
        nombreEditText = findViewById(R.id.nombreEditText);
        apellidoEditText = findViewById(R.id.apellidoEditText);
        urll = findViewById(R.id.url2);
        telefono1 = findViewById(R.id.telefono);
        Button enviarButton = findViewById(R.id.enviarButton);


        enviarButton.setOnClickListener(v -> enviartext());

        Button buttonsiguiente = findViewById(R.id.button1);

        buttonsiguiente.setOnClickListener(v -> {
            Intent intent = new Intent(ejemploActivity.this, pantalla2.class);
            startActivity(intent);
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
    }



    private void enviartext() {

        // Obtener los datos del formulario
        String nombre = nombreEditText.getText().toString();
        String apellido = apellidoEditText.getText().toString();
        String url2 = urll.getText().toString();
        String telefono = telefono1.getText().toString();

        // Crear la cola de solicitudes
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://172.21.59.105:8081/lista1";

        // Crear el objeto JSON con los datos a enviar
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("nombre", nombre);
            jsonObject.put("apellido", apellido);
            jsonObject.put("imagenurl", url2);
            jsonObject.put("telefono", telefono);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Crear la solicitud POST con JsonObjectRequest
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject,
                response -> {
                    // Manejar la respuesta del servidor
                    Log.d("Volley", "Response: " + response.toString());
                },
                error -> {
                    // Manejar el error
                    Log.e("Volley", "Error: " + error.toString());
                });

        // Agregar la solicitud a la cola
        queue.add(jsonObjectRequest);
    }

}




