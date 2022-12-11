package kg.geektech.homework1g47.Activitys

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import kg.geektech.homework1g47.Core.Base.BaseActivity
import kg.geektech.homework1g47.Extension.Companion.toast
import kg.geektech.homework1g47.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val resultLauncher = registerForActivityResult(StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val data: Intent? = it.data
            val text = data!!.getStringExtra(INTENT_INPUT_TEXT)
            binding.etInputText.setText(text)
            Log.e("lol", "$text")
        }
    }

    override fun bindBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initListener() {
        binding.btSendText.setOnClickListener() {
            //Я имею права не создавать переменную intent а просто написать вот так?
            if (binding.etInputText.text.isNotEmpty())
                Intent(this, SecondActivity::class.java).apply {
                    putExtra(INTENT_INPUT_TEXT, binding.etInputText.text.toString())
                    resultLauncher.launch(this) }
            else toast("Заполните поле")
        }
    }
}