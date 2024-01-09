package com.example.login_page_auth.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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


object DestinasiHome : DestinasiNavigasi {
   override val route = "home"
   override val titleRes = "PetHome"
}
@Composable
fun HomeScreen(
   navController: NavController,
   viewModel: IgViewModel,

   ){
   val image = painterResource(id = R.drawable.eslilin)
   Column(modifier = Modifier, verticalArrangement = Arrangement.SpaceBetween) {
      OutlinedCard(
         colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
         border = BorderStroke(1.dp, Color.Black),
         modifier = Modifier
            .fillMaxWidth(0.95f)
            .padding(vertical = 50.dp)
            .align(Alignment.CenterHorizontally)
      ) {
         Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.CenterHorizontally)
         ) {
            Image(
               painter = image,
               contentDescription = null,
               contentScale = ContentScale.Crop
            )
            Text(
               text = "Es Lilin",
               color = Color.DarkGray,
               fontSize = 35.sp,
               modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
               text = "Ceu Imas",
               color = Color.DarkGray,
               fontFamily = FontFamily.Cursive,
               fontStyle = FontStyle.Italic,
               fontSize = 60.sp,
               fontWeight = FontWeight.Bold
            )

         }
      }
   }
}

