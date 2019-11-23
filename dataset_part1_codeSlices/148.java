Triggering condition: no triggering condition description
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void onCreate(Bundle savedInstanceState) {
String currencySymbol = null;
String baseCurrencySymbol = null;
Intent intent = getIntent();
if(intent != null) {
currencySymbol = intent.getStringExtra(Currency.CURRENCY_SYMBOL);
baseCurrencySymbol = intent.getStringExtra(BASE_CURRENCY_SYMBOL);
loadCurrencyChart(currencySymbol, baseCurrencySymbol);
private void loadCurrencyChart(String currencySymbol, String baseCurrencySymbol) {
String url = String.format("http://chart.finance.yahoo.com/z?s=%s%s=x&t=5d&z=m",currencySymbol, baseCurrencySymbol);
ImageView imageView = (ImageView) findViewById(R.id.imageChart);
new ImageLoadTask(url, imageView).execute();
protected Bitmap doInBackground(Void... params) {
URL urlConnection = new URL(url);
HttpURLConnection connection = (HttpURLConnection) urlConnection.openConnection();
connection.setDoInput(true);
connection.connect();
InputStream input = connection.getInputStream();
Bitmap myBitmap = BitmapFactory.decodeStream(input);//The functional module of image decoding
return myBitmap;
protected void onPostExecute(Bitmap result) {
imageView.setImageBitmap(result);//The functional module of image displaying


