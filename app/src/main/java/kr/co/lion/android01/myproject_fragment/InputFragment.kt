package kr.co.lion.android01.myproject_fragment

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.co.lion.android01.myproject_fragment.databinding.FragmentInputBinding

class InputFragment : Fragment() {
    lateinit var fragmentInputBinding: FragmentInputBinding
    lateinit var mainActivity: MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragmentInputBinding = FragmentInputBinding.inflate(layoutInflater)
        mainActivity = activity as MainActivity
        setToolBar()
        checkOK()
        return fragmentInputBinding.root
    }
    //툴바 설정
    fun setToolBar(){
        fragmentInputBinding.apply {
            materialToolbar.apply {
                //타이틀
                title = "학생 정보 입력"
                //아이콘 설정
                setNavigationIcon(R.drawable.arrow_back_24px)
                //아이콘을 클릭했을 때
                setNavigationOnClickListener {
                    mainActivity.removeFragment(FragmentName.INPUT_FRAGMENT)
                }
            }
        }
    }


    //뷰 설정
    fun setView(){
        fragmentInputBinding.apply {
            var str = Info()

            str.name = nameInputText.text.toString()
            str.age = ageInputText.text.toString().toInt()
            str.kor = korInputText.text.toString().toInt()
            str.eng = engInputText.text.toString().toInt()
            str.math = mathInputText.text.toString().toInt()

            Info.infoList.add(str)

        }
    }

    //유효성 검사
    fun checkOK(){
        fragmentInputBinding.apply {
            resultButton.setOnClickListener {
                var name = nameInputText.text.toString()
                var age = ageInputText.text.toString()
                var kor = korInputText.text.toString()
                var eng = engInputText.text.toString()
                var math = mathInputText.text.toString()

                if (name.trim().isEmpty()){
                    Info.showDiaLog(mainActivity, "이름 입력 오류", "이름을 입력해주세요"){ dialogInterface: DialogInterface, i: Int ->
                        Info.showSoftInput(nameInputText, mainActivity)
                    }
                    return@setOnClickListener

                }
                if (age.trim().isEmpty()){
                    Info.showDiaLog(mainActivity, "나이 입력 오류", "나이를 입력해주세요"){ dialogInterface: DialogInterface, i: Int ->
                        Info.showSoftInput(ageInputText, mainActivity)
                    }
                    return@setOnClickListener

                }
                if (kor.trim().isEmpty()){
                    Info.showDiaLog(mainActivity, "국어 점수 입력 오류", "국어 점수를 입력해주세요"){ dialogInterface: DialogInterface, i: Int ->
                        Info.showSoftInput(korInputText, mainActivity)
                    }
                    return@setOnClickListener

                }
                if (eng.trim().isEmpty()){
                    Info.showDiaLog(mainActivity, "영어 점수 입력 오류", "영어 점수를 입력해주세요"){ dialogInterface: DialogInterface, i: Int ->
                        Info.showSoftInput(engInputText, mainActivity)
                    }
                    return@setOnClickListener

                }
                if (math.trim().isEmpty()){
                    Info.showDiaLog(mainActivity, "수학 점수 입력 오류", "수학 점수를 입력해주세요"){ dialogInterface: DialogInterface, i: Int ->
                        Info.showSoftInput(mathInputText, mainActivity)
                    }
                    return@setOnClickListener

                }
                setView()
                mainActivity.removeFragment(FragmentName.INPUT_FRAGMENT)

            }
        }

    }

}






































