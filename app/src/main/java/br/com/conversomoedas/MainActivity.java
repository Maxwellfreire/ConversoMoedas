package br.com.conversomoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValor = (EditText) findViewById(R.id.editValor);
        this.mViewHolder.txtDollar = (TextView) findViewById(R.id.txtDollar);
        this.mViewHolder.txtEuro = (TextView) findViewById(R.id.txtEuro);
        this.mViewHolder.btnCalc = (Button) findViewById(R.id.btnCalc);
        this.mViewHolder.btnLimpa = (Button) findViewById(R.id.btnlimpa);

        this.mViewHolder.btnCalc.setOnClickListener(this);
        this.mViewHolder.btnLimpa.setOnClickListener(this);

        this.clearValues();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnCalc) {
            String value = this.mViewHolder.editValor.getText().toString();
            if("".equals(value)){
                Toast.makeText(getApplicationContext(), "Informe dados", Toast.LENGTH_SHORT).show();

            }else{
                Double real = Double.valueOf(value);
                this.mViewHolder.txtDollar.setText(String.format("%.2f", real * 3));
                this.mViewHolder.txtEuro.setText(String.format("%.2f", real * 4));


            }



        }
        if (id == R.id.btnlimpa){
            clearValues();

        }

    }

    private void clearValues() {
        this.mViewHolder.txtDollar.setText("");
        this.mViewHolder.txtEuro.setText("");

    }

    private static class ViewHolder {

        EditText editValor;
        TextView txtDollar, txtEuro;
        Button btnCalc,btnLimpa;


    }
}
