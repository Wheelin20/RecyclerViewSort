package layout

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.waldoms.recyclerviewsort.R

class MyAdapter(val c:Context, val spacecrafts:ArrayList<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v:View = LayoutInflater.from(c).inflate(R.layout.model, parent, false)

        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return spacecrafts.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameTxt.text = spacecrafts[position]
    }

    class MyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)
    {
        val nameTxt:TextView = itemView.findViewById(R.id.nameTxt)
    }
}