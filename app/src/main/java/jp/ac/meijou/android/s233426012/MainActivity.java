package jp.ac.meijou.android.s233426012;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.TextView;

import jp.ac.meijou.android.s233426012.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private PrefDataStore dataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataStore = PrefDataStore.getInstance(getApplicationContext());
//        dataStore.getString("name")
//                .ifPresent(name -> binding.text.setText(name));


        binding.changeButton.setOnClickListener(view ->{
            var text = binding.editTextText.getText().toString();
            binding.text.setText(text);
        });

        binding.saveButton.setOnClickListener(view -> {
            var text = binding.editTextText.getText().toString();
            dataStore.setString("name", text);
            Log.d("murayama","save: "+text);
        });

        binding.editTextText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // テキストが更新される直前に呼ばれる
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 文字を1つ入力された時に呼ばれる
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // テキストが更新されたあとに呼ばれる
//                binding.text.setText(editable.toString());
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        dataStore.getString("name")
                .ifPresent(name -> binding.text.setText(name));
    }
}