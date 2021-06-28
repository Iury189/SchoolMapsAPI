package com.example.testmaps;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView; // Biblioteca necessária para AdapterView
import android.widget.ArrayAdapter; // Biblioteca necessária para ArrayAdapter
import android.widget.ListView; // Biblioteca necessária para ListView
import java.util.ArrayList; // Biblioteca necessária para ArrayList

public class MainActivity extends AppCompatActivity {
    // Declarando variáveis 
    ListView listview; // Componente ListView para armazenar grande quantidade de informações
    ArrayList<Local> arraylista; // Componente ArrayList utiliza vetor para armazenar elementos
    ArrayAdapter<Local> adapter; // Componente ArrayAdapter pode manipular dados com base em Arrays
    // Método que serve para iniciar as operações de incialização
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Atribuindo os ID dos objetos da activity_main.xml nas variáveis declaradas
        listview = findViewById(R.id.listview);
        // Cria um ArrayList adicionando os item e suas coordenadas
        arraylista = new ArrayList<>();
        arraylista.add(new Local("Colégio Estadual Idalice Nunes",
                -14.228510394148817, -42.7808594938455));
        arraylista.add(new Local("Colégio Modelo Luis Eduardo Magalhães",
                -14.215072988736308, -42.773156680374306));
        arraylista.add(new Local("Colégio Estadual Governador Luiz Viana Filho",
                -14.222421390183323, -42.779688828249576));
        arraylista.add(new Local("Colégio Municipal Josefina Teixeira Azevedo",
                -14.237062794831509, -42.767668171129884));
        // O ArrayAdapter irá organizar um item por vez nessa lista
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraylista);
        // Exibe os itens na lista associando um adaptador 
        listview.setAdapter(adapter); 
        // Retorno da chamada ao ser invocado quando um item no AdapterView for clicado
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // Evento onItemClick() disparado quando um item é clicado em RadTreeList
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Será descrita uma operação que adicionará valores e passará para outra Activity
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("Nome",arraylista.get(position).getNome());
                intent.putExtra("Latitude",arraylista.get(position).getLatitude());
                intent.putExtra("Longitude",arraylista.get(position).getLongitude());
                startActivity(intent);
            }
        });
    }
}