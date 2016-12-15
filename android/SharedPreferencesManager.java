package com.sigaviewer.database;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by PMateus on 16/09/2015.
 * For project SIG@Viewer.
 * Contact: <paulomatew@gmail.com>
 */
public class SharedPreferencesManager {
    /*
    http://randomkeygen.com/
    TODO trocar keys a cada versão do app
     */
    private final String UNIQ_KEY = "p_I9yQ4L";

    // Shared Preferences
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context _context;

    // Shared pref mode
    public final int PRIVATE_MODE_SHARED_PREF = 0;

    // Shared preferences file name
    public final String PREF_NAME = UNIQ_KEY + "Sig@Viewer";

    /*KEYS para o sharedpreferences*/
    private final String KEY_USE_CACHE = PREF_NAME + "useCache";
    private final String KEY_USERSIGA = PREF_NAME + "sigaUser";
    private final String KEY_PWDSIGA = PREF_NAME + "sigaPwd";
    private final String KEY_SENDNOTIF = PREF_NAME + "sendNotification";
    private final String KEY_CANVIBRATE = PREF_NAME + "canVibrate";
    private final String KEY_NOTIFYSOUND = PREF_NAME + "notifySound";
    private final String KEY_INTERVALOSERVICE = PREF_NAME + "intervaloParaAtualizar";
    private final String KEY_NEXTATUALIZACAO = PREF_NAME + "ultimaAtualizacao";
    private final String KEY_USEREMAIL = PREF_NAME + "userEmail";
    private final String KEY_FIRSTACCESS = PREF_NAME + "primeiroAcesso";
    private final String KEY_FAILEDATTEMPT = PREF_NAME + "tentativaErrada";

    public SharedPreferencesManager(Context context) {
        this._context = context;

        removerBdVersoesAnteriores();

        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE_SHARED_PREF);
        editor = pref.edit();
    }

    /**
     * NUNCA remover essa chamada. Isso fara com que seja apagado o bd anterior do usuário.
     * Isso pq o usuário pode não ter a versão atual. Quando tiver, o bd anterior sera limpado.
     */
    public void removerBdVersoesAnteriores() {
        final String bd1 = "s@ap6j?nu7ra3as&ASuB5*#4PruSig@Viewer";
        final String bd2 = "3as6W32#$!@a*b-AKHSdaSig@Viewer";
        final String bd3 = "@Dt`1k39u)0:B*17a*:J_{Sig@Viewer";
        final String bd4 = "aEc9t4?mVq]28Da;#KIR:A081Sig@Viewer";//ultimo
        final String bd5 = "29ao621HNmSig@Viewer";
        final String bd6 = "6?F3b!3@Sig@Viewer";

        if (PREF_NAME.equals(bd1)) {
            _context.getSharedPreferences(bd1, 0).edit().clear().commit();
        } else if (PREF_NAME.equals(bd2)) {
            _context.getSharedPreferences(bd2, 0).edit().clear().commit();
        } else if (PREF_NAME.equals(bd3)) {
            _context.getSharedPreferences(bd3, 0).edit().clear().commit();
        } else if (PREF_NAME.equals(bd4)) {
            _context.getSharedPreferences(bd4, 0).edit().clear().commit();
        } else if (PREF_NAME.equals(bd5)) {
            _context.getSharedPreferences(bd5, 0).edit().clear().commit();
        }else if (PREF_NAME.equals(bd6)) {
            _context.getSharedPreferences(bd6, 0).edit().clear().commit();
        }

    }

    public void close() {
        editor = null;
        pref = null;
    }

    public boolean getLastAttempWasFailed() {
        return pref.getBoolean(KEY_FAILEDATTEMPT, false);
    }

    public void setLastAttempWasFailed(boolean keyLastAttempWasFailed) {
        editor.putBoolean(KEY_FAILEDATTEMPT, keyLastAttempWasFailed);
        editor.commit();
    }

    public boolean getIsFirstAccess() {
        return pref.getBoolean(KEY_FIRSTACCESS, true);
    }

    public void setIsFirstAccess(boolean keyIsFirstAccess) {
        editor.putBoolean(KEY_FIRSTACCESS, keyIsFirstAccess);
        editor.commit();
    }

    public String getUserEmail() {
        return pref.getString(KEY_USEREMAIL, "");
    }

    public void setUserEmail(String keyUserEmail) {
        editor.putString(KEY_USEREMAIL, keyUserEmail);
        editor.commit();
    }

    public long getNextAtualizacaoTime() {
        return pref.getLong(KEY_NEXTATUALIZACAO, 0);
    }

    public void setNextAtualizacaoTime(long keyLastAtualizacaoTime) {
        editor.putLong(KEY_NEXTATUALIZACAO, keyLastAtualizacaoTime);
        editor.commit();
    }

    public int getIntervaloEntreAtualizacoes() {
        return pref.getInt(KEY_INTERVALOSERVICE, -1);//default 24horas
    }

    /**
     * Faço chamada par ao método setNextAtualizacaoTime() e digo que é ZERO
     *
     * @param keyIntervalo
     */
    public void setIntervaloEntreAtualizacoes(int keyIntervalo) {
        editor.putInt(KEY_INTERVALOSERVICE, keyIntervalo);
        editor.commit();

        setNextAtualizacaoTime(0);
    }

    public boolean getCanUseSoundOnNotify() {
        return pref.getBoolean(KEY_NOTIFYSOUND, true);
    }

    public void setCanUseSoundOnNotify(boolean keyNotifySound) {
        editor.putBoolean(KEY_NOTIFYSOUND, keyNotifySound);
        editor.commit();
    }

    public boolean getIsUsingCache() {
        return pref.getBoolean(KEY_USE_CACHE, true);
    }

    public void setIsUsingCache(boolean keyUsingCache) {
        editor.putBoolean(KEY_USE_CACHE, keyUsingCache);
        editor.commit();
    }

    public boolean getCanSendNotify() {
        return pref.getBoolean(KEY_SENDNOTIF, true);
    }

    public void setCanSendNotify(boolean keyCanSendNotif) {
        editor.putBoolean(KEY_SENDNOTIF, keyCanSendNotif);
        editor.commit();
    }

    public boolean getCanVibrateOnNotify() {
        return pref.getBoolean(KEY_CANVIBRATE, true);
    }

    public void setCanVibrateOnNotif(boolean keyUseCache) {
        editor.putBoolean(KEY_CANVIBRATE, keyUseCache);
        editor.commit();
    }

    public String getUserSiga() {
        return pref.getString(KEY_USERSIGA, "");
    }

    public void setUserSiga(String keyUsersiga) {
        editor.putString(KEY_USERSIGA, keyUsersiga);
        editor.commit();
    }

    public String getPwdSiga() {
        return pref.getString(KEY_PWDSIGA, "");
    }

    public void setPwdSiga(String keyPwdsiga) {
        editor.putString(KEY_PWDSIGA, keyPwdsiga);
        editor.commit();
    }

    public boolean getUserAlreadySetUsernameAndPassword() {
        String a = getUserSiga();
        String b = getPwdSiga();
        return !(a.equals("") || b.equals(""));
    }

}
