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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import envuvem.com.br.senacburguers.ui.theme.Purple500
import envuvem.com.br.senacburguers.ui.theme.SenacBurguersTheme
import envuvem.com.br.senacburguers.ui.theme.Teal200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

           super.onCreate(savedInstanceState)
        setContent {
            SenacBurguersTheme {
                // A surface container using the 'background' color from the theme
                val maximo = 800.dp
                Surface(modifier =  Modifier.width(maximo),
                color= MaterialTheme.colors.background) {
                    Surface(modifier = Modifier.width(maximo/2),
                    color = MaterialTheme.colors.background) {
                    Produtos()

                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
//ira carregar 03 imagens da API loresm space
fun carregarimagens() : Painter{
                    val ImagensPainters = mutableListOf(rememberAsyncImagePainter(
                        "https://api.lorem.space/image/face?w=400&amp;amp;amp;amp;h=400"),
            rememberAsyncImagePainter(
                "https://api.lorem.space/image/face?w=300&amp;amp;amp;amp;h=300"),
                rememberAsyncImagePainter(
                    "https://api.lorem.space/image/face?w=200&amp;amp;amp;amp;h=200"))
        ImagensPainters.shuffle()
        val sorteio = (0..2).random()
        return ImagensPainters[sorteio]
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
                    .width(imagesize * 2)
                    .background(brush = Brush.horizontalGradient(colors = listOf(Purple500,
                        Teal200)))
                ) {
                    // da biblioteca Coil eu posso receber um Painter a partir de um endere??o
                    // carrega-lo na vari??vel e usar no compose image




                    Image(painter = carregarimagens(),
                        contentDescription = "Imagem do Produto",
                        Modifier
                            .size(imagesize)
                            .offset(y = imagesize / 2)
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


@Composable
fun Produtos() {
    Row {
        ProductItem()
        ProductItem()
        ProductItem()
        ProductItem()
    }
}
