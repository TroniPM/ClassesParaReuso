public class SplashScreenWorker extends AppCompatActivity {
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Session.createLog(this.getClass().getName(), "onCreate()", null);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Session.createLog(this.getClass().getName(), "onResume()", null);

        new SetupDataBaseWorker(this).execute();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Session.createLog(this.getClass().getName(), "onDestroy()", null);
    }

    private class SetupDataBaseWorker extends AsyncTask<Void, Void, Void> {
        private SqliteManager db_sql;
        private SharedPreferencesManager db_sharedPref;
        private Activity context;
		
        public SetupDataBaseWorker(Activity context) {
            Session.createLog(this.getClass().getName(), "CONSTRUCTOR SetupDataBaseWorker()", null);
            this.context = context;
        }
		
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
			Session.createLog(this.getClass().getName(), "onPreExecute()", null);

			pDialog = new ProgressDialog(context);
			pDialog.setMessage("Loading...");
			pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... urls) {
            Session.createLog(this.getClass().getName(), "doInBackground()", null);
            db_sharedPref = new SharedPreferencesManager(this.context);
            db_sql = new SqliteManager(this.context);

			/*do the massive sqlite manipulation*/

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
			
			pDialog.dismiss();
            Session.createLog(this.getClass().getName(), "onPostExecute()", null);

			//Start the new activity after all sqlite(or shared preferences) queries done.
            this.context.startActivity(new Intent(SplashScreen.this, MainActivity.class));
			
			//end this one
            this.context.finish();
        }
    }
}
