package com.example.yesable

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//class ApplicationFormActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_application_form)
//
//        val backbutton = findViewById<TextView>(R.id.back_button)
//        backbutton.setOnClickListener {
//            finish()
//        }
//
//        val apply_success = findViewById<Button>(R.id.btn_complete)
//        apply_success.setOnClickListener {
//            val intent = Intent(this, ApplySuccessActivity::class.java)
//            startActivity(intent)
//        }
//    }
//}
class ApplicationFormActivity : AppCompatActivity() {

    private var iconState = 0 // 아이콘 상태를 추적하기 위한 변수
    private val initialText = "저는 프로젝트 이력 2번의 1일 1커밋 챌린지를 통해 1000일 동안 꾸준히 코딩하며 실력을 키웠습니다. 삼성에서 개발자로 제 커리어를 시작하고 싶습니다. 긍정적이고 신입의 자신감과 패기를 보여주는 느낌으로 보여주고 성장가능성을 가장 많이 어필해줘"
    private val enhancedText = "성장 가능성을 갖춘 자신감 넘치는 개발자\n" +
            "저는 2000년생, 시각장애를 가진 23세의 홍길동입니다. 하나고등학교를 졸업한 후, 예서블대학교에서 컴퓨터공학과를 전공하며 학사 학위를 취득하였고, 서울대학교에서 컴퓨터공학 석사와 박사 과정을 마치며 제 전공 분야에 대한 깊은 지식을 쌓아왔습니다. 이러한 학문적 여정은 저에게 전공에 대한 깊은 이해와 연구 능력을 배양할 수 있는 기회를 제공했습니다.\n" +
            "\n" +
            "저는 시각장애라는 어려움을 극복하며, 제 자신을 끊임없이 발전시키고자 노력해왔습니다. 시각장애는 저에게 도전이었지만, 이를 극복하면서 얻은 강한 의지와 집중력은 저를 더욱 단단하게 만들었습니다. 학업뿐만 아니라, 실무적인 역량을 기르기 위해 다양한 프로젝트에 참여하며 실제적인 경험을 쌓았습니다. 두 번의 프로젝트 경험을 통해 개발 전반에 대한 이해를 높였고, 이를 바탕으로 실제 현업에 바로 적용할 수 있는 실력을 갖추게 되었습니다.\n" +
            "\n" +
            "특히, 저는 1일 1커밋 챌린지를 수행하며 1000일 동안 단 96번을 제외하고 매일 코드를 커밋하는 성실함과 끈기를 발휘했습니다. 이는 단순한 코드 작성 이상의 의미를 지니며, 지속적인 학습과 발전을 위해 끊임없이 노력하는 제 모습을 잘 보여줍니다. 이 과정에서 문제 해결 능력과 새로운 기술 습득 능력을 향상시켰으며, 이를 통해 저만의 독창적인 솔루션을 제시할 수 있는 개발자로 성장할 수 있었습니다.\n" +
            "\n" +
            "저는 컴퓨터 활용 능력 1급과 한국사 능력 검정시험 3급 자격증을 보유하고 있으며, 이는 제가 다양한 분야에서 요구되는 역량을 충족시킬 수 있음을 증명합니다. 특히, IT 분야에서 필요한 고급 컴퓨터 활용 능력은 제가 다양한 기술적 문제를 해결하는 데 큰 도움을 줄 수 있습니다.\n" +
            "\n" +
            "삼성의 개발자로서, 저는 제 학문적 배경과 실무 경험을 바탕으로 회사의 성장에 기여할 준비가 되어 있습니다. 저는 삼성에서 제 잠재력을 발휘하고, 더 나아가 회사의 비전과 함께 성장할 수 있는 기회를 찾고 있습니다. 저는 신입이지만, 깊이 있는 지식과 강한 책임감을 가지고 있으며, 이러한 점이 삼성에서의 성공적인 커리어를 보장할 것이라고 확신합니다.\n" +
            "\n" +
            "저는 삼성에서의 도전을 통해, 기술적인 역량을 한층 더 강화하고, 팀과 함께 의미 있는 성과를 창출하는 개발자가 되고자 합니다. 제게 주어진 모든 기회를 성실히 수행하며, 삼성의 미래와 함께 성장하는 개발자로 나아가겠습니다.\n" +
            "\n" +
            "감사합니다."

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application_form)

        val backbutton = findViewById<TextView>(R.id.back_button)
        backbutton.setOnClickListener {
            finish()
        }

        val applySuccess = findViewById<Button>(R.id.btn_complete)
        applySuccess.setOnClickListener {
            val intent = Intent(this, ApplySuccessActivity::class.java)
            startActivity(intent)
        }

        // EditText와 ImageView 참조
        val editText = findViewById<EditText>(R.id.et_self_introduction)
        val iconSwitch = findViewById<ImageView>(R.id.icon_switch)

        // 초기 텍스트 설정
//        editText.setText(initialText)

        // 아이콘 전환 로직
        iconSwitch.setOnClickListener {
            when (iconState) {
                0 -> {
                    // 첫 번째 클릭: 로딩 아이콘으로 변경
                    iconSwitch.setImageResource(R.drawable.loading_icon)
                    iconState = 1
                }
                1 -> {
                    // 두 번째 클릭: back.png 아이콘으로 변경 및 텍스트 변경
                    editText.setText(enhancedText)
                    iconSwitch.setImageResource(R.drawable.back)
                    iconState = 2
                }
                2 -> {
                    // 세 번째 클릭: 초기 아이콘 및 초기 텍스트로 복원
                    editText.setText(initialText)
                    iconSwitch.setImageResource(R.drawable.stardust_icon)
                    iconState = 0
                }
            }
        }
    }
}