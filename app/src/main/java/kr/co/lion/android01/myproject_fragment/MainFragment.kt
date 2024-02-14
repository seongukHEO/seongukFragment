package kr.co.lion.android01.myproject_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.divider.MaterialDividerItemDecoration
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
        setToolBar()
        setView()
        return fragmentMainBinding.root
    }
    //툴바 설정
    fun setToolBar(){
        fragmentMainBinding.apply {
            materialToolbar2.apply {
                //타이틀
                title = "학생 정보"
                //메뉴 설정
                inflateMenu(R.menu.main_menu)
                //메뉴를 클릭했을 때
                setOnMenuItemClickListener {
                    mainActivity.replaceFragment(FragmentName.INPUT_FRAGMENT, true, true, null)
                    true
                }
            }
        }

    }

    //뷰 설정
    fun setView(){
        fragmentMainBinding.apply {
            recyclerview.apply {
                //어댑터 객체
                adapter = StudentMainAdapter()
                //레이아웃
                layoutManager = LinearLayoutManager(mainActivity)
                //데코
                var deco = MaterialDividerItemDecoration(mainActivity, MaterialDividerItemDecoration.VERTICAL)
                addItemDecoration(deco)
            }
        }

    }

    //recyclerView 클래스
    inner class StudentMainAdapter : RecyclerView.Adapter<StudentMainAdapter.ViewHolderClass>(){

        //viewHolderClass
        inner class ViewHolderClass(mainRowBinding: MainRowBinding):RecyclerView.ViewHolder(mainRowBinding.root){
            var mainRowBinding:MainRowBinding

            init {
                this.mainRowBinding = mainRowBinding
                //가로 세로의 길이를 같게한다
                this.mainRowBinding.root.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
            var mainRowBinding = MainRowBinding.inflate(layoutInflater)
            var viewHolder = ViewHolderClass(mainRowBinding)
            return viewHolder
        }

        override fun getItemCount(): Int {
            var info1 = Info.infoList
            return info1.size
        }

        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
            var info1 = Info.infoList[position]
            holder.mainRowBinding.nameMainText.text = "이름 : ${info1.name}"
            holder.mainRowBinding.ageMainText.text = "나이 : ${info1.age}"
            //클릭했을 때
            holder.mainRowBinding.root.setOnClickListener {
                var bundle = Bundle()
                bundle.putInt("position", position)
                mainActivity.replaceFragment(FragmentName.INFO_FRAGMENT, true,true, bundle)
                onResume().apply {
                    //와 도저히 모르겠다ㅠㅠ
                    fragmentMainBinding.recyclerview.adapter?.notifyDataSetChanged()
                }
            }
        }
    }
}





























