package com.example.restjsonintro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queue = Volley.newRequestQueue(this)
        find_button.setOnClickListener {
            val url = getUrl()
            val stringRequest = StringRequest(Request.Method.GET, url,
                    {response ->
                        try {
                            textView.text = response
                        }catch (exception : Exception){
                            exception.printStackTrace()
                        }
                    },
                    {error ->
                        Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                    }
            )
            queue.add(stringRequest)
        }
    }
    private fun getUrl() : String{
        val word = word_edit_text.text
        val apiKey = "la_vostra_api"
        val url =
                "https://www.dictionaryapi.com/api/v3/references/learners/json/$word?key=$apiKey"

        return url
    }
}