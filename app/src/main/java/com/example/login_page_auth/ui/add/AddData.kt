import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.login_page_auth.PenyediaViewModel
import com.example.login_page_auth.navigation.DestinasiNavigasi
import java.lang.reflect.Modifier

object DestinasiAdd : DestinasiNavigasi {
    override val route = "item_entry"
    override val titleRes = "Entry Pet"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    addViewModel: AddViewModel = viewModel(factory = PenyediaViewModel.Factory),

    ){
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            PetTopAppBar(
                title = DestinasiAdd.titleRes,
                canNavigateBack = true,
                scrollBehavior = scrollBehavior,
                navigateUp = navigateBack
            )
        }
    ){ innerPadding ->

        EntryBody(
            addUIState = addViewModel.addUIState,
            onPetValueChange = addViewModel::updateAddUIState,
            onSaveClick = {
                coroutineScope.launch {
                    addViewModel.addKontak()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )
    }
}

@Composable
fun EntryBody(
    addUIState: AddUIState,
    onPetValueChange: (AddEvent) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.padding(12.dp)
    ) {
        FormInput(
            addEvent = addUIState.addEvent,
            onValueChange = onPetValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveClick,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add")
        }
    }
}

@Composable
fun FormInput(
    addEvent: AddEvent,
    modifier: Modifier = Modifier,
    onValueChange: (AddEvent) -> Unit = {},
    enabled: Boolean = true
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = addEvent.namapet,
            onValueChange = { onValueChange(addEvent.copy(namapet = it)) },
            label = { Text("Nama Hewan") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = addEvent.jenispet,
            onValueChange = { onValueChange(addEvent.copy(jenispet = it)) },
            label = { Text("Jenis Hewan") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = addEvent.telpon,
            onValueChange = { onValueChange(addEvent.copy(telpon = it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Telpon") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

    }
}