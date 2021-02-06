package com.example.mydiceapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.mydiceapp.Dice
import com.example.mydiceapp.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_face_cross.*

class FaceCrossFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_face_cross, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        btFaceCross.setOnClickListener {
            Toast.makeText(activity, "Moneda Lanzada!", Toast.LENGTH_SHORT).show()
            rollDice()
        }
    }

    fun rollDice() {
        val dice = Dice(2)
        val diceRoll = dice.roll()

        if(diceRoll == 1) {
            tvFaceCross.text = "CARA"
        } else {
            tvFaceCross.text = "CRUZ"
        }
    }
}