package com.sigaviewer.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.sigaviewer.entities.Estudante;
import com.sigaviewer.entities.Materia;
import com.sigaviewer.entities.Periodo;
import com.sigaviewer.util.Session;

import java.util.ArrayList;

/**
 * Created by PMateus on 16/09/2015.
 * For project SIG@Viewer.
 * Contact: <paulomatew@gmail.com>
 */
public class SqliteManager {
    /*
    http://randomkeygen.com/
    TODO trocar keys a cada versão do app
     */
    /* Nome do Banco de Dados */
    private final String UNIQ_KEY = "5q7TA#Y";
    private final String DATABASE_NAME = UNIQ_KEY + "Sig@Viewer";
    /*Entidades do BD*/
    private final String table_name_user = "usuario", table_name_periodo = "periodo", table_name_materia = "materia";

    /* Modo de acesso ao banco de dados
     *
     * Configura as permissões de acesso ao banco de dados.
     *
     * 0 - Modo privado (apenas essa aplicação pode usar o banco).
     * 1 - Modo leitura para todos (outras aplicações podem usar o banco).
     * 2 - Modo escrita para todos (outras aplicações podem usar o banco). */
    private final int DATABASE_ACESS = 0;

    /* SQL de criação de tabelas. */
    private final String user_col_id = "id", user_col_login = "login", user_col_senha = "senha", user_col_nome = "nome";
    private final String user_col_cpf = "cpf", user_col_curso = "curso", user_col_hasdata = "hasdata", user_col_tentativas_login = "tentativas_login";
    private final String SQL_CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS " + table_name_user + "( " +
            user_col_id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            user_col_login + " TEXT UNIQUE, " +
            user_col_senha + " TEXT, " +
            user_col_nome + " TEXT, " +
            user_col_cpf + " TEXT, " +
            user_col_curso + " TEXT, " +
            user_col_tentativas_login + " TEXT, " +
            user_col_hasdata + " TEXT );";
    //--//
    private final String periodo_col_id = "id", periodo_col_id_user = "id_user", periodo_col_descricao = "descricao", periodo_col_peso = "peso";
    private final String SQL_CREATE_TABLE_PERIODO = "CREATE TABLE IF NOT EXISTS " + table_name_periodo + "( " +
            periodo_col_id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            periodo_col_id_user + " INTEGER," +
            periodo_col_descricao + " TEXT, " +
            periodo_col_peso + " TEXT );";
    //--//
    private final String materia_col_id = "id", materia_col_id_periodo = "id_periodo", materia_col_nome = "nome", materia_col_professor = "professor";
    private final String materia_col_peso = "peso", materia_col_faltas = "faltas", materia_col_atualizacao = "atualizacao";
    private final String materia_col_va1 = "va1", materia_col_va2 = "va2", materia_col_va3 = "va3";
    private final String materia_col_media = "media", materia_col_vafn = "vafn", materia_col_mfin = "mfin";
    private final String materia_col_situacao = "situacao", materia_col_avalnormal = "avalnormal", materia_col_avalfinal = "avalfinal";
    private final String SQL_CREATE_TABLE_MATERIA = "CREATE TABLE IF NOT EXISTS " + table_name_materia + "( " +
            materia_col_id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            materia_col_id_periodo + " INTEGER," +
            materia_col_peso + " TEXT," +
            materia_col_nome + " TEXT, " +
            materia_col_professor + " TEXT, " +
            materia_col_faltas + " TEXT, " +
            materia_col_atualizacao + " TEXT, " +
            materia_col_va1 + " TEXT, " +
            materia_col_va2 + " TEXT, " +
            materia_col_va3 + " TEXT, " +
            materia_col_media + " TEXT, " +
            materia_col_vafn + " TEXT, " +
            materia_col_mfin + " TEXT, " +
            materia_col_situacao + " TEXT, " +
            materia_col_avalnormal + " TEXT, " +
            materia_col_avalfinal + " TEXT );";

    /* Classe com métodos para executar os comandos SQL e manipular o banco de dados. */
    private SQLiteDatabase banco;
    private Context _context;

    public SqliteManager(Context context) {
        this._context = context;
        removerBdVersoesAnteriores();

        this.banco = context.openOrCreateDatabase(DATABASE_NAME, DATABASE_ACESS, null);
        this.banco.execSQL(SQL_CREATE_TABLE_USER);
        this.banco.execSQL(SQL_CREATE_TABLE_PERIODO);
        this.banco.execSQL(SQL_CREATE_TABLE_MATERIA);


    }

    /**
     * NUNCA remover essa chamada. Isso fara com que seja apagado o bd anterior do usuário.
     * Isso pq o usuário pode não ter a versão atual. Quando tiver, o bd anterior sera limpado.
     */
    public void removerBdVersoesAnteriores() {
        final String bd1 = "sigaViewer";
        final String bd2 = "y=03p*48$4Zay;.9Sig@Viewer";
        final String bd3 = "cigE523zKWSig@Viewer";
        final String bd4 = "%?q8~.hIZ5Sig@Viewer";
        final String bd5 = "B>c!1s4:Sig@Viewer";

        if (DATABASE_NAME.equals(bd1)) {
            this._context.deleteDatabase(bd1);
        } else if (DATABASE_NAME.equals(bd2)) {
            this._context.deleteDatabase(bd2);
        } else if (DATABASE_NAME.equals(bd3)) {
            this._context.deleteDatabase(bd3);
        } else if (DATABASE_NAME.equals(bd4)) {
            this._context.deleteDatabase(bd4);
        } else if (DATABASE_NAME.equals(bd5)) {
            this._context.deleteDatabase(bd5);
        }
    }

    public void close() {
        banco.close();
        banco = null;
    }

    /**
     * @param est
     * @return true se inseriu com sucesso, false se não inseriu
     */
    //Log
    public boolean insertUsuario(Estudante est) {
        //Mapa com a coluna e os valores de cada coluna.
        ContentValues values = new ContentValues();
        values.put(this.user_col_login, est.login);
        values.put(this.user_col_senha, est.senha);
        values.put(this.user_col_hasdata, est.hasdata);
        values.put(this.user_col_tentativas_login, 0);

        long retorno;
        try {
            retorno = this.banco.insertOrThrow(this.table_name_user, null, values);
        } catch (Exception e) {
            retorno = 0;
        }

        if (retorno != 0 && retorno != -1) {
            if (Session.DEBUG)
                Log.v(this.getClass().getName(), "insertUsuario(): " + "Login=" + est.login + " | Senha= " + est.senha + " | Id= " + retorno);
            return true;
        } else
            return false;
    }

    public boolean insertPeriodoComMaterias(Estudante est, Periodo per) {
        ContentValues values = new ContentValues();
        values.put(this.periodo_col_id_user, est.id);
        values.put(this.periodo_col_descricao, per.descricao);
        values.put(this.periodo_col_peso, per.peso);

        int retorno;
        try {
            retorno = (int) this.banco.insertOrThrow(this.table_name_periodo, null, values);
        } catch (Exception e) {
            retorno = 0;
        }

        if (retorno != 0 && retorno != -1) {
            per.id = String.valueOf(retorno);

            for (int i = 0; i < per.materias.size(); i++) {
                boolean inseriu = insertMateria(per, per.materias.get(i));
                if (!inseriu)
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }

    //Log
    public boolean insertMateria(Periodo per, Materia mat) {
        //Mapa com a coluna e os valores de cada coluna.
        ContentValues values = new ContentValues();
        values.put(this.materia_col_id_periodo, per.id);
        values.put(this.materia_col_peso, mat.peso);
        values.put(this.materia_col_nome, mat.nome);
        values.put(this.materia_col_professor, mat.professor);
        values.put(this.materia_col_faltas, mat.faltas);
        values.put(this.materia_col_atualizacao, mat.ultimaAtualizacao);
        values.put(this.materia_col_va1, mat.notas.get(0));
        values.put(this.materia_col_va2, mat.notas.get(1));
        values.put(this.materia_col_va3, mat.notas.get(2));
        values.put(this.materia_col_media, mat.notas.get(3));
        values.put(this.materia_col_vafn, mat.notas.get(4));
        values.put(this.materia_col_mfin, mat.notas.get(5));
        values.put(this.materia_col_situacao, mat.situacao);
        values.put(this.materia_col_avalnormal, mat.avaliacao.get(0));
        values.put(this.materia_col_avalfinal, mat.avaliacao.get(1));

        //Executa um insert no banco de dados usando o mapa de valores.
        //Retorna -1 caso ocorra algum erro no INSERT.
        int retorno;
        try {
            retorno = (int) this.banco.insertOrThrow(this.table_name_materia, null, values);
        } catch (Exception e) {
            retorno = 0;
        }

        if (retorno != 0 && retorno != -1) {
            if (Session.DEBUG)
                Log.v(this.getClass().getName(), "insertMateria(): " + "Nome=" + mat.nome + " | Per= " + per.id + " | Id= " + retorno);
            return true;
        } else
            return false;
    }

    public Materia selectMateria(String idPer, String matNome) {
        Cursor cursor = this.banco.query(
                this.table_name_materia, null/*new String[] {}*/, materia_col_id_periodo + "=? AND " + materia_col_nome + "=?", new String[]{idPer, matNome}, null, null, null
        );

        if (cursor.moveToFirst()) {
            Materia mat = new Materia();
            mat.id = String.valueOf(cursor.getInt(cursor.getColumnIndex(this.materia_col_id)));
            mat.id_periodo = String.valueOf(cursor.getInt(cursor.getColumnIndex(this.materia_col_id_periodo)));
            mat.peso = cursor.getString(cursor.getColumnIndex(this.materia_col_peso));
            mat.nome = cursor.getString(cursor.getColumnIndex(this.materia_col_nome));
            mat.professor = cursor.getString(cursor.getColumnIndex(this.materia_col_professor));
            mat.faltas = cursor.getString(cursor.getColumnIndex(this.materia_col_faltas));
            mat.ultimaAtualizacao = cursor.getString(cursor.getColumnIndex(this.materia_col_atualizacao));
            mat.situacao = cursor.getString(cursor.getColumnIndex(this.materia_col_situacao));

            mat.notas.add(cursor.getString(cursor.getColumnIndex(this.materia_col_va1)));
            mat.notas.add(cursor.getString(cursor.getColumnIndex(this.materia_col_va2)));
            mat.notas.add(cursor.getString(cursor.getColumnIndex(this.materia_col_va3)));
            mat.notas.add(cursor.getString(cursor.getColumnIndex(this.materia_col_media)));
            mat.notas.add(cursor.getString(cursor.getColumnIndex(this.materia_col_vafn)));
            mat.notas.add(cursor.getString(cursor.getColumnIndex(this.materia_col_mfin)));

            mat.avaliacao.add(cursor.getString(cursor.getColumnIndex(this.materia_col_avalnormal)));
            mat.avaliacao.add(cursor.getString(cursor.getColumnIndex(this.materia_col_avalfinal)));

            try {
                cursor.close();
            } catch (Exception e) {
            }
            return mat;
        } else {
            try {
                cursor.close();
            } catch (Exception e) {
            }
            return null;
        }
    }

    public ArrayList<Materia> selectAllMateriaByIdPeriodo(String idPer) {
        Cursor cursor = this.banco.query(
                this.table_name_materia, null, materia_col_id_periodo + " = ?", new String[]{idPer}, null, null, null
        );

        if (cursor.moveToFirst()) {
            ArrayList<Materia> materiaArray = new ArrayList<>();
            do {
                Materia mat = new Materia();
                mat.id = String.valueOf(cursor.getInt(cursor.getColumnIndex(this.materia_col_id)));
                mat.id_periodo = String.valueOf(cursor.getInt(cursor.getColumnIndex(this.materia_col_id_periodo)));
                mat.peso = cursor.getString(cursor.getColumnIndex(this.materia_col_peso));
                mat.nome = cursor.getString(cursor.getColumnIndex(this.materia_col_nome));
                mat.professor = cursor.getString(cursor.getColumnIndex(this.materia_col_professor));
                mat.faltas = cursor.getString(cursor.getColumnIndex(this.materia_col_faltas));
                mat.ultimaAtualizacao = cursor.getString(cursor.getColumnIndex(this.materia_col_atualizacao));
                mat.situacao = cursor.getString(cursor.getColumnIndex(this.materia_col_situacao));

                mat.notas.add(cursor.getString(cursor.getColumnIndex(this.materia_col_va1)));
                mat.notas.add(cursor.getString(cursor.getColumnIndex(this.materia_col_va2)));
                mat.notas.add(cursor.getString(cursor.getColumnIndex(this.materia_col_va3)));
                mat.notas.add(cursor.getString(cursor.getColumnIndex(this.materia_col_media)));
                mat.notas.add(cursor.getString(cursor.getColumnIndex(this.materia_col_vafn)));
                mat.notas.add(cursor.getString(cursor.getColumnIndex(this.materia_col_mfin)));

                mat.avaliacao.add(cursor.getString(cursor.getColumnIndex(this.materia_col_avalnormal)));
                mat.avaliacao.add(cursor.getString(cursor.getColumnIndex(this.materia_col_avalfinal)));

                materiaArray.add(mat);

            } while (cursor.moveToNext());

            try {
                cursor.close();
            } catch (Exception e) {
            }
            return materiaArray;
        }
        try {
            cursor.close();
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }

    public Periodo selectPeriodoByName(String idUser, String descPer) {
        Cursor cursor = this.banco.query(
                this.table_name_periodo, null/*new String[] {}*/, periodo_col_id_user + "=? AND " + periodo_col_descricao + "=?", new String[]{idUser, descPer}, null, null, null
        );

        if (cursor.moveToFirst()) {
            Periodo per = new Periodo();
            per.id = String.valueOf(cursor.getInt(cursor.getColumnIndex(this.periodo_col_id)));
            per.id_user = String.valueOf(cursor.getString(cursor.getColumnIndex(this.periodo_col_id_user)));
            per.descricao = cursor.getString(cursor.getColumnIndex(this.periodo_col_descricao));
            per.peso = cursor.getString(cursor.getColumnIndex(this.periodo_col_peso));

            try {
                cursor.close();
            } catch (Exception e) {
            }
            return per;
        } else {
            try {
                cursor.close();
            } catch (Exception e) {
            }
            return null;
        }
    }

    public ArrayList<Periodo> selectAllPeriodoByUserId(String idUser) {
        Cursor cursor = this.banco.query(
                this.table_name_periodo, null, periodo_col_id_user + " = ?", new String[]{idUser}, null, null, null
        );

        if (cursor.moveToFirst()) {
            ArrayList<Periodo> periodosArray = new ArrayList<>();
            do {
                Periodo per = new Periodo();
                per.id = String.valueOf(cursor.getInt(cursor.getColumnIndex(this.periodo_col_id)));
                per.id_user = String.valueOf(cursor.getString(cursor.getColumnIndex(this.periodo_col_id_user)));
                per.descricao = cursor.getString(cursor.getColumnIndex(this.periodo_col_descricao));
                per.peso = cursor.getString(cursor.getColumnIndex(this.periodo_col_peso));
                per.materias = selectAllMateriaByIdPeriodo(per.id);
                periodosArray.add(per);

            } while (cursor.moveToNext());

            try {
                cursor.close();
            } catch (Exception e) {
            }
            return periodosArray;
        }
        try {
            cursor.close();
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }

    //Log
    public Estudante selectUsuario(String login) {
        Cursor cursor = this.banco.query(
                this.table_name_user, null, user_col_login + " = ?", new String[]{login}, null, null, null
        );

        if (cursor.moveToFirst()) {
            Estudante est = new Estudante();
            est.id = String.valueOf(cursor.getInt(cursor.getColumnIndex(this.user_col_id)));
            est.login = cursor.getString(cursor.getColumnIndex(this.user_col_login));
            est.senha = cursor.getString(cursor.getColumnIndex(this.user_col_senha));
            est.nome = cursor.getString(cursor.getColumnIndex(this.user_col_nome));
            est.cpf = cursor.getString(cursor.getColumnIndex(this.user_col_cpf));
            est.curso = cursor.getString(cursor.getColumnIndex(this.user_col_curso));
            est.hasdata = cursor.getString(cursor.getColumnIndex(this.user_col_hasdata));
            if (Session.DEBUG)
                Log.v(this.getClass().getName(),
                        "selectUsuario(): " +
                                "Login=" + est.login +
                                " | Senha= " + est.senha +
                                " | cpf= " + est.cpf +
                                " | Id= " + est.id);
            try {
                cursor.close();
            } catch (Exception e) {
            }
            return est;
        } else {
            try {
                cursor.close();
            } catch (Exception e) {
            }
            return null;
        }
    }

    //Log
    public boolean updateUsuarioInfo(Estudante est) {
        ContentValues values = new ContentValues();
        values.put(this.user_col_nome, est.nome);
        values.put(this.user_col_cpf, est.cpf);
        values.put(this.user_col_curso, est.curso);

        String where = this.user_col_login + " = ?";

        int retorno = this.banco.update(table_name_user, values, where, new String[]{est.login});

        if (retorno != 0 && retorno != -1) {

            if (Session.DEBUG)
                Log.v(this.getClass().getName(),
                        "updateUsuarioInfo(): " +
                                "Login=" + est.login +
                                " | Senha= " + est.senha +
                                " | Nome= " + est.nome +
                                " | cpf= " + est.cpf +
                                " | curso= " + est.curso +
                                " | Id= " + retorno);
            return true;
        } else
            return false;
    }

    //Log
    public boolean updateUsuario(String currentLogin, Estudante est) {
        ContentValues values = new ContentValues();
        values.put(this.user_col_login, est.login);
        values.put(this.user_col_senha, est.senha);

        int retorno = this.banco.update(table_name_user, values, this.user_col_login + " = ?", new String[]{currentLogin});

        if (retorno != 0 && retorno != -1) {
            if (Session.DEBUG)
                Log.v(this.getClass().getName(), "updateUsuario(): " + "Login=" + est.login + " | Senha= " + est.senha + " | Id= " + retorno);
            return true;
        } else
            return false;
    }

    public boolean updateHasData(Estudante est) {
        ContentValues values = new ContentValues();
        values.put(this.user_col_hasdata, est.hasdata);

        String where = this.user_col_login + " = ?";

        int retorno = this.banco.update(table_name_user, values, where, new String[]{est.login});

        if (retorno != 0 && retorno != -1)
            return true;
        else
            return false;
    }

    public boolean updateMateria(Estudante est, Periodo per, Materia mat) {
        String id = String.valueOf(getIdEstudanteByEstudante(est));
        Cursor cursor = this.banco.query(
                this.table_name_periodo, new String[]{this.periodo_col_id},
                this.periodo_col_id_user + " = ? AND " + this.periodo_col_descricao + " = ?", new String[]{id, per.descricao}, null, null, null
        );
        cursor.moveToFirst();
        id = String.valueOf(cursor.getInt(cursor.getColumnIndex(this.periodo_col_id)));

        //Mapa com a coluna e os valores de cada coluna.
        ContentValues values = new ContentValues();
        values.put(this.materia_col_id_periodo, id);
        values.put(this.materia_col_peso, mat.peso);
        values.put(this.materia_col_nome, mat.nome);
        values.put(this.materia_col_professor, mat.professor);
        values.put(this.materia_col_faltas, mat.faltas);
        values.put(this.materia_col_atualizacao, mat.ultimaAtualizacao);
        values.put(this.materia_col_va1, mat.notas.get(0));
        values.put(this.materia_col_va2, mat.notas.get(1));
        values.put(this.materia_col_va3, mat.notas.get(2));
        values.put(this.materia_col_media, mat.notas.get(3));
        values.put(this.materia_col_vafn, mat.notas.get(4));
        values.put(this.materia_col_mfin, mat.notas.get(5));
        values.put(this.materia_col_situacao, mat.situacao);
        values.put(this.materia_col_avalnormal, mat.avaliacao.get(0));
        values.put(this.materia_col_avalfinal, mat.avaliacao.get(1));

        String where = this.materia_col_id_periodo + " = ? AND " + this.materia_col_nome + " = ?";

        int retorno = this.banco.update(table_name_materia, values, where, new String[]{id, mat.nome});

        try {
            cursor.close();
        } catch (Exception e) {
        }

        if (retorno != 0 && retorno != -1)
            return true;
        else
            return false;
    }

    //Log
    public Estudante getEstudanteFilled(String login) {
        Estudante oldEst = selectUsuario(login);
        if (oldEst != null) {
            if (Session.DEBUG)
                Log.v(this.getClass().getName(), "getEstudanteFilled(): " + "Login=" + oldEst.login + " | Senha= " + oldEst.senha + " | Nome= " + oldEst.nome + " | Id= " + oldEst.id);


            oldEst.periodos = selectAllPeriodoByUserId(oldEst.id);
            if (oldEst.periodos != null && oldEst.periodos.size() > 0) {
                oldEst.ordenarPorPesoCrescente();
            }

            return oldEst;
        }
        if (Session.DEBUG)
            Log.v(this.getClass().getName(), "getEstudanteFilled(): retornando NULL");
        return null;
    }

    //Log
    public int getIdEstudanteByEstudante(Estudante est) {
        Cursor cursor = this.banco.query(
                this.table_name_user, new String[]{this.user_col_id}, user_col_login + " = ?", new String[]{est.login}, null, null, null
        );
        cursor.moveToFirst();
        if (Session.DEBUG)
            Log.v(this.getClass().getName(),
                    "getIdEstudanteByEstudante(): " +
                            "Login=" + est.login +
                            " | Senha= " + est.senha +
                            " | Nome= " + est.nome +
                            " | cpf= " + est.cpf +
                            " | curso= " + est.curso +
                            " | Id= " + cursor.getInt(cursor.getColumnIndex(this.user_col_id)));

        int vr = cursor.getInt(cursor.getColumnIndex(this.user_col_id));
        try {
            cursor.close();
        } catch (Exception e) {
        }
        return vr;
    }

    //Log
    public boolean insertEstudanteFirstTime(Estudante est) {
        if (!updateUsuarioInfo(est))
            return false;
        int id = getIdEstudanteByEstudante(est);
        est.id = String.valueOf(id);

        if (Session.DEBUG)
            Log.v(this.getClass().getName(), "insertEstudanteFirstTime(): " + "Login=" + est.login + " | Nome= " + est.nome + " | Id= " + est.id);

        if (!est.id.equals("-1")) {
            for (int i = 0; i < est.periodos.size(); i++) {
                if (!insertPeriodoComMaterias(est, est.periodos.get(i))) {
                    return false;
                }
            }
            if (updateHasData(est)) {
                return true;
            } else {
                return false;
            }


        }
        return false;
    }

    //Log
    public ArrayList<Estudante> selectAllUsuarios() {
        Cursor cursor = this.banco.query(
                this.table_name_user, null, null, null, null, null, null
        );
        if (cursor.moveToFirst()) {
            ArrayList<Estudante> estudantesArray = new ArrayList<>();
            do {
                Estudante est = new Estudante();
                est.id = String.valueOf(cursor.getInt(cursor.getColumnIndex(this.user_col_id)));
                est.login = cursor.getString(cursor.getColumnIndex(this.user_col_login));
                est.senha = cursor.getString(cursor.getColumnIndex(this.user_col_senha));
                est.nome = cursor.getString(cursor.getColumnIndex(this.user_col_nome));
                est.cpf = cursor.getString(cursor.getColumnIndex(this.user_col_cpf));
                est.curso = cursor.getString(cursor.getColumnIndex(this.user_col_curso));
                est.hasdata = cursor.getString(cursor.getColumnIndex(this.user_col_hasdata));

                if (Session.DEBUG)
                    Log.v(this.getClass().getName(),
                            "selectAllUsuarios(): " +
                                    "Nome=" + est.nome +
                                    " | Curso=" + est.curso +
                                    " | Login=" + est.login +
                                    " | Senha= " + est.senha +
                                    " | cpf= " + est.cpf +
                                    " | Id= " + est.id);

                estudantesArray.add(est);

            } while (cursor.moveToNext());

            try {
                cursor.close();
            } catch (Exception e) {
            }
            return estudantesArray;
        } else {
            try {
                cursor.close();
            } catch (Exception e) {
            }
            return null;
        }
    }

    public void dropAllDataUsuario(String login) {
        int id = getIdEstudanteByLogin(login);
        ArrayList<Integer> perId = getIdPeriodosByIdUsuario(id);
        if (perId != null) {
            for (int i = 0; i < perId.size(); i++) {
                removeMateriasByIdPeriodo(perId.get(i));
            }
            removePeriodoByIdUsuario(id);
        }
        removeUsuarioById(id);

    }

    public int getIdEstudanteByLogin(String login) {
        Cursor cursor = this.banco.query(
                this.table_name_user, new String[]{this.user_col_id}, user_col_login + " = ?", new String[]{login}, null, null, null
        );
        cursor.moveToFirst();
        if (Session.DEBUG)
            Log.v(this.getClass().getName(),
                    "getIdEstudanteByLogin(): " +
                            "Id= " + cursor.getInt(cursor.getColumnIndex(this.user_col_id)));
        int vr = cursor.getInt(cursor.getColumnIndex(this.user_col_id));
        try {
            cursor.close();
        } catch (Exception e) {
        }
        return vr;
    }

    public boolean getUserLastAttemptWasFailedByLogin(String login) {
        Cursor cursor = this.banco.query(
                this.table_name_user, null, user_col_login + " = ?", new String[]{login}, null, null, null
        );
        cursor.moveToFirst();
        if (Session.DEBUG)
            Log.v(this.getClass().getName(),
                    "getIdEstudanteByLogin(): " + "login: " + login + " ," +
                            "tentativas was success = " + cursor.getInt(cursor.getColumnIndex(this.user_col_tentativas_login)));
        int bool = cursor.getInt(cursor.getColumnIndex(this.user_col_tentativas_login));
        if (bool == 0)
            return false;
        else
            return true;
    }

    /**
     * key 0 = Last attemp was successfuly (LAST ATTEMP WASN'T FAILED)
     * key 1 = Last attemp was failed (LAST ATTEMP WAS FAILED)
     *
     * @param login
     * @param key
     * @return
     */
    public boolean setUserLastAttemptWasFailedByLogin(String login, int key) {
        ContentValues values = new ContentValues();
        String where = this.user_col_login + " = ?";
        values.put(this.user_col_tentativas_login, key);
        int retorno = this.banco.update(table_name_user, values, where, new String[]{login});

        if (retorno != 0 && retorno != -1)
            return true;
        else
            return false;
    }

    public String getSenhaEstudanteByLogin(String login) {
        Cursor cursor = this.banco.query(
                this.table_name_user, new String[]{this.user_col_senha}, user_col_login + " = ?", new String[]{login}, null, null, null
        );
        cursor.moveToFirst();
        if (Session.DEBUG)
            Log.v(this.getClass().getName(),
                    "getSenhaEstudanteByLogin(): " +
                            "senha= " + cursor.getString(cursor.getColumnIndex(this.user_col_senha)));
        String vr = cursor.getString(cursor.getColumnIndex(this.user_col_senha));
        try {
            cursor.close();
        } catch (Exception e) {
        }
        return vr;
    }

    public ArrayList<Integer> getIdPeriodosByIdUsuario(int id) {
        Cursor cursor = this.banco.query(
                this.table_name_periodo, new String[]{this.periodo_col_id}, periodo_col_id_user + " = ?", new String[]{String.valueOf(id)}, null, null, null
        );

        if (cursor.moveToFirst()) {
            ArrayList<Integer> periodosIdArray = new ArrayList<>();
            do {
                periodosIdArray.add(cursor.getInt(cursor.getColumnIndex(this.periodo_col_id)));

            } while (cursor.moveToNext());

            try {
                cursor.close();
            } catch (Exception e) {
            }
            return periodosIdArray;
        } else {
            try {
                cursor.close();
            } catch (Exception e) {
            }
            return null;
        }

    }

    public void removeMateriasByIdPeriodo(int id) {
        this.banco.delete(table_name_materia, materia_col_id_periodo + " = ?", new String[]{String.valueOf(id)});
    }

    public void removePeriodoByIdUsuario(int id) {
        this.banco.delete(table_name_periodo, periodo_col_id_user + " = ?", new String[]{String.valueOf(id)});
    }

    public void removeUsuarioById(int id) {
        this.banco.delete(table_name_user, user_col_id + " = ?", new String[]{String.valueOf(id)});
    }

    public boolean deleteDataBase() {
        boolean tentativa;
        try {
            tentativa = this._context.deleteDatabase(DATABASE_NAME);
        } catch (Exception e) {
            tentativa = false;
        }
        return tentativa;
    }

    public boolean deleteTablesLessUsers() {
        boolean tentativa;
        try {
            this.banco.execSQL("DROP TABLE IF EXISTS " + table_name_materia);
            this.banco.execSQL("DROP TABLE IF EXISTS " + table_name_periodo);
            tentativa = true;
        } catch (Exception e) {
            tentativa = false;
        }
        return tentativa;
    }
}
