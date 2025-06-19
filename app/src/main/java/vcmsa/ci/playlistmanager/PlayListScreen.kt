package vcmsa.ci.playlistmanager

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PlayListScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_play_list_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val lblOutput =findViewById<TextView>(R.id.lblOutput)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnView = findViewById<Button>(R.id.btnView)
        val btnCalc = findViewById<Button>(R.id.btnCalc)


        //This takes the user back to the first screen
        btnBack.setOnClickListener {// (The IIE,2025)
            finish()
        }
        //When the user clicks this button they will see the items in their list
        btnView.setOnClickListener {// (The IIE,2025)
            var outputString: String = ""
            for (i in 0 .. arrayPostion){
                outputString += "Song title:" + songTitles[i] + "\n"
                outputString += "Artist Name:" + artistNames[i] + "\n"
                outputString += "Song rating:" + songRatings[i] + "\n"
                outputString += "Comments:" + comments[i] + "\n\n"
            }
            lblOutput.text = outputString

        }
        //This calculates the users average rating of songs in the list
        btnCalc.setOnClickListener {// (The IIE,2025)
           lblOutput.text = "Your average rating is" + songRatings.average()
        }
    }
}//The IIE,2025.Introduction to Mobile Application Development[IMAD5112 Module Manual].The Independent Institute of Education: Unpublished.