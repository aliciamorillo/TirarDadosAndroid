package com.example.mydiceapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mydiceapp.Dice
import com.example.mydiceapp.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_normal_dice.*

class NormalDiceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_normal_dice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btNormalDice.setOnClickListener {
            Snackbar.make(it, "Dado lanzado!", Snackbar.LENGTH_SHORT).show()
            rollDice()
        }
    }

    fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        tvNormalDice.text = diceRoll.toString()
    }

}