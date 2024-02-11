package com.ppam.primeministers.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ppam.primeministers.R
import com.ppam.primeministers.data.Leader


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeaderListScreen(leaders: List<Leader>,
                     onItemClick: (Leader) -> Unit,
                     isLoading: Boolean) {

val appBarHeight = dimensionResource(id = R.dimen.top_app_bar_height)

Scaffold(
    topBar = {
        TopAppBar(
            modifier = Modifier
                .background(Color.Green),
            title = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp)
                        .background(Color.Transparent)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.indian_leaders), // Replace "your_image" with the actual image resource
                        contentDescription = "Indian Leaders", // Provide proper content description
                        modifier = Modifier
                            .align(Alignment.Center)
                            .background(Color.Transparent)// Adjust size as needed
                    )
                }})
    }
) {
    LazyColumn(
        contentPadding = PaddingValues(top = appBarHeight)
    ) {
        items(leaders) { leader ->
            LeaderCard(leader = leader, onItemClick = onItemClick)
        }
    }

    if (isLoading) {
        CircularProgressIndicator(
            modifier =  Modifier.fillMaxWidth()
        )
    }
}
}
@Composable
fun LeaderCard(leader: Leader, onItemClick: (Leader) -> Unit) {
Card(
    modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable { onItemClick(leader) },
    elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
            )
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Display the leader image here
        Image(
            painter = painterResource(id = R.drawable.nehru), // Assuming you have image resources
            contentDescription = null, // Provide proper content description
            modifier = Modifier.size(72.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = leader.name, style = MaterialTheme.typography.bodyLarge)
            Text(text = leader.party, style = MaterialTheme.typography.bodySmall)
        }
        Spacer(modifier = Modifier.weight(1f)) // Spacer to push the following content to the end

        Image(
            painter = painterResource(id = R.drawable.right), // Assuming you have image resources
            contentDescription = null, // Provide proper content description
            modifier = Modifier.size(12.dp)
        )
    }
}
}

//@Preview
//@Composable
//fun PreviewLeaderListScreen() {
//    val leaders = DummyData.getDummyLeaders()
//
//    MyApplicationTheme {
//        LeaderListScreen(leaders = leaders, onLeaderSelected = {})
//    }
//}