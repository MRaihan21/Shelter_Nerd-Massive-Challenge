package com.example.massive_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.EditText
import android.widget.Button


class FeedbackActivity : AppCompatActivity() {

    private lateinit var ratingBar: RatingBar
    private lateinit var commentEditText: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedbacks)

        ratingBar = findViewById(R.id.ratingBar)
        commentEditText = findViewById(R.id.commentEditText)
        submitButton = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            val userRating = ratingBar.rating
            val userComment = commentEditText.text.toString()

            // TODO: Kirim feedback dan peringkat ke server atau lakukan tindakan lainnya

            // Setelah mengirim feedback, Anda mungkin ingin menampilkan pesan sukses atau kembali ke layar sebelumnya.
            finish()
        }
    }
}