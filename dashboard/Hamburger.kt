import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitness.R
import com.example.fitness.ui.common.CommonHeader
import com.example.fitness.ui.common.PrimaryButton
import com.example.fitness.ui.dashboard.HamburgerViewModel
import com.example.fitness.ui.theme.darkGreen_dark
import com.example.fitnesstracker.common.Screens

@Composable
fun Hamburger(navController: NavController) {
    val hamburgerViewModel: HamburgerViewModel = viewModel()

    // OnClick logout handler
    val onLogout = {
        hamburgerViewModel.onLogOutClick()
        navController.navigate(Screens.LOGIN_SCREEN.screenName)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .padding(19.dp)
        ) {
            CommonHeader(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                text = "Settings",
                subText =  "Customize your account.",
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(50.dp))

            // Settings items
            SettingsItem(
                iconId = R.drawable.profile,
                text = "Profile",
                onClick = {
                    navController.navigate(Screens.PROFILE_SCREEN.screenName)
                }
            )

            Spacer(modifier = Modifier.height(26.dp))

            SettingsItem(
                iconId = R.drawable.message,
                text = "Messages",
                onClick = {
                    navController.navigate(Screens.MESSAGE_SCREEN.screenName)
                }
            )

            Spacer(modifier = Modifier.height(26.dp))

            SettingsItem(
                iconId = R.drawable.helps,
                text = "Help & Support",
                onClick = {
                    navController.navigate(Screens.HELP_SCREEN.screenName)
                }
            )

            Spacer(modifier = Modifier.height(26.dp))

            SettingsItem(
                iconId = R.drawable.info,
                text = "About us",
                onClick = {
                    navController.navigate(Screens.ABOUTUS_SCREEN.screenName)
                }
            )

            Spacer(modifier = Modifier.height(50.dp))

            // Logout button
            PrimaryButton(
                text = "Logout",
            ){
                onLogout()
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Footer text
        Text(
            text = "@Precision wellness 2024",
            color = Color.Black,
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun SettingsItem(iconId: Int, text: String, onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .background(Color.White)
            .border(1.dp, darkGreen_dark, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = darkGreen_dark,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = darkGreen_dark
        )
    }
}

@Preview
@Composable
fun PreviewHamburger() {
    Hamburger(navController = rememberNavController())
}
