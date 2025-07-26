package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RoleSelectionScreen(
                        modifier = Modifier.padding(innerPadding),
                        navigateToCustomer = { navigateToCustomer() },
                        navigateToDriver = { navigateToDriver() }
                    )
                }
            }
        }
    }

    private fun navigateToCustomer() {
        val intent = Intent(this, CustomerActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToDriver() {
        val intent = Intent(this, DriverActivity::class.java)
        startActivity(intent)
    }
}

@Composable
fun RoleSelectionScreen(
    modifier: Modifier = Modifier,
    navigateToCustomer: () -> Unit,
    navigateToDriver: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Select your role",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        
        Button(
            onClick = { navigateToDriver() },
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("I am a Driver", Modifier.padding(vertical = 8.dp))
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = { navigateToCustomer() },
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("I am a Customer", Modifier.padding(vertical = 8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RoleSelectionPreview() {
    MyApplicationTheme {
        RoleSelectionScreen(
            navigateToCustomer = {},
            navigateToDriver = {}
        )
    }
}