Triggering condition: handling a lot of images
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//The statement sequence below will be executed many times
public View getView(int position, View convertView, ViewGroup parent) {
AnimeRecord a = ((AnimeRecord) objects.get(position));
imageManager.download(a.getImageUrl(), cover);
public void download(String url, ImageView imageView) {
String filename = String.valueOf(url.hashCode());
File f = new File(getCacheDirectory(context), filename);
BitmapDownloaderTask task = new BitmapDownloaderTask(imageView);
task.execute(url);
protected Bitmap doInBackground(String... params) {
return downloadBitmap(params[0]);
static Bitmap downloadBitmap(String url) {
final HttpGet getRequest = new HttpGet(url);
HttpResponse response = client.execute(getRequest);
final HttpEntity entity = response.getEntity();
InputStream inputStream = null;
inputStream = entity.getContent(); 
final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);//The functional module of image decoding
return bitmap;
protected void onPostExecute(Bitmap bitmap) {
imageView.setImageBitmap(bitmap);//The functional module of image displaying
String filename = String.valueOf(url.hashCode());
File f = new File(getCacheDirectory(imageView.getContext()), filename); 	
imageCache.put(f.getPath(), bitmap);//The functional module of image memory caching
//error position     lack of image releasing