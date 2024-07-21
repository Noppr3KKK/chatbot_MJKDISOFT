package com.mjkdisoft.chatbot;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mjkdisoft.chatbot.databinding.BotLayoutBinding;
import com.mjkdisoft.chatbot.databinding.HumanLayoutBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class NormalGenre extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;
    private List<ChatModel> chatList;
    BotLayoutBinding binding;
    HumanLayoutBinding humanBinding;
    private HashMap<String, String> responses;
    private EditText inputMessage;
    private List<String> kataKasar = Arrays.asList("cok", "jembut", "asu", "ngentod", "kontol", "memek", "asw", "jembot","k0nt0l","kintil");
    private ImageView sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = BotLayoutBinding.inflate(getLayoutInflater());
        humanBinding = HumanLayoutBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        setContentView(humanBinding.getRoot());
        setContentView(R.layout.genre_normal_act);

        recyclerView = findViewById(R.id.chatOutput);
        inputMessage = findViewById(R.id.userInput);
        sendButton = findViewById(R.id.send);

        chatList = new ArrayList<>();
        chatAdapter = new ChatAdapter(chatList, false, false, false);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(chatAdapter);

        initializeResponses();
        binding.bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NormalGenre.this, "AI Response", Toast.LENGTH_SHORT).show();
            }
        });
        humanBinding.human.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NormalGenre.this, "User Response", Toast.LENGTH_SHORT).show();
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = inputMessage.getText().toString();
                if (!message.isEmpty()) {
                    String censoredMessage = censorText(message);

                    String timestamp = getCurrentTimestamp();
                    chatList.add(new ChatModel(censoredMessage, false, timestamp));
                    chatAdapter.notifyItemInserted(chatList.size() - 1);
                    recyclerView.scrollToPosition(chatList.size() - 1);

                    inputMessage.setText("");

                    String botResponse = getBotResponse(censoredMessage);
                    chatList.add(new ChatModel(botResponse, true, timestamp));
                    chatAdapter.notifyItemInserted(chatList.size() - 1);
                    recyclerView.scrollToPosition(chatList.size() - 1);
                }
            }
        });
    }

    private String censorText(String text) {
        for (String word : kataKasar) {
            String replacement = new String(new char[word.length()]).replace('\0', '*');
            text = text.replaceAll("(?i)" + word, replacement);
        }
        return text;
    }

    private void initializeResponses() {
        responses = new HashMap<>();
        List<String> haloKeywords = Arrays.asList("halo", "hi", "p", "hello", "helo");
        addResponse(haloKeywords, "Halo! Apa kabar?");
        responses.put("kamu dibuat menggunakan bahasa pemrograman apa?", "Maaf, saya tidak bisa membongkarnya");
        responses.put("siapa namamu", "Saya adalah ChatBot sederhana.");
        responses.put("apa yang bisa kamu lakukan?", "Saya bisa sedikit membantu anda, tim developer kami masih akan terus mengembangkan AI menjadi lebih baik nantinya..");
        responses.put("siapa", "Maaf, Anda bertanya nama siapa?");
        responses.put("cuaca", "Maaf, saya tidak dilengkapi dengan fitur cuaca.");
        responses.put("makanan", "Apa makanan favoritmu?");
        responses.put("berikan rekomendasi film horror","blood red sky,danur i can see ghost,haunted asylum,alive,train to bussan");
        responses.put("berikan rekomendasi film setan","blood red sky,danur i can see ghost,haunted asylum,alive,train to bussan");
        responses.put("berikan rekomendasi film hantu","blood red sky,danur i can see ghost,haunted asylum,alive,train to bussan");
        responses.put("berikan rekomendasi film fantasi","lord of the rings,The Witcher: Nightmare of the Wolf,Spider-Man: No Way Home (2021),The Green Knight,The Adam Project");
        responses.put("berikan rekomendasi film pahlawan","lord of the rings,The Witcher: Nightmare of the Wolf, Spider-Man: No Way Home (2021), The Green Knight, The Adam Project, Superman, Batman, Iron Man");
        responses.put("berikan rekomendasi film comedy","Ada Apa dengan Cinta? 2, My Stupid Boss, Love for Sale,Comic 8: Casino Kings Part 1, Terlalu Tampan, yowes ben");
        responses.put("berikan rekomendasi film komedi","Ada Apa dengan Cinta? 2, My Stupid Boss, Love for Sale,Comic 8: Casino Kings Part 1, Terlalu Tampan, yowes ben");
        responses.put("berikan rekomendasi film lawak","Ada Apa dengan Cinta? 2, My Stupid Boss, Love for Sale,Comic 8: Casino Kings Part 1, Terlalu Tampan, yowes ben");
        responses.put("berikan rekomendasi film action","The Raid: Redemption,Mission: Impossible, Mad Max: Fury Road,John Wick, Pacific Rim (2013), The Matrix (1999)");
    }

    private String getBotResponse(String userText) {
        String response = responses.get(userText.toLowerCase());

        if (response == null) {
            response = "Maaf, saya tidak mengerti. Bisa ulangi?";
        }

        return response;
    }
    private void addResponse(List<String> keywords, String response){
        for (String keyword : keywords) {
            responses.put(keyword.toLowerCase(), response);
        }
    }

    private String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return sdf.format(new Date());
    }
}
