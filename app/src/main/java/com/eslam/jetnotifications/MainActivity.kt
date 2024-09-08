package com.eslam.jetnotifications

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.eslam.jetnotifications.ui.theme.JetNotificationsTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetNotificationsTheme {
                Surface(modifier = Modifier.safeContentPadding()) {
                    Column(
                        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Button(onClick = { simpleNotification(this@MainActivity) }) {
                            Text(text = "Simple Notifications")
                        }
                        Spacer(modifier = Modifier.height(12.dp))

                        Button(onClick = { silentNotification(this@MainActivity) }) {
                            Text(text = "Silent Notification")
                        }
                        Spacer(modifier = Modifier.height(12.dp))

                        Button(onClick = { urgentNotification(this@MainActivity) }) {
                            Text(text = "Urgent Notification")
                        }
                        Spacer(modifier = Modifier.height(12.dp))

                        Button(onClick = { groupNotification(this@MainActivity) }) {
                            Text(text = "Group Notification")
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Button(onClick = { actionNotifications(this@MainActivity) }) {
                            Text(text = "Actions Notification")
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Button(onClick = { bigTextStyle(this@MainActivity) }) {
                            Text(text = "BigTExt Notification")
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Button(onClick = { bigPictureStyle(this@MainActivity) }) {
                            Text(text = "BigPicture Notification")
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Button(onClick = { inBoxStyle(this@MainActivity) }) {
                            Text(text = "Inbox Notification")
                        }
                        Spacer(modifier = Modifier.height(12.dp))

                        Button(onClick = { message(this@MainActivity) }) {
                            Text(text = "Message Notification")
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Button(onClick = { media(this@MainActivity) }) {
                            Text(text = "Media Notification")
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Button(onClick = { custom(this@MainActivity) }) {
                            Text(text = "Custom Notification")
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetNotificationsTheme {
        Greeting("Android")
    }
}