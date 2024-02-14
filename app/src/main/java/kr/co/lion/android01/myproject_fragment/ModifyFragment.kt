package kr.co.lion.android01.myproject_fragment

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.co.lion.android01.myproject_fragment.databinding.FragmentModifyBinding

class ModifyFragment : Fragment() {
    lateinit var fragmentModifyBinding: FragmentModifyBinding
    lateinit var mainActivity: MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragmentModifyBinding = FragmentModifyBinding.inflate(layoutInflater)
        mainActivity = activity as MainActivity
        setToolBar()
        setView()
        checkOK()
        return fragmentModifyBinding.root
    }
    //툴바 설정
    fun setToolBar(){
        fragmentModifyBinding.apply {
            materialModifyToolbar.apply {
                //타이틀 설정
                title = "학생 정보 수정"
                //아이콘 설정
                setNavigationIcon(R.drawable.arrow_back_24px)
                //아이콘을 클릭했을 때
                setNavigationOnClickListener {
                    mainActivity.removeFragment(FragmentName.MODIFY_FRAGMENT)
                }
            }
        }
    }

    //뷰 설정
    fun setView(){
        fragmentModifyBinding.apply {
            var studentInfo = arguments?.getInt("info1", 0)
            if (studentInfo != null){
                var info1 = Info.infoList[studentInfo]

                nameModifyText.setText("${info1.name}")
                ageModifyText.setText("${info1.age}")
                korModifyText.setText("${info1.kor}")
                engModifyText.setText("${info1.eng}")
                mathModifyText.setText("${info1.math}")
            }
        }
    }
    //변경사항
    fun modifyInfo(){
        fragmentModifyBinding.apply {
            var studentInfo = arguments?.getInt("info1", 0)
            if (studentInfo != null) {
                var info1 = Info.infoList[studentInfo]
                info1.name = nameModifyText.text.toString()
                info1.age = ageModifyText.text.toString().toInt()
                info1.kor = korModifyText.text.toString().toInt()
                info1.eng = engModifyText.text.toString().toInt()
                info1.math = mathModifyText.text.toString().toInt()



            }
        }
    }

    //유효성 검사
    fun checkOK(){
        fragmentModifyBinding.apply {
            resultModifyButton.setOnClickListener {
                var name = nameModifyText.text.toString()
                var age = ageModifyText.text.toString()
                var kor = korModifyText.text.toString()
                var eng = engModifyText.text.toString()
                var math = mathModifyText.text.toString()

                if (name.trim().isEmpty()){
                    Info.showDiaLog(mainActivity, "이름 입력 오류", "이름을 입력해주세요"){ dialogInterface: DialogInterface, i: Int ->
                        Info.showSoftInput(nameModifyText, mainActivity)
                    }
                    return@setOnClickListener

                }
                if (age.trim().isEmpty()){
                    Info.showDiaLog(mainActivity, "나이 입력 오류", "나이를 입력해주세요"){ dialogInterface: DialogInterface, i: Int ->
                        Info.showSoftInput(ageModifyText, mainActivity)
                    }
                    return@setOnClickListener

                }
                if (kor.trim().isEmpty()){
                    Info.showDiaLog(mainActivity, "국어 점수 입력 오류", "국어 점수를 입력해주세요"){ dialogInterface: DialogInterface, i: Int ->
                        Info.showSoftInput(korModifyText, mainActivity)
                    }
                    return@setOnClickListener

                }
                if (eng.trim().isEmpty()){
                    Info.showDiaLog(mainActivity, "영어 점수 입력 오류", "영어 점수를 입력해주세요"){ dialogInterface: DialogInterface, i: Int ->
                        Info.showSoftInput(engModifyText, mainActivity)
                    }
                    return@setOnClickListener

                }
                if (math.trim().isEmpty()){
                    Info.showDiaLog(mainActivity, "수학 점수 입력 오류", "수학 점수를 입력해주세요"){ dialogInterface: DialogInterface, i: Int ->
                        Info.showSoftInput(mathModifyText, mainActivity)
                    }
                    return@setOnClickListener

                }
                modifyInfo()
                mainActivity.removeFragment(FragmentName.MODIFY_FRAGMENT)
            }
        }
    }
}































