import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.fitness.R
import com.example.fitness.common.BodyFatLevel
import com.example.fitness.common.BodyType
import com.example.fitness.common.Gender
import com.example.fitness.ui.AppViewModelProvider
import com.example.fitness.ui.common.CommonHeader
import com.example.fitness.ui.common.DialogSuccess
import com.example.fitness.ui.theme.disabled_color
import com.example.fitness.ui.theme.greenMain_light
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//This is for the labels for all of the fields
enum class ProfileFields(val fieldTitle: String){
    AGE("Age"),
    FIRSTNAME("First Name"),
    LASTNAME("Last Name"),
    HEIGHT("Height"),
    WEIGHT("Weight"),
    GENDER("Gender"),
    BODYTYPE("Body Type"),
    BODYFAT("Body Fat")
}

@Composable
fun ProfileScreen(navController: NavController) {
    val profileViewModel: ProfileViewModel = viewModel(factory = AppViewModelProvider.Factory)
    val profileData by profileViewModel.profileData.collectAsState()

    var isUpdating by rememberSaveable { mutableStateOf(false) }


    LaunchedEffect(true) {
        CoroutineScope(Dispatchers.IO).launch {profileViewModel.getUserProfile()  }

    }

    Box(modifier = Modifier.fillMaxSize()){

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color(0xFFFAFAFA))
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            CommonHeader(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                text = "Profile",
                subText = "\"Striving for progress, not perfection. Every workout is a step closer to my best self.\"",
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            profileData?.let { data ->
                var firstName by remember { mutableStateOf(data.firstname) }
                var lastName by remember { mutableStateOf(data.lastname) }
                var age by remember { mutableStateOf(data.age.toString()) }
                var height by remember { mutableStateOf(data.height) }
                var weight by remember { mutableStateOf(data.weight) }
                var gender by remember { mutableStateOf(data.gender) }
                var bodyFat by remember { mutableStateOf(data.bodyfat) }
                var bodyType by remember { mutableStateOf(data.bodytype) }

                //images holders
                var profilePic by remember { mutableStateOf(data.profilepic) }

                var genderOptions = listOf(Gender.MALE.name,Gender.FEMALE.name)
                var bodytypeOptions = listOf(BodyType.BEGINNER.name,BodyType.INTERMEDIATE.name,BodyType.ADVANCE.name)
                var bodyfatOptions = listOf(BodyFatLevel.LEAN.name, BodyFatLevel.ATHLETIC.name,BodyFatLevel.NATURAL.name)

                Spacer(modifier = Modifier.height(24.dp))

                ProfileImagePicker(isUpdating = isUpdating, imageFilePath = data.profilepic){
                    profilePic = it.orEmpty()
                }

                Spacer(modifier = Modifier.height(24.dp))
                //text type
                ProfileDetailEditable(isUpdating = isUpdating, title =  ProfileFields.FIRSTNAME.fieldTitle,value = firstName) { firstName = it }
                ProfileDetailEditable(isUpdating = isUpdating, title = ProfileFields.LASTNAME.fieldTitle, value = lastName) { lastName = it }
                //input type
                ProfileDetailEditable(isUpdating = isUpdating, title = ProfileFields.AGE.fieldTitle, value = age) { age = it }
                ProfileDetailEditable(isUpdating = isUpdating, title = ProfileFields.HEIGHT.fieldTitle, value = height) { height = it }
                ProfileDetailEditable(isUpdating = isUpdating, title = ProfileFields.WEIGHT.fieldTitle , value = weight) { weight = it }
                //dropdown
                Spacer(modifier = Modifier.height(5.dp))

                DynamicDropdownField(isUpdating = isUpdating,selectedValue = gender, label = ProfileFields.GENDER.fieldTitle, options = genderOptions) {gender = it}
                Spacer(modifier = Modifier.height(5.dp))

                DynamicDropdownField(isUpdating = isUpdating, selectedValue = bodyType, label = ProfileFields.BODYTYPE.fieldTitle, options = bodytypeOptions) {bodyType = it}
                Spacer(modifier = Modifier.height(5.dp))

                DynamicDropdownField(isUpdating = isUpdating, selectedValue = bodyFat, label = ProfileFields.BODYFAT.fieldTitle, options = bodyfatOptions) {bodyFat = it}
                Spacer(modifier = Modifier.height(5.dp))

                ButtonContainer(editOnclick = { isUpdating = true },
                    updateOnclick = {
                        CoroutineScope(Dispatchers.IO).launch {
                        profileViewModel.updateUserProfile(
                            profilePic = profilePic,
                            firstName = firstName,
                            lastName = lastName,
                            age = age,
                            height = height,
                            weight = weight,
                            gender = gender,
                            bodyFat = bodyFat,
                            bodyType = bodyType
                        )}
                        isUpdating = false
                    }, isUpdating = isUpdating )

            } ?: run {
                Text(
                    text = "Loading profile...",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF757575),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        if(profileViewModel.isUpdateSuccessful.value){
            DialogSuccess(){
                //return the state
                profileViewModel.resetSuccessDialog()
                isUpdating = false
            }
        }
    }
}

@Composable
fun ProfileImagePicker(isUpdating: Boolean,imageFilePath: String? = null, newUriPath: (String?) -> Unit) {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var imageUriString by remember { mutableStateOf<String?>(imageFilePath) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUriString = uri.toString()
        //saved to database URI
        newUriPath(imageUriString)

        //decode image path URI
        imageUriString?.let {
            imageUri = Uri.parse(imageUriString)
        }
    }

    //run only once side effect
    LaunchedEffect(imageUriString) {
        imageUriString?.let {
            imageUri = Uri.parse(it)
        }
    }

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
        ) {
            imageUri?.let {
                Image(
                    painter = rememberImagePainter(data = imageUri ),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color(0xFFBDBDBD), CircleShape)
                        .clickable { if(isUpdating){
                                    launcher.launch("image/*")
                                }
                                   },
                    alignment = Alignment.Center
                )
            } ?: Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color(0xFFBDBDBD), CircleShape)
                    .background(Color.White)
            )
            if(isUpdating) {
                Icon(
                    painter = painterResource(id = R.drawable.cam),
                    contentDescription = "Change Profile Image",
                    modifier = Modifier
                        .size(44.dp)
                        .background(Color.White, CircleShape)
                        .border(1.dp, Color(0xFFBDBDBD), CircleShape)
                        .padding(4.dp)
                        .align(Alignment.BottomEnd)
                        .clickable {
                            launcher.launch("image/*")
                        }
                )
            }
        }
    }
}

@Composable
fun ProfileDetailEditable(isUpdating: Boolean, title: String, value: String, onValueChange: (String) -> Unit) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = true,
                    keyboardType = if(title == ProfileFields.AGE.fieldTitle || title == ProfileFields.HEIGHT.fieldTitle || title == ProfileFields.WEIGHT.fieldTitle){
                        KeyboardType.Number
                    }else{
                        KeyboardType.Text
                    },
                    imeAction = ImeAction.Next
                ),
                enabled = isUpdating,
                colors = if(isUpdating) {
                    TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = greenMain_light
                    )
                }else{
                    TextFieldDefaults.colors(
                        disabledTextColor = Color.Black,
                        disabledContainerColor = Color.White,
                        disabledLabelColor = Color.Gray,
                    )
                },
                value = value,
                onValueChange = { onValueChange(it) },
                label = { Text(title) },
                modifier = Modifier.fillMaxWidth()

            )
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicDropdownField(
    modifier: Modifier = Modifier,
    isUpdating: Boolean,
    selectedValue: String,
    options: List<String>,
    label: String,
    onValueChangedEvent: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    //if field was disabled show this
    if(!isUpdating){
        ProfileDetailEditable(isUpdating = false, title = label, value = selectedValue) { }
    }else {
        //if enabled to edit show dropdown
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
            modifier = modifier
        ) {
            OutlinedTextField(
                readOnly = true,
                value = selectedValue,
                enabled = isUpdating,
                onValueChange = {},
                label = { Text(text = label, color = Color.Black) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    disabledTextColor = Color.Black,
                    disabledLabelColor = Color.Gray,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = greenMain_light,
                ),
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                options.forEach { option: String ->
                    DropdownMenuItem(
                        text = { Text(text = option) },
                        onClick = {
                            expanded = false
                            onValueChangedEvent(option)
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun ButtonContainer(editOnclick: () -> Unit, updateOnclick: () -> Unit, isUpdating: Boolean) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
            Button(
                onClick = {
                    if (isUpdating) {
                        updateOnclick()
                    }else{
                        editOnclick()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isUpdating) {
                        greenMain_light
                    } else {
                        disabled_color
                    }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(16.dp)
            ) {
                if (isUpdating) {
                    Text(text = "UPDATE", fontSize = 17.sp)
                }else {
                    Text(text = "EDIT", fontSize = 17.sp)
                }
            }
    }
}


@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(rememberNavController())
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun ProfileScreenFieldPreview() {
    ProfileDetailEditable(
        isUpdating = false,
        title = "Age",
        value = "") {

    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun ProfileImagePickerPreview() {
    ProfileImagePicker(false){

    }
}
