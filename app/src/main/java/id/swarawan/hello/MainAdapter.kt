package id.swarawan.hello

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import id.swarawan.hello.databinding.ItemRecyclerviewBinding
import id.swarawan.hello.model.Mahasiswa

class MainAdapter(val onClicked: (Mahasiswa) -> Unit) :
    ListAdapter<Mahasiswa, MainAdapter.MainViewHolder>(diffCallback) {

    class MainViewHolder(
        val view: ItemRecyclerviewBinding,
        val onClicked: (Mahasiswa) -> Unit
    ) : ViewHolder(view.root) {
        fun render(mahasiswa: Mahasiswa) {
            view.itemName.text = mahasiswa.name
            view.itemUniv.text = mahasiswa.university
            view.root.setOnClickListener {
                onClicked.invoke(mahasiswa)
            }
        }
    }

    // mengikat tampilan item ke dalam adapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val viewHolder =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(viewHolder, onClicked)
    }

    // mengisi data mahasiswa ke dalam item
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.render(getItem(position))
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Mahasiswa>() {
            override fun areItemsTheSame(oldItem: Mahasiswa, newItem: Mahasiswa): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Mahasiswa, newItem: Mahasiswa): Boolean {
                return oldItem == newItem
            }
        }
    }
}