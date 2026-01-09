package com.geeks.counter5.presentation.count

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.geeks.counter5.databinding.ActivityCountBinding
import com.geeks.counter5.domain.model.TypeOfOperations
import org.koin.androidx.viewmodel.ext.android.viewModel

class CountActivity : AppCompatActivity() {

    private val binding: ActivityCountBinding by lazy {
        ActivityCountBinding.inflate(layoutInflater)
    }

    private val viewModel: CountViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnPlus.setOnClickListener {
            viewModel.increment()
        }

        binding.btnMinus.setOnClickListener {
            viewModel.decrement()
        }

        binding.btnReset.setOnClickListener {
            viewModel.reset()
        }

        viewModel.countData.observe(this) { count ->
            binding.tvCounter.text = count.count.toString()

            binding.tvOperation.text = when (count.typeOfOperation) {
                TypeOfOperations.INCREMENT -> "Последняя операция: +"
                TypeOfOperations.DECREMENT -> "Последняя операция: -"
                TypeOfOperations.RESET -> "Последняя операция: reset"
                TypeOfOperations.NONE -> " "

            }
            binding.tvIncrementCount.text =
                "+ : ${count.countOfIncrement}"

            binding.tvDecrementCount.text =
                "- : ${count.countOfDecrement}"
        }
    }
}
