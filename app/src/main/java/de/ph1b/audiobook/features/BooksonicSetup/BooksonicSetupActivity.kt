package de.ph1b.audiobook.features.BooksonicSetup

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.ph1b.audiobook.R
import kotlinx.android.synthetic.main.activity_booksonic_setup.*
import java.io.BufferedInputStream
import java.net.URL
import java.net.HttpURLConnection

class BooksonicSetupActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_booksonic_setup)

    // Listeners
    TestButton.setOnClickListener{
      var allOkay = true
      if (editServerAddress.length() == 0){
        editServerAddress.setError("Enter address")
        allOkay = false
      }
      if (editUserName.length() == 0){
        editUserName.setError("Enter username")
        allOkay = false
      }
      if (editUserPassword.length() == 0){
        editUserPassword.setError("Enter password")
        allOkay = false
      }
      if (allOkay){
        testRequest(editServerAddress.toString(), editUserName.toString(), editUserPassword.toString())
      }
    }

  }
  fun testRequest(serverAddress : String, Username : String, password: String):Boolean{
    var url = URL(serverAddress)
    var urlConnection = url.openConnection() as HttpURLConnection
    try {
        var inConnect = BufferedInputStream(urlConnection.inputStream)
        var xml = inConnect.read()
        var code = urlConnection.responseCode
        if (code == 200){
          urlConnection.disconnect()
          return true
        }
    }finally {
        urlConnection.disconnect()
        return false
    }

  }

  companion object {

    /**
     * Generates a new intent

     * @param c The context
     * *
     * @return The new intent
     */
    fun newInstanceIntent(c: Context): Intent {
      val intent = Intent(c, BooksonicSetupActivity::class.java)
      return intent
    }
  }
}
