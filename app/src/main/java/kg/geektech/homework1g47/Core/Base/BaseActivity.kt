package kg.geektech.homework1g47.Core.Base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB:ViewBinding> : AppCompatActivity() {
    protected var text: String? = null
    //Стараюсь удалять(приравниваю к null) binding после того как активити будет onDestroy чтобы экономить
    // ресурсы.
    private var _binding: VB? = null
    protected val binding get() = _binding!!
    protected val INTENT_INPUT_TEXT = "text"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindBinding()
        setContentView(binding.root)
        initView()
        initListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    protected abstract fun bindBinding() : VB

    protected open fun initView(){}

    protected abstract fun initListener()
}