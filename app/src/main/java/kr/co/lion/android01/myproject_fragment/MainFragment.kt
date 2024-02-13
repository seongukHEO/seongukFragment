package kr.co.lion.android01.myproject_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.lion.android01.myproject_fragment.databinding.FragmentMainBinding
import kr.co.lion.android01.myproject_fragment.databinding.MainRowBinding


class MainFragment : Fragment() {

    lateinit var fragmentMainBinding: FragmentMainBinding
    lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragmentMainBinding = FragmentMainBinding.inflate(layoutInflater)
        mainActivity = activity as MainActivity
        return fragmentMainBinding.root
    }
    //툴바 설정
    fun setToolBar(){

    }

    //뷰 설정
    fun setView(){

    }

    //recyclerView 클래스
    inner class StudentMainAdapter : RecyclerView.Adapter<StudentMainAdapter.ViewHolderClass>(){

        //viewHolderClass
        inner class ViewHolderClass(mainRowBinding: MainRowBinding):RecyclerView.ViewHolder(mainRowBinding.root){
            var mainRowBinding:MainRowBinding

            init {
                this.mainRowBinding = mainRowBinding
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
            var mainRowBinding = MainRowBinding.inflate(layoutInflater)
            var viewHolder = ViewHolderClass(mainRowBinding)
            return viewHolder
        }

        override fun getItemCount(): Int {
            return 20
        }

        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
            holder.mainRowBinding.nameMainText.text = "홍, ${position}"
            holder.mainRowBinding.ageMainText.text = "23, ${position}"
        }
    }
}





























