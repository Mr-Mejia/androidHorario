package com.example.ejemplo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PersonaAdapter extends ArrayAdapter<Persona> {
    private final Context context;

    public PersonaAdapter(Context context, List<Persona> personas) {
        super(context, 0, personas);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Verificar si la vista es nula, si es así, inflar el layout
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_persona, parent, false);
        }

        // Obtener la referencia al TextView y ImageView desde el layout
        TextView nombreTextView = convertView.findViewById(R.id.nombreTextView);
        TextView apellidoTextView = convertView.findViewById(R.id.apellidoTextView);
        TextView telefonoTextView = convertView.findViewById(R.id.telefonoTextView);
        ImageView imageView = convertView.findViewById(R.id.imageView); // Asegúrate de que este ID sea correcto

        // Verificar que las vistas no sean null
        if (nombreTextView == null || apellidoTextView == null || imageView == null) {
            throw new IllegalStateException("TextView or ImageView cannot be null");
        }

        // Obtener la persona actual
        Persona persona = getItem(position);

        // Configurar los valores de nombre, apellido y la imagen
        if (persona != null) {
            nombreTextView.setText(persona.getNombre());
            apellidoTextView.setText(persona.getApellido());
            telefonoTextView.setText(persona.getTelefono());

            // Cargar la imagen usando Picasso
            Picasso.get()
                    .load(persona.getImagenUrl())
                   // .placeholder(R.drawable.placeholder) // Imagen mientras carga
                    .error(R.drawable.error) // Imagen en caso de error
                    .into(imageView);

        }

        return convertView;
    }
}
