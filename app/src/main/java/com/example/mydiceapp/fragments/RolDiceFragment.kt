package com.example.mydiceapp.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mydiceapp.Dice
import com.example.mydiceapp.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_rol_dice.*


class RolDiceFragment : Fragment() {

    var itemSelected = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rol_dice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btSelectChoice.setOnClickListener {
            selectChoice()
        }

        btRolDicePlay.setOnClickListener {
            Snackbar.make(it, "Dado Lanzado!", Snackbar.LENGTH_SHORT).show()
            rollDice()
        }
    }

    fun selectChoice() {
        val listItems =
            arrayOf("4", "8", "12", "16")

        val builder = AlertDialog.Builder(context)
        builder.setTitle("Elige dado:")

        val checkedItem = 0 //this will checked the item when user open the dialog

        builder.setSingleChoiceItems(listItems, checkedItem) { dialog, which ->
            itemSelected = listItems[which].toInt()
            tvNumFaces.text = "Elegiste el dado con ${itemSelected.toString()} caras"
        }

        builder.setPositiveButton(
            "Done"
        ) { dialog, which -> dialog.dismiss() }

        val dialog = builder.create()
        dialog.show()


    }

    fun rollDice() {
        val dice = Dice(itemSelected)
        val diceRoll = dice.roll()

        tvRolDice.text = diceRoll.toString()
    }
}