package com.example.ejemplo;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private ImageView studentImage;
    private TextView studentName, studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);
        studentImage = findViewById(R.id.studentImage);
        studentName = findViewById(R.id.studentName);
        studentId = findViewById(R.id.studentId);

        // Aquí podrías cargar los datos del estudiante desde una base de datos o API
        studentName.setText("Juan Pérez");
        studentId.setText("ID: 123456");
        // studentImage.setImageResource(...); // Configurar la imagen del estudiante si tienes una
    }
}
