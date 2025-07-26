package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class DriverActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DriverScreen(
                        modifier = Modifier.padding(innerPadding),
                        navigateToCallScreen = { navigateToCallScreen() }
                    )
                }
            }
        }
    }

    private fun navigateToCallScreen() {
        val intent = Intent(this, CallScreenActivity::class.java)
        startActivity(intent)
    }
}

@Composable
fun DriverScreen(modifier: Modifier = Modifier, navigateToCallScreen: () -> Unit) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Driver Dashboard",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        
        Spacer(modifier = Modifier.height(32.dp))

        // Buttons
        // Row(
        //     modifier = Modifier
        //         .fillMaxWidth()
        //         .padding(16.dp),
        //     horizontalArrangement = Arrangement.spacedBy(12.dp)
        // ) {
        //     // Call Driver Button
        //     OutlinedButton(
        //         onClick = { 
        //             navigateToCallScreen()
        //         },
        //         modifier = Modifier
        //             .weight(1f)
        //             .padding(vertical = 8.dp),
        //         shape = RoundedCornerShape(8.dp),
        //         border = ButtonDefaults.outlinedButtonBorder.copy(
        //             width = 1.dp
        //         )
        //     ) {
        //         Icon(
        //             imageVector = Icons.Default.Phone,
        //             contentDescription = null,
        //             modifier = Modifier.padding(end = 8.dp)
        //         )
        //         Text("Call Driver")
        //     }
            
        //     // Call Support Button
        //     OutlinedButton(
        //         onClick = { 
        //             navigateToCallScreen()
        //         },
        //         modifier = Modifier
        //             .weight(1f)
        //             .padding(vertical = 8.dp),
        //         shape = RoundedCornerShape(8.dp),
        //         border = ButtonDefaults.outlinedButtonBorder.copy(
        //             width = 1.dp
        //         )
        //     ) {
        //         Icon(
        //             imageVector = Icons.Default.Call,
        //             contentDescription = null,
        //             modifier = Modifier.padding(end = 8.dp)
        //         )
        //         Text("Call Support")
        //     }
        // }
    }
}

@Preview(showBackground = true)
@Composable
fun DriverScreenPreview() {
    MyApplicationTheme {
        DriverScreen(navigateToCallScreen = {})
    }
}