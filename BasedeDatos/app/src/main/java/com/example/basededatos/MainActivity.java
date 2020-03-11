package com.example.basededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etCodigo, etDescripcion, etPrecio;
    private Button btnRegistrar, btnBuscar, btnModificar, btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCodigo = findViewById(R.id.etCodigo);
        etDescripcion = findViewById(R.id.etDescripcion);
        etPrecio = findViewById(R.id.etPrecio);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnModificar = findViewById(R.id.btnModificar);
        btnEliminar = findViewById(R.id.btnEliminar);
    }

    public void registrar(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();   //Esta base de datos se va abrir en modo lectura y escritura

        String codigo = etCodigo.getText().toString();
        String descripcion = etDescripcion.getText().toString();
        String precio = etPrecio.getText().toString();

        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            baseDeDatos.insert("articulos", null, registro);    //El nombre de la tabla es el mismo que el que pusimos cuando creamos la tabla
            baseDeDatos.close();

            etCodigo.setText("");
            etDescripcion.setText("");
            etPrecio.setText("");
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Favor de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void buscar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        String codigo = etCodigo.getText().toString().trim();

        if(!codigo.isEmpty()){
            Cursor fila = baseDeDatos.rawQuery
                    ("select descripcion, precio from articulos where codigo =" + codigo, null);    //Este metodo nos ayuda a aplicar un select
            if(fila.moveToFirst()){ //Revisa si nuestra consula contiene valores
                etDescripcion.setText(fila.getString(0));
                etPrecio.setText(fila.getString(1));
                baseDeDatos.close();

            }
            else{
                Toast.makeText(this, "No existe el articulo", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Introduce el codigo del producto", Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        String codigo = etCodigo.getText().toString().trim();

        if(!codigo.isEmpty()){

            //delete() nos regresa un entero con la cantidad de articulos eliminados (borrados)
            int cantidad = baseDeDatos.delete("articulos", "codigo=" + codigo, null);   //whereClause: valor con el que va a rastrear el articulo producto
            baseDeDatos.close();

            etCodigo.setText("");
            etDescripcion.setText("");
            etPrecio.setText("");

            if(cantidad == 1){
                Toast.makeText(this, "Articulo eliminado correctamente", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "El articulo no existe", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Introduce el codigo del producto", Toast.LENGTH_SHORT).show();
        }
    }
}
