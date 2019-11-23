Triggering condition: handling a lot of images
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//The statement sequence below will be executed many times
protected void onProgressUpdate(Boolean... values) {
public Bitmap returnDrawable(Context c, String url)
String filename = String.valueOf(url.hashCode());
File f = new File(getCacheDirectory(c), filename);
Bitmap bitmap = null;
bitmap = (Bitmap)imageCache.get(f.getPath());
if(bitmap == null){
bitmap = BitmapFactory.decodeFile(f.getPath());//The functional module of image decoding
if(bitmap != null){
imageCache.put(f.getPath(), bitmap);//The functional module of image memory caching
CoverImageView.setImageDrawable(new BitmapDrawable(imageDownloader.returnDrawable(context, mAr.getImageUrl())));//The functional module of image displaying
//error position     lack of image releasing