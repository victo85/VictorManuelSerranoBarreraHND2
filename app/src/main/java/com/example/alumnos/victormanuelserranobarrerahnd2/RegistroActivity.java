package com.example.alumnos.victormanuelserranobarrerahnd2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alumnos.victormanuelserranobarrerahnd2.bein.Preferencias;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.UsuarioBean;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener{

        private EditText editEmail, editNombre, editApellidos, editPass;
        private Button btnGuardar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registro);

            editNombre = (EditText) findViewById(R.id.txtNombre);
            editApellidos = (EditText) findViewById(R.id.txtApellidos);
            editEmail = (EditText) findViewById(R.id.textEmail);
            editPass = (EditText) findViewById(R.id.txtContraseña);
            btnGuardar = (Button) findViewById(R.id.btnRegistro);

            btnGuardar.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            String nombre = editNombre.getText().toString();
            String apellidos = editApellidos.getText().toString();
            String email = editEmail.getText().toString();
            String pass = editPass.getText().toString();


            if(email!=null && nombre!=null && apellidos!=null && pass!=null &&
                    !email.isEmpty() && !nombre.isEmpty() && !apellidos.isEmpty() && !pass.isEmpty()){
                UsuarioBean usuarioBean = new UsuarioBean(apellidos, pass, email, nombre);


                Preferencias preferencias = new Preferencias(RegistroActivity.this);
                preferencias.setUsuario(usuarioBean);

                Toast.makeText(RegistroActivity.this,
                        "El usuario se ha guardado correctamente",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(RegistroActivity.this,
                        "Todos los datos son obligatorios",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
