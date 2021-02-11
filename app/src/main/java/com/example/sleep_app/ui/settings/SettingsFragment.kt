package com.example.sleep_app.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.sleep_app.R

@Suppress("DEPRECATION")
class SettingsFragment : Fragment(), View.OnClickListener {

    private lateinit var settingsViewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        settingsViewModel =
            ViewModelProvider(this).get(SettingsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_settings, container, false)
        /*val textView: TextView = root.findViewById(R.id.textSettings)
        settingsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttChangeTime: Button = requireView().findViewById(R.id.buttonChangeTime) as Button
        buttChangeTime.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
                val changetime: Fragment = changetimeFragment()
        val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
        transaction.replace(R.id.nav_host_fragment,changetime)

    }
}