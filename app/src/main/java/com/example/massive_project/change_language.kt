package com.example.massive_project

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class ChangeLanguageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_language)

        val languageRadioGroup: RadioGroup = findViewById(R.id.languageRadioGroup)
        val applyButton: Button = findViewById(R.id.applyButton)

        applyButton.setOnClickListener {
            val selectedRadioButton: RadioButton = findViewById(languageRadioGroup.checkedRadioButtonId)

            if (selectedRadioButton != null) {
                val selectedLanguage = when (selectedRadioButton.id) {
                    R.id.radioEnglish -> "en"
                    R.id.radioSpanish -> "es"
                    // Handle other languages if needed
                    else -> "en"
                }

                setLocale(selectedLanguage)
                recreate() // Restart the activity to apply the new language
            } else {
                Toast.makeText(this, "Please select a language", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val config = Configuration()
        config.setLocale(locale)
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
    }
}
