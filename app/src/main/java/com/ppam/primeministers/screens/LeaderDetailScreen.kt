package com.ppam.primeministers.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ppam.primeministers.data.Leader

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "DiscouragedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailedLeaderScreen(leader: Leader,
                         onBackPressed: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                title = {
                    Text(
                        text = leader.name,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Display the leader image here

            val context = LocalContext.current
            val resourceId = context.resources.getIdentifier(leader.logo, "drawable", context.packageName)

            Image(
                painter = painterResource(id = resourceId),
                contentDescription = "Prime Minister",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(vertical = 16.dp)
            )

            Text(
                text = leader.party,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Text(
                text = leader.rulingPeriod,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = leader.about,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}