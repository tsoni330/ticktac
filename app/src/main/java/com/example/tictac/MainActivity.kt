package com.example.tictac

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var button1:Button
    lateinit var button2:Button
    lateinit var button3:Button
    lateinit var button4:Button
    lateinit var button5:Button
    lateinit var button6:Button
    lateinit var button7:Button
    lateinit var button8:Button
    lateinit var button9:Button
    lateinit var resetButton:Button
    var counter :Int = 0
    var playertime : Boolean = true
    lateinit var b1:String;
    lateinit var b2:String;
    lateinit var b3:String;
    lateinit var b4:String;
    lateinit var b5:String;
    lateinit var b6:String;
    lateinit var b7:String;
    lateinit var b8:String;
    lateinit var b9:String;
    var p1:Boolean = true;
    lateinit var p2:String;
    lateinit var playerInfo:TextView
    lateinit var winnerText:TextView
    lateinit var adView: AdView
    lateinit var adRequest: AdRequest
    fun playerTime(){
        playertime=!playertime
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()


        MobileAds.initialize(this)

        // on below line we are initializing
        // our ad view with its id
        adView = findViewById(R.id.adView)

        // on below line we are
        // initializing our ad request.
        adRequest = AdRequest.Builder().build()

        // on below line we are loading our
        // ad view with the ad request
        adView.loadAd(adRequest)
        resetButton.setOnClickListener {
            resetGame()
        }
    }

    fun init(){
        playerInfo = findViewById(R.id.textView)
        winnerText = findViewById(R.id.textView2)
        button1 = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        resetButton = findViewById(R.id.button10)
    }

    fun resetGame(){
        button1.isEnabled=true
        button2.isEnabled=true
        button3.isEnabled=true
        button4.isEnabled=true
        button5.isEnabled=true
        button6.isEnabled=true
        button7.isEnabled=true
        button8.isEnabled=true
        button9.isEnabled=true

        button1.text=""
        button2.text=""
        button3.text=""
        button4.text=""
        button5.text=""
        button6.text=""
        button7.text=""
        button8.text=""
        button9.text=""
        winnerText.setText("")
        counter=0
        p1=!p1;
        playerInfo.setText("Player1: ${if (p1) "X" else "0" } and Player2: ${if (!p1) "X" else "0" }")
        if (p1) playertime=true else playertime=false
    }
    fun onClick(view: View) {
        var btn:Button = view as Button;

        if(btn.text.equals("")){
            btn.isEnabled=false
            btn.setTextColor(Color.BLACK)
            if(playertime) btn.text="X" else btn.text="0"
            playerTime()
            counter++
            if(counter>=4){
                b1 = button1.text.toString();
                b2 = button2.text.toString();
                b3 = button3.text.toString();
                b4 = button4.text.toString();
                b5 = button5.text.toString();
                b6 = button6.text.toString();
                b7 = button7.text.toString();
                b8 = button8.text.toString();
                b9 = button9.text.toString();

                if(b1.equals(b2) && b1.equals(b3) && !b1.equals("")){
                    //resetGame()
                    winnerText.setText("Winner : ${b1}")
                    Toast.makeText(this.applicationContext,"Winner : ${b1}",Toast.LENGTH_LONG).show()
                }else if(b4.equals(b5) && b4.equals(b6) && !b4.equals("")){
                   // resetGame()
                    winnerText.setText("Winner : ${b4}")
                    Toast.makeText(this.applicationContext,"Winner : ${b4}",Toast.LENGTH_LONG).show()
                }else if(b7.equals(b8) && b7.equals(b9) && !b7.equals("")){
                   // resetGame()
                    winnerText.setText("Winner : ${b7}")
                    Toast.makeText(this.applicationContext,"Winner : ${b7}",Toast.LENGTH_LONG).show()
                }else if(b1.equals(b5) && b1.equals(b9) && !b1.equals("")){
                    //resetGame()
                    winnerText.setText("Winner : ${b1}")
                    Toast.makeText(this.applicationContext,"Winner : ${b1}",Toast.LENGTH_LONG).show()
                }else if(b3.equals(b5) && b3.equals(b7) && !b3.equals("")){
                    //resetGame()
                    winnerText.setText("Winner : ${b3}")
                    Toast.makeText(this.applicationContext,"Winner : ${b3}",Toast.LENGTH_LONG).show()
                }else if(b1.equals(b4) && b1.equals(b7) && !b1.equals("")){
                   /// resetGame()
                    winnerText.setText("Winner : ${b1}")
                    Toast.makeText(this.applicationContext,"Winner : ${b1}",Toast.LENGTH_LONG).show()

                }else if(b2.equals(b5) && b2.equals(b8) && !b2.equals("")){
                    //resetGame()
                    winnerText.setText("Winner : ${b2}")
                    Toast.makeText(this.applicationContext,"Winner : ${b2}",Toast.LENGTH_LONG).show()
                }else if(b3.equals(b6) && b3.equals(b9) && !b3.equals("")){
                    //resetGame()
                    winnerText.setText("Winner : ${b3}")
                    Toast.makeText(this.applicationContext,"Winner : ${b3}",Toast.LENGTH_LONG).show()
                }else if(counter>=9){
                    //resetGame()
                    Log.e("Counter","Its working")
                    winnerText.setText("Drwa")
                    Toast.makeText(this.applicationContext,"Draw",Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}