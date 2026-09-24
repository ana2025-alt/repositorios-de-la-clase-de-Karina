package com.example.myapplicationanaanselmi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Usamos MaterialTheme directamente sin depender del archivo de tema generado
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavegacionPantallas()
                }
            }
        }
    }
}

@Composable
fun NavegacionPantallas() {
    var pantallaActual by remember { mutableStateOf("pantalla1") }
    val textoMensaje = "Hola como estas"

    when (pantallaActual) {
        "pantalla1" -> {
            PantallaUno(
                texto = textoMensaje,
                onSiguiente = { pantallaActual = "pantalla2" }
            )
        }
        "pantalla2" -> {
            PantallaDos(
                textoRecibido = textoMensaje,
                onVolver = { pantallaActual = "pantalla1" }
            )
        }
    }
}

@Composable
fun PantallaUno(texto: String, onSiguiente: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Pantalla 1",
            fontSize = 24.sp,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Texto a enviar: $texto",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onSiguiente) {
            Text(text = "Ir a la siguiente pantalla")
        }
    }
}

@Composable
fun PantallaDos(textoRecibido: String, onVolver: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Pantalla 2",
            fontSize = 24.sp,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "El valor del texto es:",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = textoRecibido,
            fontSize = 22.sp,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onVolver) {
            Text(text = "Volver")
        }
    }
}
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Composable
fun VistaPreviaApp() {
    MaterialTheme {
        NavegacionPantallas()
    }
}