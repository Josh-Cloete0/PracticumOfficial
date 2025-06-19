package vcmsa.ci.playlistmanager
//Josh Cloete ST10473468
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//Declaring Global arrays
var songTitles = Array<String> (4) {""}
var artistNames  = Array<String> ( 4) {""}
var songRatings = Array<Int> (4 ) {0}
var comments = Array<String>(4) {""}
var arrayPostion = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Declaring variables for UI
        val txtTitle = findViewById<EditText>(R.id.txtTitle)
        val txtArtistName = findViewById<EditText>(R.id.txtArtistName)
        val txtRating = findViewById<EditText>(R.id.txtRating)
        val txtComments = findViewById<EditText>(R.id.txtComments)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnExit = findViewById<Button>(R.id.btnExit)
        val TAG = "PlaylistManager"
// (The IIE,2025)
        btnAdd.setOnClickListener{// (The IIE,2025)
            val songTitle :String = txtTitle.text.toString()
            val artistName :String = txtArtistName.text.toString()
            val songRating :String = txtRating.text.toString()
            val comment :String = txtComments.text.toString()

            if (songTitle.isNullOrBlank()){
                Toast.makeText(this,"Title cannot be blank please enter a valid title and try again",Toast.LENGTH_SHORT).show()
                Log.d(TAG,"User did not enter a valid Title")
                //if input is invalid exit out of the setOnClick Listener
                return@setOnClickListener
            }
            if (artistName.isNullOrBlank()){
                Toast.makeText(this,"Artist Name cannot be blank please enter a valid Artist Name and try again",Toast.LENGTH_SHORT).show()
                Log.d(TAG,"User did not enter a valid Artist Name")
                return@setOnClickListener
            }
            if (songRating.isNullOrBlank()){
                Toast.makeText(this, "Song rating cannot be blank please enter a valid Rating and try again",Toast.LENGTH_SHORT).show()
                Log.d(TAG,"User did not enter a valid song rating")
                return@setOnClickListener
            }
            if (comment.isNullOrBlank()){
                Toast.makeText(this,"Comment cannot be blank please enter a valid comments and try again",Toast.LENGTH_SHORT).show()
                Log.d(TAG,"USer did not enter a valid comment")
                return@setOnClickListener
            }
            //Add to the Array if there is item space left
            if (arrayPostion < 4) {
                songTitles[arrayPostion] = songTitle
                artistNames[arrayPostion] = artistName
                songRatings[arrayPostion] = songRating.toInt()
                comments[arrayPostion] = comment
                arrayPostion++
                Toast.makeText(this,"Song added to playlist!",Toast.LENGTH_SHORT).show()
                Log.d(TAG,"User added song to Playlist")
            }else{
                Toast.makeText(this,"Cannot add song as the array is full",Toast.LENGTH_SHORT).show()
                Log.d(TAG,"User tried to add item to full array")
            }
        }
        //This Allows the user to navigate to a screen to view their list
        btnNext.setOnClickListener {// (The IIE,2025)
            val intent = Intent(this,PlayListScreen::class.java)
            startActivity(intent)
        }
        //This lets the user exit the app
        btnExit.setOnClickListener {// (The IIE,2025)
            finishAffinity()
        }





    }
}//The IIE,2025.Introduction to Mobile Application Development[IMAD5112 Module Manual].The Independent Institute of Education: Unpublished.