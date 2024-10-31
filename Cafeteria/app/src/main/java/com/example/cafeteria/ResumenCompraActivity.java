package com.example.cafeteria;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

public class ResumenCompraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_compra);

        TextView resumenCompraTextView = findViewById(R.id.textViewResumenCompra);
        HashMap<String, Integer> productosSeleccionados = (HashMap<String, Integer>) getIntent().getSerializableExtra("productosSeleccionados");

        int total = 0;
        StringBuilder resumenCompra = new StringBuilder("Resumen de la compra:\n\n");

        for (String producto : productosSeleccionados.keySet()) {
            int cantidad = productosSeleccionados.get(producto);
            int precio = getPrecioProducto(producto) * cantidad;
            total += precio;
            resumenCompra.append(producto).append(" x").append(cantidad).append(" - $").append(precio).append("\n");
        }

        resumenCompra.append("\nTotal: $").append(total);
        resumenCompraTextView.setText(resumenCompra.toString());
    }

    private int getPrecioProducto(String producto) {
        switch (producto) {
            case "Producto 1": return 50;
            case "Producto 2": return 30;
            case "Producto 3": return 20;
            default: return 0;
        }
    }
}
