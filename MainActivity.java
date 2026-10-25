package com.abir.ai;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private LinearLayout messages;
    private EditText input;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(20, 24, 20, 16);
        root.setBackgroundColor(Color.rgb(246, 248, 252));

        TextView title = new TextView(this);
        title.setText("Abir AI");
        title.setTextSize(28);
        title.setTextColor(Color.rgb(34, 76, 150));
        title.setGravity(Gravity.CENTER);
        title.setPadding(8, 12, 8, 18);
        root.addView(title, new LinearLayout.LayoutParams(-1, -2));

        TextView intro = new TextView(this);
        intro.setText("নমস্কার! আমি Abir AI-এর প্রাথমিক সংস্করণ। নিচে আপনার প্রশ্ন লিখুন।");
        intro.setTextSize(16);
        intro.setTextColor(Color.DKGRAY);
        intro.setPadding(12, 12, 12, 12);
        root.addView(intro);

        ScrollView scroll = new ScrollView(this);
        messages = new LinearLayout(this);
        messages.setOrientation(LinearLayout.VERTICAL);
        scroll.addView(messages);
        root.addView(scroll, new LinearLayout.LayoutParams(-1, 0, 1));

        LinearLayout bar = new LinearLayout(this);
        bar.setOrientation(LinearLayout.HORIZONTAL);
        input = new EditText(this);
        input.setSingleLine(false);
        input.setHint("বাংলায় প্রশ্ন লিখুন...");
        bar.addView(input, new LinearLayout.LayoutParams(0, -2, 1));

        Button send = new Button(this);
        send.setText("পাঠান");
        bar.addView(send);
        root.addView(bar);

        send.setOnClickListener(v -> sendMessage());
        setContentView(root);
    }

    private void sendMessage() {
        String question = input.getText().toString().trim();
        if (question.isEmpty()) return;
        addMessage("আপনি: " + question, true);
        input.setText("");
        addMessage("Abir AI: এটি প্রাথমিক ডেমো সংস্করণ। বাস্তব AI উত্তর চালু করতে নিরাপদ AI API সংযোগ ও সার্ভার সেটআপ করতে হবে।", false);
    }

    private void addMessage(String text, boolean user) {
        TextView bubble = new TextView(this);
        bubble.setText(text);
        bubble.setTextSize(15);
        bubble.setTextColor(user ? Color.WHITE : Color.rgb(35, 45, 60));
        bubble.setPadding(14, 12, 14, 12);
        bubble.setBackgroundColor(user ? Color.rgb(44, 103, 190) : Color.WHITE);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -2);
        params.setMargins(0, 6, 0, 6);
        messages.addView(bubble, params);
    }
}
