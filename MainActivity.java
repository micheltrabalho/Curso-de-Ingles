
import android.media.MediaPlayer;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.michel.android.cursodeingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Animal extends Fragment implements View.OnClickListener {//quando tiver varios botoes no fragment utilizar o "implements View.Oncli.."

     private MediaPlayer mediaPlayer;
    private Button btndog, btncat, btncow, btnlion, btnmonkey, btnsheep;

    public Animal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_animal2, container, false);// esse trecho foi alterado, no lugar de "return inflater.inflate" crie uma varial View view, para poder criar acoes nos botoes


        //criando botoes

        btncat = view.findViewById(R.id.btnGato);
        btncow = view.findViewById(R.id.btnVaca);
        btndog = view.findViewById(R.id.btnCachorro);
        btnlion = view.findViewById(R.id.btnLeao);
        btnmonkey = view.findViewById(R.id.btnMacaco);
        btnsheep = view.findViewById(R.id.btnOvelha);

        btnsheep.setOnClickListener(this);
        btnmonkey.setOnClickListener(this);
        btnlion.setOnClickListener(this);
        btndog.setOnClickListener(this);
        btncat.setOnClickListener(this);
        btncow.setOnClickListener(this);


        return view;

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCachorro:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);//quando utilizar o MediaPlayer no fragment, precisa do getActivity no lugar de getApplication
                tocarSom();
                break;
            case R.id.btnGato:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                tocarSom();
                break;
            case R.id.btnMacaco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                tocarSom();
                break;
            case R.id.btnLeao:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lion);
                tocarSom();
                break;
            case R.id.btnVaca:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.cow);
                tocarSom();
                break;
            case R.id.btnOvelha:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.sheep);
                tocarSom();
                break;
        }
    }

    public void tocarSom(){ //metodo criado para executar o som
        if (mediaPlayer != null){
            mediaPlayer.start();
        }

        // o metodo abaixo serve para quando o som acabar liberar a funcao para tocar novamente
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });
    }
}
