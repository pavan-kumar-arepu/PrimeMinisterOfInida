package com.ppam.myapplication.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ppam.myapplication.data.DummyData
import com.ppam.myapplication.data.Leader
import com.ppam.myapplication.ui.theme.MyApplicationTheme

@Composable
fun LeaderListScreen(
    leaders: List<Leader>,
    onLeaderSelected: (Leader) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "List of Leaders",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LazyColumn {
            items(leaders) { leader ->
                LeaderListItem(leader = leader, onClick = { onLeaderSelected(leader) })
            }
        }
    }
}

@Composable
fun LeaderListItem(
    leader: Leader,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Text(
            text = leader.name,
            fontSize = 18.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun PreviewLeaderListScreen() {
    val leaders = DummyData.getDummyLeaders()

    MyApplicationTheme {
        LeaderListScreen(leaders = leaders, onLeaderSelected = {})
    }
}