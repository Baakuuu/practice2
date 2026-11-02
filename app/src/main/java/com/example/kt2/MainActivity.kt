package com.example.kt2

import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kt2.ui.theme.KT2Theme
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material3.Surface

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KT2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface( //9
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding), // Обязательно применяем отступы от Scaffold
                        color = MaterialTheme.colorScheme.background
                    ) {
                        WaterTracker() // Запускаем наш трекер воды
                    }
//                    Box(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(innerPadding)
//                    ) {
//                        Task1Preview()
//                    }
//                    Box( //5
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(innerPadding)
//                            .padding(16.dp)
//                    ) {
//                        CustomButtonPreview()
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                    Hello(
//                        name = "Гусейн",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                    }
//                    Box( //6
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(innerPadding)
//                    ) {
//                        task61()
//                    }
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    KT2Theme {
//        Greeting("Android")
//    }
//}

//1
@Composable
fun Hello(name: String?, modifier: Modifier = Modifier){
    Text(
        modifier = modifier.fillMaxWidth(),
        text = if (name.isNullOrBlank()) "Имя не задано" else "Привет, $name",
        textAlign = TextAlign.Center,
        fontSize = 22.sp,
    )
}

@Preview(showBackground = true)
@Composable
fun HelloPreview(){
    KT2Theme() {
        Hello("Гусейн")

    }
}

//@Preview(showBackground = true)
//@Composable
//fun HelloPreview(){
//    KT2Theme() {
//        Hello("")
//
//    }
//}

//2
@Preview(
    name = "Portrait mode",
    widthDp = 360,
    heightDp = 640,
    showBackground = true
)
@Composable
fun HelloPortrait(){
    KT2Theme() {
        Hello("Гусейн" + ", это портретная ориентация")
    }
}

@Preview(
    name ="Landscape mode",
    widthDp = 640,
    heightDp = 360,
    showBackground = true
)
@Composable
fun HelloLandscape(){
    KT2Theme() {
        Hello("Гусейн" + ", это альбомная ориентация")
    }
}

@Preview(
    name = "Circle mode",
    widthDp = 200,
    heightDp = 200,
    showBackground = true
)
@Composable
fun YellowCirclePreview(){
    Box(
        modifier = Modifier
            .size(200.dp)
            .clip(CircleShape)
            .background(Color.Yellow)
    )
}

//3
@Preview(showBackground = true)
@Composable
fun GreenText(){
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(id = R.string.task_3),
        fontSize = 16.sp,
        color = Color.Green,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun OneLineText(){
    Text(
        modifier = Modifier,
        text = stringResource(id=R.string.task_3),
        fontSize = 16.sp,
        color = Color.Green,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview(showBackground = true)
@Composable
fun BlackText(){
    Box(
        modifier = Modifier
            .size(640.dp)
            .background(Color.Green),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id=R.string.task_3),
            fontSize = 24.sp,
            color = Color.Black,
            textDecoration = TextDecoration.Underline,
            style =TextStyle(
                textIndent = TextIndent(
                    firstLine = 48.sp
                )
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun CustomButtonPreview(modifier: Modifier = Modifier) {
    Button(
        onClick = { },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color.Gray),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        )
    ) {
        Text(text = "Нажми на меня")
    }
}


@Preview(showBackground = true)
@Composable
fun Task1Preview() {
    Box(
        modifier = Modifier
            // 1. Серый контейнер во всю ширину экрана высотой 100.dp
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.LightGray),
        // 2. Располагаем содержимое посередине
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                // 3. Круг занимает всю доступную высоту контейнера
                // с учетом вертикальных отступов 16.dp сверху и снизу
                .fillMaxHeight()
                .padding(vertical = 16.dp)
                // Делаем элемент квадратным (ширина равна высоте) и превращаем в круг
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(Color(0xFFFF5722)), // Оранжевый цвет круга, как на скриншоте
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "АБ",
                color = Color.Black,
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showBackground =true)
@Composable
fun task6(){
    Box(
        modifier = Modifier
            .width(240.dp)
            .height(120.dp)
            .background(Color(0xFF000000)),
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = "Круг",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun task61(){
    Box(
       modifier = Modifier
           .width(240.dp)
           .height(120.dp)
           .background(Color(0xFFBB86FC)),
    ) {
        Image(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = "Круг",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(Color(0xFF9C27B0))
        )
    }
}

@Composable
fun Contact(
    firstName: String,
    middleName: String,
    lastName: String,
    phone: String,
    address: String,
    modifier: Modifier = Modifier
)
{
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(Color.LightGray)
    ) {
        Text(text ="Имя: $firstName")
        Text(text ="Отчество: $middleName")
        Text(text ="Фамилия: $lastName")
        Text(text = "Телефон: $phone")
        Text(text ="Адрес: $address")
    }
}

@Preview(name = "ContactColumnPreview - portrait", showBackground = true)
@Composable
fun ContactColumnPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Contact(
            firstName = " Евгений",
            middleName = "Андреевич",
            lastName = "Лукашин",
            phone = "+7 495 495 95 95",
            address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12"
        )
        Contact(
            firstName = "Василий",
            middleName = "Егорович",
            lastName = "Кузякин",
            phone = "-",
            address = "Ивановская область, дер. Крутово, д. 4"
        )
        Contact(
            firstName = "Людмила",
            middleName = "Прокофьевна",
            lastName = "Калугина",
            phone = "+7 495 788 78 78",
            address = "Москва, Большая Никитская, д. 43, кв. 290"
        )
    }
}

@Composable
fun ContactWithRow(
    firstName: String,
    middleName: String,
    lastName: String,
    phone: String,
    address: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(12.dp)
    ) {
        // Контейнер Row для расположения текста и картинки по горизонтали
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Имя: $firstName")
                Text(text = "Отчество: $middleName")
                Text(text = "Фамилия: $lastName")
                Text(text = "Мобильный телефон: $phone")
                Text(text = "Адрес: $address")
            }
            Image(
                painter = painterResource(id = R.drawable.star), // Системная иконка звезды
                contentDescription = "Звезда",
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Preview(name = "ContactColumnPreview - portrait", showBackground = true)
@Composable
fun ContactRowPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        ContactWithRow(
            firstName = "Евгений",
            middleName = "Андреевич",
            lastName = "Лукашин",
            phone = "+7 495 495 95 95",
            address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12"
        )
    }
}

//8
val primaryColor = Color(0xFF3F51B5)
val secondaryColor = Color(0xFF757575)
val buttonTextColor = Color.White
@Composable
fun WaterTracker() {
    // 1. Исправленный стейт для воды (начальное значение 0 или 100, добавили remember)
    var waterCount by remember { mutableStateOf(0) }

    // Новый стейт для подсчета дней подряд (где выпито >= 1500 мл)
    var streakDays by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Опционально для аккуратного выравнивания по центру
    ) {
        Text(
            text = "Трекер воды",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = primaryColor
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Отображение текущего количества выпитой воды
        Text(
            text = "$waterCount мл",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = secondaryColor
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Вывод количества дней подряд с нормой 1500 мл и больше
        Text(
            text = "Дней подряд с нормой: $streakDays",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = primaryColor
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Кнопка увеличения воды на 250 мл
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
            onClick = { waterCount += 250 }
        ) {
            Text(
                text = "+250 мл",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = buttonTextColor
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Новая кнопка «Завершить день»
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = secondaryColor),
            onClick = {
                if (waterCount >= 1500) {
                    streakDays += 1
                } else {
                    streakDays = 0
                }
                waterCount = 0
            }
        ) {
            Text(
                text = "Завершить день",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = buttonTextColor
            )
        }
    }
}