package com.example.myapplication.conexao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.model.Venda;
import com.example.myapplication.model.Compra;

import java.util.ArrayList;
import java.util.List;


public class Conexao extends SQLiteOpenHelper {
    private final static String nome_banco = "fazenda";
    private final static int versao_banco =2;

    public Conexao(@Nullable Context context) {
        super(context, nome_banco, null, versao_banco);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//criar tabelas

        String sqlcreate2 = "CREATE TABLE compra(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "brinco TEXT," +
                "peso DOUBLE, " +
                "raca TEXT, " +
                "data TEXT, " +
                "valor DOUBLE," +
                "nome TEXT, " +
                "telefone TEXT)";
        db.execSQL(sqlcreate2);

        String sqlcreate = "CREATE TABLE venda(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "brinco TEXT," +
                "peso DOUBLE, " +
                "raca TEXT, " +
                "data TEXT, " +
                "valor DOUBLE," +
                "nome TEXT, " +
                "telefone TEXT)";
        db.execSQL(sqlcreate);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String droptable = "DROP TABLE venda";
        String droptable2 = "DROP TABLE compra";  //eliminar e criar o banco
        db.execSQL(droptable2);
        db.execSQL(droptable);

        onCreate(db);
    }

    public String createVenda(Venda venda)
    {
        long result;
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("brinco",venda.getBrinco());
        valores.put("peso",venda.getPeso());
        valores.put("raca",venda.getRaca());
        valores.put("data",venda.getData());
        valores.put("valor",venda.getValor());
        valores.put("nome",venda.getValor());
        valores.put("telefone",venda.getTelefone());

        result = db.insert("venda",null,valores);
        db.close();
        if(result==-1)
        {
            return "Erro ao registrar venda";
        }
        else
            {
                return "Venda registrada com sucesso!!!";
            }
    }
    public String updateVenda(Venda venda)
    {
        long result;
        SQLiteDatabase db = getWritableDatabase();
        String meuwhere = "id="+venda.getId();
        ContentValues valores = new ContentValues();
        valores.put("brinco",venda.getBrinco());
        valores.put("peso",venda.getPeso());
        valores.put("raca",venda.getRaca());
        valores.put("data",venda.getData());
        valores.put("valor",venda.getValor());
        valores.put("nome",venda.getValor());
        valores.put("telefone",venda.getTelefone());

        result = db.update("venda",valores,meuwhere,null);
        db.close();
        if(result==-1)
        {
            return "Erro ao alterar venda.";
        }
        else
        {
            return "Venda alterada com sucesso!!!";
        }

    }
    public String deleteVenda(int id)
    {
        long result;
        SQLiteDatabase db = getReadableDatabase();
        String meuwhere = "id="+id;
        result = db.delete("venda",meuwhere,null);
        db.close();
        if(result==-1)
        {
            return "Erro ao excluir venda.";
        }
        else
        {
            return "Venda excluida com sucesso!!!";
        }

    }
    public List<Venda> getVendas()
    {
        List<Venda> lista = new ArrayList<Venda>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from venda";
        Cursor rs = db.rawQuery(sql,null);
        if(rs.moveToFirst())
        {
            do{
                Venda b = new Venda();

                b.setId(rs.getInt(0));
                b.setBrinco(rs.getString(1));
                b.setPeso(rs.getDouble(2));
                b.setRaca(rs.getString(3));
                b.setData(rs.getString(4));
                b.setValor(rs.getDouble(5));
                b.setNome(rs.getString(6));
                b.setTelefone(rs.getString(7));


                lista.add(b);
            }while (rs.moveToNext());
        }
        return lista;
    }

    public Venda exibirVenda(int id)
    {
        Venda b = null;
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from venda where id="+id;
        Cursor rs = db.rawQuery(sql,null);
        if(rs.moveToFirst())
        {
            b = new Venda();

            b.setId(rs.getInt(0));
            b.setBrinco(rs.getString(1));
            b.setPeso(rs.getDouble(2));
            b.setRaca(rs.getString(3));
            b.setData(rs.getString(4));
            b.setValor(rs.getDouble(5));
            b.setNome(rs.getString(6));
            b.setTelefone(rs.getString(7));


        }
        return b;
    }


 ///////////////////compra////////////////

    public String createCompra(Compra compra)
    {
        long result;
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("brinco",compra.getBrinco());
        valores.put("peso",compra.getPeso());
        valores.put("raca",compra.getRaca());
        valores.put("data",compra.getData());
        valores.put("valor",compra.getValor());
        valores.put("nome",compra.getValor());
        valores.put("telefone",compra.getTelefone());

        result = db.insert("compra",null,valores);
        db.close();
        if(result==-1)
        {
            return "Erro ao registrar compra";
        }
        else
        {
            return "Compra registrada com sucesso!!!";
        }
    }
    public String updateCompra(Compra compra)
    {
        long result;
        SQLiteDatabase db = getWritableDatabase();
        String meuwhere = "id="+compra.getId();
        ContentValues valores = new ContentValues();
        valores.put("brinco",compra.getBrinco());
        valores.put("peso",compra.getPeso());
        valores.put("raca",compra.getRaca());
        valores.put("data",compra.getData());
        valores.put("valor",compra.getValor());
        valores.put("nome",compra.getValor());
        valores.put("telefone",compra.getTelefone());

        result = db.update("compra",valores,meuwhere,null);
        db.close();
        if(result==-1)
        {
            return "Erro ao alterar compra.";
        }
        else
        {
            return "Compra alterada com sucesso!!!";
        }

    }
    public String deleteCompra(int id)
    {
        long result;
        SQLiteDatabase db = getReadableDatabase();
        String meuwhere = "id="+id;
        result = db.delete("compra",meuwhere,null);
        db.close();
        if(result==-1)
        {
            return "Erro ao excluir compra.";
        }
        else
        {
            return "Compra excluida com sucesso!!!";
        }

    }
    public List<Compra> getCompras()
    {
        List<Compra> lista = new ArrayList<Compra>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from compra";
        Cursor rs = db.rawQuery(sql,null);
        if(rs.moveToFirst())
        {
            do{
                Compra b = new Compra();

                b.setId(rs.getInt(0));
                b.setBrinco(rs.getString(1));
                b.setPeso(rs.getDouble(2));
                b.setRaca(rs.getString(3));
                b.setData(rs.getString(4));
                b.setValor(rs.getDouble(5));
                b.setNome(rs.getString(6));
                b.setTelefone(rs.getString(7));


                lista.add(b);
            }while (rs.moveToNext());
        }
        return lista;
    }

    public Compra exibirCompra(int id)
    {
        Compra b = null;
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from compra where id="+id;
        Cursor rs = db.rawQuery(sql,null);
        if(rs.moveToFirst())
        {
            b = new Compra();

            b.setId(rs.getInt(0));
            b.setBrinco(rs.getString(1));
            b.setPeso(rs.getDouble(2));
            b.setRaca(rs.getString(3));
            b.setData(rs.getString(4));
            b.setValor(rs.getDouble(5));
            b.setNome(rs.getString(6));
            b.setTelefone(rs.getString(7));


        }
        return b;
    }




}
