package com.example.cafeteria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private HashMap<String, Integer> productosSeleccionados = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configura los botones de imagen para seleccionar productos
        configurarBotonProducto(R.id.imageButton2, "Producto 1", 50);
        configurarBotonProducto(R.id.imageButton3, "Producto 2", 30);
        configurarBotonProducto(R.id.imageButton4, "Producto 3", 20);

        findViewById(R.id.button3).setOnClickListener(v -> {
            if (productosSeleccionados.isEmpty()) {
                Toast.makeText(this, "Selecciona al menos un producto", Toast.LENGTH_SHORT).show();
            } else {
                abrirResumenCompra();
            }
        });
    }

    private void configurarBotonProducto(int idBoton, String nombreProducto, int precioProducto) {
        ImageButton botonProducto = findViewById(idBoton);
        botonProducto.setOnClickListener(v -> {
            int cantidadActual = productosSeleccionados.getOrDefault(nombreProducto, 0);
            productosSeleccionados.put(nombreProducto, cantidadActual + 1);
            Toast.makeText(this, nombreProducto + " añadido. Cantidad: " + (cantidadActual + 1), Toast.LENGTH_SHORT).show();
        });
    }

    private void abrirResumenCompra() {
        Intent intent = new Intent(MainActivity.this, ResumenCompraActivity.class);
        intent.putExtra("productosSeleccionados", productosSeleccionados);
        startActivity(intent);
    }
}
