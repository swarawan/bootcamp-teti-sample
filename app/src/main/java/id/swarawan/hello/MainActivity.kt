package id.swarawan.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.swarawan.hello.databinding.ActivityMainBinding
import id.swarawan.hello.model.Mahasiswa

class MainActivity : AppCompatActivity() {

    private val mainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        val myAdapter = MainAdapter {
            Toast.makeText(this@MainActivity, "Halo ${it.name}", Toast.LENGTH_SHORT).show()
        }
        myAdapter.submitList(dummyData())

        mainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        mainBinding.recyclerView.adapter = myAdapter
    }

    private fun dummyData(): List<Mahasiswa> {
        return listOf(
            Mahasiswa(name = "Rio Swarawan Putra", university = "Universitas Gadjah Mada"),
            Mahasiswa(name = "John Doe", university = "Universitas Islam Indonesia"),
            Mahasiswa(name = "Jane Doe", university = "AMIKOM"),
        )
    }
}