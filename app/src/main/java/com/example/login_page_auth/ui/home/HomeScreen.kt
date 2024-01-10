package com.example.login_page_auth.ui.home

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.login_page_auth.ui.login.IgViewModel
import com.example.login_page_auth.navigation.DestinasiNavigasi
import com.example.login_page_auth.navigation.DestinationScreen




@Composable
fun HomeScreen(navController: NavController) {
   // Set background color for the entire screen
   Box(
      modifier = Modifier
         .clip(RoundedCornerShape(50.dp))
         .background(Color(255, 122, 122, 255))
         .fillMaxSize()
   ) {
      Column(
         verticalArrangement = Arrangement.Center,
         modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
      ) {
         Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
               .fillMaxSize()
               .padding(16.dp)
         ) {
            // Large card at the top
            LargeCard("Large Card", navController = navController)


            // Two small cards below, arranged horizontally
            Row(
               modifier = Modifier
                  .fillMaxWidth()
                  .padding(top = 16.dp),
               horizontalArrangement = Arrangement.SpaceBetween
            ) {
               SmallCard1(navController = navController, title = "All Pet Data")
               SmallCard2(navController = navController, title = "All Product")
            }
         }
      }
   }
}

@Composable
fun LargeCard(
   title: String,
   navController: NavController,
) {
   Card(
      modifier = Modifier
         .fillMaxWidth()
         .background(Color(255, 122, 122, 255))
         .padding(end = 10.dp) // Adjusted padding here
         .padding(bottom = 10.dp), // Added padding here
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
         Button(
            colors = ButtonDefaults.buttonColors(
               Color.Transparent
            ),
            onClick = {
               navController.navigate("PetHotelScreen")
            },
         )
         {
            Text(text = "Pet Hotel")
         }
      }
   }
}
@Composable
fun SmallCard1(navController: NavController, title: String) {
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
         Button(
            colors = ButtonDefaults.buttonColors(
               Color.Transparent
            ),
            onClick = { navController.navigate("AllDataPet") }
         ) {
            Text(text = "All Pet Data")
         }
      }
   }
}

@Composable
fun SmallCard2(navController: NavController, title: String) {
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
         Button(
            colors = ButtonDefaults.buttonColors(
               Color.Transparent
            ),
            onClick = { navController.navigate("Product") }
         ) {
            Text(text = "Product Pet Care")
         }
      }
   }
}




