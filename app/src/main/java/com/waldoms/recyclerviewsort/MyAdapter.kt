package layout

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.waldoms.recyclerviewsort.BR
import com.waldoms.recyclerviewsort.R
import com.waldoms.recyclerviewsort.SpacecraftViewModel

class MyAdapter(val viewModel:SpacecraftViewModel) : RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding:ViewDataBinding = DataBindingUtil.inflate(layoutInflater, R.layout.model, parent, false)

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return viewModel.spacecrafts.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(viewModel, position)
    }

    class MyViewHolder(val binding:ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(viewModel:SpacecraftViewModel, position: Int)
        {
            this.binding.setVariable(BR.shipName, viewModel.spacecrafts[position])
        }
    }
}