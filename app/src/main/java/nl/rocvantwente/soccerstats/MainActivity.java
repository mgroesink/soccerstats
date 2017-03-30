package nl.rocvantwente.soccerstats;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnGoal1 , btnGoal2 , btnYC1 , btnYC2 , btnRC1 , btnRC2 , btnReset;
    TextView tvGoals1 , tvGoals2 , tvYC1 , tvYC2 , tvRC1 , tvRC2;
    int goals1 = 0 , goals2 = 0 , yc1 = 0 , yc2 = 0 , rc1 = 0 , rc2 = 0;
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view instanceof Button){
                Button b = (Button)view;
                int id = b.getId();
                switch(id) {
                    case R.id.buttonGoalTeam1:
                        goals1++;
                        tvGoals1.setText("Goals: " + goals1);
                        break;
                    case R.id.buttonGoalTeam2:
                        goals2++;
                        tvGoals2.setText("Goals: " + goals2);
                        break;
                    case R.id.buttonYellowCardTeam1:
                        yc1++;
                        tvYC1.setText("Yellow Cards: " + yc1);
                        break;
                    case R.id.buttonYellowCardTeam2:
                        yc2++;
                        tvYC2.setText("Yellow Cards: " + yc2);
                        break;
                    case R.id.buttonRedCardTeam1:
                        rc1++;
                        tvRC1.setText("Red Cards: " + rc1);
                        if(rc1 > 3){
                            finishGame(1);
                        }
                        break;
                    case R.id.buttonRedCardTeam2:
                        rc2++;
                        tvRC2.setText("Red Cards: " + rc2);
                        if(rc2 > 3){
                            finishGame(2);
                        }
                        break;
                    case R.id.buttonReset:

                            resetGame();

                        break;
                }
            }

        }
    };

    private void resetGame() {
        btnGoal1.setEnabled(true);
        btnGoal2.setEnabled(true);
        btnYC1.setEnabled(true);
        btnYC2.setEnabled(true);
        btnRC1.setEnabled(true);
        btnRC2.setEnabled(true);
        goals1 = 0;
        goals2 = 0;
        yc1 = 0;
        yc2 = 0;
        rc1 = 0;
        rc2 = 0;
        tvGoals1.setText("Goals: 0");
        tvGoals2.setText("Goals: 0");
        tvYC1.setText("Yellow Cards: 0");
        tvYC2.setText("Yellow Cards: 0");
        tvRC1.setText("Red Cards: 0");
        tvRC2.setText("Red Cards: 0");
    }

    private void finishGame(int teamnumber) {
        btnGoal1.setEnabled(false);
        btnGoal2.setEnabled(false);
        btnYC1.setEnabled(false);
        btnYC2.setEnabled(false);
        btnRC1.setEnabled(false);
        btnRC2.setEnabled(false);
        Toast toast = Toast.makeText(getApplicationContext() , "Game suspended.\nToo many red cards for team " + teamnumber
                + " to continue match." , Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGoal1 = (Button)findViewById(R.id.buttonGoalTeam1);
        btnGoal2 = (Button)findViewById(R.id.buttonGoalTeam2);
        btnYC1 = (Button)findViewById(R.id.buttonYellowCardTeam1);
        btnYC2 = (Button)findViewById(R.id.buttonYellowCardTeam2);
        btnRC1 = (Button)findViewById(R.id.buttonRedCardTeam1);
        btnRC2 = (Button)findViewById(R.id.buttonRedCardTeam2);
        btnReset = (Button)findViewById(R.id.buttonReset);
        tvGoals1 = (TextView)findViewById(R.id.textViewGoalsTeam1);
        tvGoals2 = (TextView)findViewById(R.id.textViewGoalsTeam2);
        tvYC1 = (TextView)findViewById(R.id.textViewYellowCardsTeam1);
        tvYC2 = (TextView)findViewById(R.id.textViewYellowCardsTeam2);
        tvRC1 = (TextView)findViewById(R.id.textViewRedCardsTeam1);
        tvRC2 = (TextView)findViewById(R.id.textViewRedCardsTeam2);
        btnGoal1.setOnClickListener(onClickListener);
        btnGoal2.setOnClickListener(onClickListener);
        btnYC1.setOnClickListener(onClickListener);
        btnYC2.setOnClickListener(onClickListener);
        btnRC1.setOnClickListener(onClickListener);
        btnRC2.setOnClickListener(onClickListener);
        btnReset.setOnClickListener(onClickListener);
    }
}
