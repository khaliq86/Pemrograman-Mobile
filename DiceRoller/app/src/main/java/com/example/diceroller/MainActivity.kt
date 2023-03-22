package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val myFirstDice = Dice(6)
        val rollResult1 = myFirstDice.roll()

        val mySecondDice = Dice(6)
        val rollResult2 = mySecondDice.roll()

        if(rollResult1 > rollResult2){
            println("Dice 1 Won!")
            val toast = Toast.makeText(this, "Dice 1 Won!", Toast.LENGTH_SHORT)
            toast.show()
        }else if(rollResult1 == rollResult2){
            println("Same")
            val toast = Toast.makeText(this, "Same", Toast.LENGTH_SHORT)
            toast.show()
        }else{
            println("Dice 2 Won!")
            val toast = Toast.makeText(this, "Dice 2 Won!", Toast.LENGTH_SHORT)
            toast.show()
        }


        val diceImage1: ImageView = findViewById(R.id.imageView)
        when (rollResult1) {
            1 -> diceImage1.setImageResource(R.drawable.dice_1)
            2 -> diceImage1.setImageResource(R.drawable.dice_2)
            3 -> diceImage1.setImageResource(R.drawable.dice_3)
            4 -> diceImage1.setImageResource(R.drawable.dice_4)
            5 -> diceImage1.setImageResource(R.drawable.dice_5)
            6 -> diceImage1.setImageResource(R.drawable.dice_6)
        }

        val diceImage2: ImageView = findViewById(R.id.imageView2)
        when (rollResult2) {
            1 -> diceImage2.setImageResource(R.drawable.dice_1)
            2 -> diceImage2.setImageResource(R.drawable.dice_2)
            3 -> diceImage2.setImageResource(R.drawable.dice_3)
            4 -> diceImage2.setImageResource(R.drawable.dice_4)
            5 -> diceImage2.setImageResource(R.drawable.dice_5)
            6 -> diceImage2.setImageResource(R.drawable.dice_6)
        }
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}