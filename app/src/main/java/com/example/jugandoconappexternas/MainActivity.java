package com.example.jugandoconappexternas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btnLanzar,btnLanzarMapa,btnLanzaW;
EditText url;
String coord = "38.7220308,-5.2212916";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLanzar = findViewById(R.id.btnLanzar);
        btnLanzarMapa = findViewById(R.id.btnLanzarMapa);
        url = findViewById(R.id.url);
        btnLanzaW = findViewById(R.id.btnLanzaW);

        btnLanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url.getText().toString()));

                Intent seleccionar = Intent.createChooser(intent,"Elige tu navegador favorito");

                startActivity(seleccionar);
            }
        });

        btnLanzarMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:"+coord));

                startActivity(intent);
            }
        });

        btnLanzaW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"Buenos dias");
                intent.setPackage("com.whatsapp");

                try{
                    startActivity(intent);
                }catch (ActivityNotFoundException e)
                {
                    Toast.makeText(MainActivity.this, "Debes instalar Whatsapp",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}