package com.mateusyano.prova_android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private EditText editNome, editCodigo, editPreco, editQuantidade;
    private ProdutoDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        db = ProdutoDatabase.getInstancia(this);

        editNome = findViewById(R.id.edit_nome);
        editCodigo = findViewById(R.id.edit_codigo);
        editPreco = findViewById(R.id.edit_preco);
        editQuantidade = findViewById(R.id.edit_quantidade);
        Button btnSalvar = findViewById(R.id.btn_salvar);
        Button btnVerLista = findViewById(R.id.btn_ver_lista);

        btnSalvar.setOnClickListener(v -> salvarProduto());

        btnVerLista.setOnClickListener(v -> {
            Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void salvarProduto() {
        String nome = editNome.getText().toString().trim();
        String codigo = editCodigo.getText().toString().trim();
        String precoStr = editPreco.getText().toString().trim();
        String quantidadeStr = editQuantidade.getText().toString().trim();

        if (nome.isEmpty() || codigo.isEmpty() || precoStr.isEmpty() || quantidadeStr.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double preco = Double.parseDouble(precoStr);
            int quantidade = Integer.parseInt(quantidadeStr);

            if (preco <= 0) {
                Toast.makeText(this, "O preço deve ser um número positivo", Toast.LENGTH_SHORT).show();
                return;
            }

            if (quantidade <= 0) {
                Toast.makeText(this, "A quantidade deve ser um número inteiro positivo", Toast.LENGTH_SHORT).show();
                return;
            }

            Produto produto = new Produto(nome, codigo, preco, quantidade);
            db.produtoDao().inserir(produto);

            Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            limparCampos();

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Erro: Verifique os valores de preço e quantidade", Toast.LENGTH_SHORT).show();
        }
    }

    private void limparCampos() {
        editNome.setText("");
        editCodigo.setText("");
        editPreco.setText("");
        editQuantidade.setText("");
        editNome.requestFocus();
    }
}
