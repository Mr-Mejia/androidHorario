package com.example.ejemplo;

public class Persona {



        private String nombre;
        private String apellido;
        private String imagenUrl;
        private String telefono;

        public Persona(String nombre, String apellido, String imagenUrl, String telefono) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.imagenUrl = imagenUrl;
            this.telefono = telefono;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public String getImagenUrl() {
            return imagenUrl;
        }

        public  String getTelefono(){ return  telefono; }


    }


