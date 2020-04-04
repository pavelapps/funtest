package com.andreev.funtest.main_screen

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.andreev.funtest.R
import com.andreev.funtest.main_screen.adapter.CellAdapter
import com.andreev.funtest.main_screen.adapter.OnScrollDownListener
import com.andreev.funtest.main_screen.models.WorldItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Protocol.View {

    private var adapter: CellAdapter = CellAdapter(ArrayList())
    private lateinit var presenter: Protocol.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)

        initView()
    }

    private fun initView() {
        initRecyclerView()
        initClicks()
    }

    private fun initClicks() {
        generate_button.setOnClickListener {
            presenter.onGenerateButtonClick()
        }
    }

    private fun initRecyclerView() {
        cells_list.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter.apply {
                setScrollDownListener(object : OnScrollDownListener {
                    override fun onScroll(index: Int) {
                        cells_list.scrollToPosition(index)
                    }
                })
            }
        }
    }

    override fun addCell(cell: WorldItem) {
        adapter.addCell(cell)
    }
}
