package com.example.login_page_auth.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login_page_auth.R
import com.example.login_page_auth.ui.login.IgViewModel
import com.example.login_page_auth.navigation.DestinasiNavigasi
import com.example.login_page_auth.navigation.DestinationScreen


object DestinasiHome : DestinasiNavigasi {
   override val route = "home"
   override val titleRes = "PetHome"
}
@Composable
fun HomeScreen(
   navController: NavController, viewmodel: IgViewModel
) {
   // Set background color for the entire screen
   Box(
      modifier = Modifier
         .clip(RoundedCornerShape(50.dp))
         .background(Color(255, 122, 122, 255))
         .fillMaxSize()
   ) {
      Row(
         modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
         horizontalArrangement = Arrangement.SpaceBetween
      ) {
         LargeCard(title = "Large Card") {
         }

         SmallCard(title = "Small Card") {
         }
      }
   }
}

@Composable
fun LargeCard(
   title: String,
   onNextButtonClicked: () -> Unit
) {
   Card(
      modifier = Modifier
         .fillMaxWidth()
         .padding(end = 8.dp) // Adjusted padding here
         .padding(bottom = 16.dp), // Added padding here
   ) {
      Column(
         modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center
      ) {
         Text(text = title, fontWeight = FontWeight.Bold)
         Spacer(modifier = Modifier.height(16.dp))
         Button(onClick = onNextButtonClicked) {
            Text(text = "Next")
         }
      }
   }
}

@Composable
fun SmallCard(
   title: String,
   onNextButtonClicked: () -> Unit
) {
   Card(
      modifier = Modifier
         .fillMaxWidth()
         .padding(end = 8.dp), // Adjusted padding here
   ) {
      Column(
         modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center
      ) {
         Text(text = title, fontWeight = FontWeight.Bold)
         Spacer(modifier = Modifier.height(16.dp))
         Button(onClick = onNextButtonClicked) {
            Text(text = "Next")
         }
      }
   }
}

