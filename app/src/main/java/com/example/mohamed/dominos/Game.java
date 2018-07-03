package com.example.mohamed.dominos;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class Game extends AppCompatActivity {
    Button btn;
    Button btn2;
    Button btn3;
    ArrayList<Tuile> tuiles = new ArrayList<>();
    Joueur j1 = new Joueur("moha",0);
    Joueur j2 = new Joueur("ouss",0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        tuiles.add(new Tuile(0,0,R.drawable.t00));
        tuiles.add(new Tuile(0,1,R.drawable.t01));
        tuiles.add(new Tuile(0,2,R.drawable.t02));
        tuiles.add(new Tuile(0,3,R.drawable.t03));
        tuiles.add(new Tuile(0,4,R.drawable.t04));
        tuiles.add(new Tuile(0,5,R.drawable.t05));
        tuiles.add(new Tuile(0,6,R.drawable.t06));
        tuiles.add(new Tuile(1,1,R.drawable.t11));
        tuiles.add(new Tuile(1,2,R.drawable.t12));
        tuiles.add(new Tuile(1,3,R.drawable.t13));
        tuiles.add(new Tuile(1,4,R.drawable.t14));
        tuiles.add(new Tuile(1,5,R.drawable.t15));
        tuiles.add(new Tuile(1,6,R.drawable.t16));
        tuiles.add(new Tuile(2,2,R.drawable.t22));
        tuiles.add(new Tuile(2,3,R.drawable.t23));
        tuiles.add(new Tuile(2,4,R.drawable.t24));
        tuiles.add(new Tuile(2,5,R.drawable.t25));
        tuiles.add(new Tuile(2,6,R.drawable.t26));
        tuiles.add(new Tuile(3,3,R.drawable.t33));
        tuiles.add(new Tuile(3,4,R.drawable.t34));
        tuiles.add(new Tuile(3,5,R.drawable.t35));
        tuiles.add(new Tuile(3,6,R.drawable.t36));
        tuiles.add(new Tuile(4,4,R.drawable.t44));
        tuiles.add(new Tuile(4,5,R.drawable.t45));
        tuiles.add(new Tuile(4,6,R.drawable.t46));
        tuiles.add(new Tuile(5,5,R.drawable.t55));
        tuiles.add(new Tuile(5,6,R.drawable.t56));
        tuiles.add(new Tuile(6,6,R.drawable.t66));
        tguessem(j1.hand);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.poser);
        btn = (Button)findViewById(R.id.button2);
        Button btn2 = (Button)findViewById(R.id.button3);
        Button btn3 = (Button)findViewById(R.id.button4);
/*
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation.setDuration(1000);
                animation.setFillAfter(true);
                animation.setFillBefore(false);
                btn.startAnimation(animation);
            }
        });*/
    }




    public int modulo(int x, int y) {

        if (y != 0) {
            return x % y;
        } else
            return 0;
    }

    public void tchamba(ArrayList<Tuile> tt) {
        int random;
        int mod = 0;
        Tuile temp;
        for (int i = 0; i < tt.size(); i++) {
            random = (int) (Math.random() * 1000);
            mod = modulo(random, 28);
            temp = tt.get(i);
            tt.set(i, tt.get(mod));
            tt.set(mod, temp);
        }

    }

    public void tguessem(ArrayList<Tuile> list1){
        tchamba(tuiles);
        for(int i=0;i<3;i++){
            list1.add(tuiles.get(i));
            tuiles.remove(i);
        }
        btn = (Button)findViewById(R.id.button2);
        btn2 = (Button)findViewById(R.id.button3);
        btn3 = (Button)findViewById(R.id.button4);
        btn.setBackground(getResources().getDrawable(list1.get(0).getImage()));
        btn2.setBackground(getResources().getDrawable(list1.get(1).getImage()));
        btn3.setBackground(getResources().getDrawable(list1.get(2).getImage()));
    }
    Tuile t= new Tuile(10,10,R.drawable.tvide);
    public Tuile trouverTuile(Drawable image){
        for (int k=0;k<j1.hand.size();k++){
            if (image.getConstantState()==getResources().getDrawable(j1.hand.get(k).getImage()).getConstantState()){
                return j1.hand.get(k);
            }
        }
        return t;
    }
    int i=-1;
    int j=-1;
    Tuile[] matrice = new Tuile[27];
    public void l3ab(View view){
        Button test = (Button)findViewById(view.getId());
        matrice[13]= trouverTuile((test.getBackground()));
        test.setText(String.valueOf(matrice[13].getFaceA()) );
        test.setBackground(getResources().getDrawable(matrice[13].getImage()));
        Button id11 =(Button)findViewById(R.id.id11);
        id11.setBackground(getResources().getDrawable(matrice[13].getImage()));
        test.setVisibility(View.INVISIBLE);
    }

}