package de.ph1b.audiobook.features.BooksonicSetup

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.ph1b.audiobook.R
import kotlinx.android.synthetic.main.activity_booksonic_setup.*
//import khttp.get
//import khttp.post

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
      if (allOkay && testRequest(editServerAddress.toString(), editUserName.toString(), editUserPassword.toString())){
        TestButton.setBackgroundColor(getColor(R.color.green))
      }
      else {
        TestButton.setBackgroundColor(getColor(R.color.white))
      }
    }

  }
  fun testRequest(serverAddress : String, Username : String, password: String):Boolean{
    //var completeRequestTarget = "$serverAddress/rest/ping?u=$Username&p=$password&v=1.15.0&c=VoiceSonic"
    //val response = khttp.get(completeRequestTarget)
    //if (response.statusCode == 200){
    //  return true
    //}

    return false

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
