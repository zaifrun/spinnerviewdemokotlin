package org.pondar.spinnerviewdemokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import org.pondar.spinnerviewdemokotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //you can also put these values in xml - the book shows how.
    private val items = arrayOf("Item 0", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7")

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //The spinner is defined in our xml file

        //we use a predefined simple spinner drop down,
        //you could define your own layout, so that for instance
        //there was pictures in the drop down list.
        val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, items)

        binding.spinner1.adapter = adapter

        binding.spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            //The AdapterView<?> type means that this can be any type,
            //so we can use both AdapterView<String> or any other
            override fun onItemSelected(adapterView: AdapterView<*>, view: View,
                                        position: Int, id: Long) {
                //So this code is called when ever the spinner is clicked
                Toast.makeText(this@MainActivity,
                        "Item selected: " + items[position], Toast.LENGTH_SHORT)
                        .show()
            }

            override fun onNothingSelected(arg0: AdapterView<*>) {
                // you would normally do something here
                // for instance setting the selected item to "null"
                // or something.
            }
        }

        //here is another way of initializing a spinner - getting the resources
        //from the xml values file
        val adapter2 = ArrayAdapter.createFromResource(
                this, R.array.spinner_array, android.R.layout.simple_spinner_dropdown_item)

        binding.spinner2.adapter = adapter2
        binding.spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val listArray = resources.getStringArray(R.array.spinner_array)
                Toast.makeText(this@MainActivity,
                        "Item selected: " + listArray[position], Toast.LENGTH_SHORT)
                        .show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        //This line of code can always be used to get the
        //selected position in in the spinner - the first item
        //will have an index of 0.
        val position = binding.spinner1.selectedItemPosition

        //This line will get the actual selected item -

        val item = binding.spinner1.selectedItem
    }
}
