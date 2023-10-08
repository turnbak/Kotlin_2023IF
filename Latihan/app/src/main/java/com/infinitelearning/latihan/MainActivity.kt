package com.infinitelearning.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.infinitelearning.latihan.databinding.ActivityLoginBinding
import com.infinitelearning.latihan.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tv: TextView
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.textView2)

        val username = intent.getParcelableExtra<User>("User")?.username
        val password = intent.getParcelableExtra<User>("User")?.password

        tv.text = "Username: $username, Password: $password"

        val btnImplicit: Button = findViewById(R.id.btn_implicit)
        btnImplicit.setOnClickListener(this)

        val btnFragment1: Button = findViewById(R.id.fragmen1_btn)
        btnFragment1.setOnClickListener(this)

        val btnFragment2: Button = findViewById(R.id.fragmen2_btn)
        btnFragment2.setOnClickListener(this)


        fragmentManager = supportFragmentManager

        val fragmentA = Fragment1()
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragmentA)
            .commit()

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_implicit -> {
                val message = "Hallo tes"
                val intent1 = Intent()
                intent1.action = Intent.ACTION_SEND
                intent1.putExtra(Intent.EXTRA_TEXT, message)
                intent1.type = "text/plain"
                startActivity(intent1)

                val intent2 = Intent()
                intent2.putExtra("history", "Anda Sudah Login")
                setResult(RESULT_OK, intent2)
                finish()
            }

            R.id.fragmen1_btn -> {
                val fragment1 = Fragment1()
                fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment1)
                    .commit()
            }

            R.id.fragmen2_btn -> {
                val fragment2 = Fragment2()
                fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment2)
                    .commit()
            }
        }
    }
}
