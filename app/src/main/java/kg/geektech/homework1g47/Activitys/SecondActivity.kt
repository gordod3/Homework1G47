package kg.geektech.homework1g47.Activitys

import android.app.Activity
import kg.geektech.homework1g47.Core.Base.BaseActivity
import kg.geektech.homework1g47.Extension.Companion.toast
import kg.geektech.homework1g47.databinding.ActivitySecondBinding


class SecondActivity : BaseActivity<ActivitySecondBinding>() {

    override fun bindBinding(): ActivitySecondBinding {
        return ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun initView() {
        binding.etInputText.setText(intent.getStringExtra(INTENT_INPUT_TEXT))
    }

    override fun initListener() {

        binding.btSendText.setOnClickListener() {
            if (binding.etInputText.text.isNotEmpty()) {
                intent.putExtra(INTENT_INPUT_TEXT, binding.etInputText.text.toString()).apply {
                    setResult(Activity.RESULT_OK, this)
                }
                finish()
            }
            else toast("Заполните поле")

        }
    }
}