package com.primerparcial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormularioProducto()
        }
    }
}

@Composable
fun FormularioProducto() {
    var nombreProducto by remember { mutableStateOf("") }
    var precioProducto by remember { mutableStateOf("") }
    var categoriaSeleccionada by remember { mutableStateOf("Electrónica") }

    val categorias = listOf("Electrónica", "Ropa", "Alimentos")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = nombreProducto,
            onValueChange = { nombreProducto = it },
            label = { Text("Nombre del Producto") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = precioProducto,
            onValueChange = { precioProducto = it },
            label = { Text("Precio") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = "Categoría")
        categorias.forEach { categoria ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (categoria == categoriaSeleccionada),
                    onClick = { categoriaSeleccionada = categoria }
                )
                Text(text = categoria)
            }
        }

        Button(
            onClick = {
                nombreProducto = ""
                precioProducto = ""
                categoriaSeleccionada = "Electrónica"
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Enviar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormularioProductoPreview() {
    FormularioProducto()
}