package com.example.ejemplo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ActivityLogin extends AppCompatActivity {

    private EditText username, password;
    private Button loginButton;
    private TextView registerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        registerText = findViewById(R.id.registerButton);


        loginButton.setOnClickListener(v -> validarE());

        registerText.setOnClickListener(v -> registrarE());

    }


    @Override
    protected void onStart() {
        super.onStart();
    }


    private void validarE() {

        // Obtener los datos del formulario
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        // Crear la cola de solicitudes
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://172.21.59.105:8081/loginE";

        // Crear el objeto JSON con los datos a enviar
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username", username);
            jsonObject.put("password", password);
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

    private void registrarE() {

        // Obtener los datos del formulario
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        // Crear la cola de solicitudes
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://172.21.59.105:8081/guardarEstudiante";

        // Crear el objeto JSON con los datos a enviar
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("nombreCompleto", username);
            jsonObject.put("tipo_documento", username);
            jsonObject.put("documento", username);
            jsonObject.put("correo", username);
            jsonObject.put("contrasena", password);
            jsonObject.put("id_carnet", username);
            jsonObject.put("id_progama_academico", username);
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
