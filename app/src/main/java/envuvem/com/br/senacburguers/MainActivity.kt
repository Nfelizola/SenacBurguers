package envuvem.com.br.senacburguers
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import envuvem.com.br.senacburguers.ui.theme.Purple500
import envuvem.com.br.senacburguers.ui.theme.SenacBurguersTheme
import envuvem.com.br.senacburguers.ui.theme.Teal200

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
    
           super.onCreate(savedInstanceState)

        setContent {
            SenacBurguersTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {

                    ProductItem()
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun ProductItem() {
    SenacBurguersTheme {
        Surface(Modifier.padding(8.dp), shape = RoundedCornerShape(15.dp), elevation = 8.dp) {


            Column(Modifier
                .heightIn(200.dp, 350.dp)
                .width(200.dp)) {
                val imagesize = 100.dp
                Box(modifier = Modifier
                    .height(imagesize)
                    .background(brush = Brush.horizontalGradient(colors = listOf(Purple500,
                        Teal200)))
                    .fillMaxWidth()
                ) {

                    Image(painter = painterResource(
                        id = R.drawable.ic_launcher_background),
                        contentDescription = "Imagem do Produto",
                        Modifier
                            .size(imagesize)
                            .offset(y = imagesize/2)
                            .clip(shape = CircleShape)
                            .align(BottomCenter)
                    )
                }
                Spacer(modifier = Modifier.height(imagesize/2))
                Column(Modifier.padding(16.dp)) {
                    Text(text = LoremIpsum(50).values.first(),
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis)

                    Text(
                        text = "R$ 14,99",
                        fontSize = 19.sp,
                        fontWeight = FontWeight(400)
                    )
                }
            }
        }
    }
}



