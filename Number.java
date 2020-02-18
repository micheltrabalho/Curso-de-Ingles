package br.com.michel.android.cursodeingles.fragments;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.michel.android.cursodeingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Number extends Fragment implements View.OnClickListener {

    private MediaPlayer mediaPlayer;
    private Button bt1,bt2,bt3,bt4,bt5,bt6;

    public Number() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_number, container, false);

        bt1 = view.findViewById(R.id.btn1);
        bt2 = view.findViewById(R.id.btn2);
        bt3 = view.findViewById(R.id.btn3);
        bt4 = view.findViewById(R.id.btn4);
        bt5 = view.findViewById(R.id.btn5);
        bt6 = view.findViewById(R.id.btn6);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                tocarSom();
                break;
            case R.id.btn2:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                tocarSom();
                break;
            case R.id.btn3:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                tocarSom();
                break;
            case R.id.btn4:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                tocarSom();
                break;
            case R.id.btn5:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                tocarSom();
                break;
            case R.id.btn6:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
                tocarSom();
                break;

        }
    }

    public  void tocarSom(){
        if (mediaPlayer != null){
            mediaPlayer.start();
        }
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });
    }

}
