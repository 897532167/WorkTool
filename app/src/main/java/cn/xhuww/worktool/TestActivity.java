package cn.xhuww.worktool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.annimon.stream.Optional;
import com.annimon.stream.Stream;

import java.util.Arrays;

/**
 * 作者：xhu_ww on 2018/3/25.
 * 描述：
 */

public class TestActivity extends AppCompatActivity {
    Button button;
    String[] testStr = {"Lambda", "Stream", null, "Optional", "Local", "Zoned", ""};
//    String[] testStr = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
//        button = findViewById(R.id.btn_test);
        testJava8();
    }

    private void testJava8() {
//        //Lambda表达式
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showToast("点击了按钮");
//            }
//        });
//        button.setOnClickListener(v -> showToast("点击了按钮"));
        //https://github.com/aNNiMON/Lightweight-Stream-API
        //Java 8
//        Arrays.asList(testStr).forEach(s -> log(s));

        //非官方兼容的 com.annimon.stream;
        //遍历
//        Stream.of(testStr).forEach(s -> log(s));
//        Stream.of(testStr).forEach(this::log);
//        Stream.of(Arrays.asList(testStr)).forEach(s -> log(s));

//        Stream.of(Arrays.asList(testStr)).filterNot(String::isEmpty).forEach(s -> log(s));
        //判空
//        Optional.ofNullable(Arrays.asList(testStr))
//                .filter(lt -> lt.size() > 0)
//                .stream()
//                .flatMap(list -> Stream.of(list))
//                .withoutNulls()
////                .filterNot()
//                .forEach(s -> log(s));
//
//        Optional.ofNullable(testStr)
//                .stream()
//                .flatMap(Stream::of)
//                .map(String::toLowerCase)
//                .forEach(this::log);
//
//        Optional.ofNullable(testStr)
//                .stream()
//                .flatMap(Stream::of)
//                .map(String::toLowerCase)
//                .forEach(this::log);


//        String str = Optional
//                .ofNullable(user)
//                .map(u -> u.getUserName())
//                .orElse("0个设备");

        User user = new User();
        String nickName = Optional
                .ofNullable(user)
                .map(user1 -> user.getUserMsg())
                .map(userMsg -> userMsg.getUserName())
                .orElse("admin");
        log(nickName);
        user.setUserMsg(new UserMsg("test"));

        log(Optional
                .ofNullable(user)
                .map(user1 -> user.getUserMsg())
                .map(userMsg -> userMsg.getUserName())
                .orElse("admin"));


//        if (testStr != null) {
//            for (String s : testStr) {
//                if (TextUtils.isEmpty(s)) {
//                    s = s.toLowerCase();
//                    log(s);
//                }
//            }
//        }

//        Stream.of(testStr)
//                .filterNot(TextUtils::isEmpty)
//                .forEach(this::log);

    }

    private void showToast(String msg) {
        Toast.makeText(TestActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    private void log(String msg) {
        Log.i(this.getClass().getName(), "----" + msg);
    }

    class User {
        public User() {
        }

        private String userId;
        private UserMsg userMsg;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public UserMsg getUserMsg() {
            return userMsg;
        }

        public void setUserMsg(UserMsg userMsg) {
            this.userMsg = userMsg;
        }
    }

    class UserMsg {
        private String userName;

        public UserMsg(String userName) {
            this.userName = userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }
    }
}