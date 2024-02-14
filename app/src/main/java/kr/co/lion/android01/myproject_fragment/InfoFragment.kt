package kr.co.lion.android01.myproject_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.co.lion.android01.myproject_fragment.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {
    lateinit var fragmentInfoBinding: FragmentInfoBinding
    lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragmentInfoBinding = FragmentInfoBinding.inflate(layoutInflater)
        mainActivity = activity as MainActivity
        setToolBar()
        setView()
        return fragmentInfoBinding.root
    }
    //툴바 설정
    fun setToolBar(){
        fragmentInfoBinding.apply {
            materialToolbar3.apply {
                //타이틀
                title = "학생 정보 출력"
                //아이콘 설정
                setNavigationIcon(R.drawable.arrow_back_24px)
                //아이콘을 눌렀을 때
                setNavigationOnClickListener {
                    mainActivity.removeFragment(FragmentName.INFO_FRAGMENT)
                }
                //메뉴 설정
                inflateMenu(R.menu.info_menu)
                //메뉴를 눌렀을 때 -- 분기한다
                setOnMenuItemClickListener {
                    when(it.itemId){
                        R.id.modify_menu -> {
                            var info = arguments?.getInt("position", 0)!!
                            var bundle = Bundle()
                            bundle.putInt("info", info)
                            mainActivity.replaceFragment(FragmentName.MODIFY_FRAGMENT, true,true, bundle)

                        }
                        R.id.delect_menu -> {
                            var info = arguments?.getInt("position", 0)!!
                            Info.infoList.removeAt(info)

                            mainActivity.removeFragment(FragmentName.INFO_FRAGMENT)

                        }
                    }

                    true
                }
            }
        }
    }

    //뷰 설정
    fun setView(){
        fragmentInfoBinding.apply {
            resultText.apply {
                var info = arguments?.getInt("position", 0)
                if (info != null) {
                    var studentInfo = Info.infoList[info]

                    text = "이름 : ${studentInfo.name}\n"
                    append("나이 : ${studentInfo.age}\n")
                    append("국어 점수 : ${studentInfo.kor}\n")
                    append("영어 점수 : ${studentInfo.eng}\n")
                    append("수학 점수 : ${studentInfo.math}\n")

                }
            }
        }
    }
}


































