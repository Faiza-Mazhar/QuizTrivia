package com.example.quiztrivia.composables

import android.content.Context
import android.util.AttributeSet
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiztrivia.composables.ui.theme.LighterGreen
import com.example.quiztrivia.composables.ui.theme.LightestGreen
import com.example.quiztrivia.composables.ui.theme.OliveGreen
import com.example.quiztrivia.composables.ui.theme.QuizTriviaTheme


class ButtonComposeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractComposeView(context, attrs, defStyleAttr) {

    private val titleText = mutableStateOf("")

    var title: String
        get() = titleText.value
        set(value) {
            titleText.value = value
        }

    private val onClick = mutableStateOf({  })

    var onClickEvent: () -> Unit
        get() = onClick.value
        set(value) {
            onClick.value = value
        }


    @Composable
    override fun Content() {
        ButtonSelection(name = titleText.value, onClick.value)
    }
}



@Composable
fun ButtonSelection(name: String, onClickEvent: (() -> Unit)) {
    Button(
        onClick = onClickEvent,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = LighterGreen,
        ),
        border = BorderStroke(width = 1.dp, brush = SolidColor(LightestGreen)),
        modifier = Modifier.focusable(true),
        contentPadding = PaddingValues(
            start = 20.dp,
            top = 12.dp,
            end = 20.dp,
            bottom = 12.dp
        )
    ) {
        Text(
            text = name,
            color = OliveGreen,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuizTriviaTheme {
        ButtonSelection("Android") {}
    }
}