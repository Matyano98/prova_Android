package com.mateusyano.prova_android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewProdutos;
    private ProdutoDatabase db;
    private List<String> listaExibicao;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = ProdutoDatabase.getInstancia(this);
        listViewProdutos = findViewById(R.id.list_produtos);
        Button btnIrCadastro = findViewById(R.id.btn_voltar_cadastro);

        listaExibicao = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaExibicao);
        listViewProdutos.setAdapter(adapter);

        btnIrCadastro.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarProdutos();
    }

    private void carregarProdutos() {
        List<Produto> listaProdutos = db.produtoDao().listarTodos();
        listaExibicao.clear();

        for (Produto p : listaProdutos) {
            String info = p.getNome() + " | Código: " + p.getCodigo() + " | R$ " + String.format("%.2f", p.getPreco());
            listaExibicao.add(info);
        }

        adapter.notifyDataSetChanged();
    }
}
