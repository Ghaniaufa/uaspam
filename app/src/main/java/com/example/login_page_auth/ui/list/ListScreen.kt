package com.example.login_page_auth.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.login_page_auth.PenyediaViewModel
import com.example.login_page_auth.PetTopAppBar
import com.example.login_page_auth.model.Pet
import com.example.login_page_auth.navigation.DestinasiNavigasi

object ListDestination : DestinasiNavigasi {
    override val route = "item_details"
    override val titleRes = "List Pet"
    const val petId = "itemId"
    val routeWithArgs = "$route/{$petId}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navigateBack: () -> Unit,
    navigateToItemEntry: () -> Unit,
    modifier: Modifier = Modifier,
    navController : NavController,
    viewModel: ListViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            PetTopAppBar(
                title = "Pet",
                canNavigateBack = true,
                scrollBehavior = scrollBehavior
            )
        },
    ) { innerPadding ->
        val uiStatePet by viewModel.homeUIState.collectAsState()
        BodyDetailScreen(
            itemPet = uiStatePet.listPet,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            onPetClick = { navController.navigate("EditScreen") }
        )
    }
}
@Composable
fun BodyDetailScreen(
    itemPet: List<Pet>,
    modifier: Modifier = Modifier,
    onPetClick: (String) -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (itemPet.isEmpty()) {
            Text(
                text = "Tidak ada data Kontak",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListDataPet(
                itemPet = itemPet,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                onItemClick = { onPetClick(it.id) }
            )
        }
    }
}

@Composable
fun ListDataPet(
    itemPet: List<Pet>,
    modifier: Modifier = Modifier,
    onItemClick: (Pet) -> Unit
    ) {
        LazyColumn(
            modifier = modifier
        ) {
            this.items(itemPet, key = { it.id }) { pet ->
                DataPet(
                    pet = pet,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onItemClick(pet) }
                )
                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
    }

@Composable
fun DataPet(
    pet: Pet,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = pet.namapet,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null,
                )
                Text(
                    text = pet.jenispet,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Text(
                text = pet.telpon,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}


