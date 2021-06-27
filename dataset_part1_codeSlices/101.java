Triggering condition: handling a lot of images
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//The statement sequence below will be executed many times
public View getView(int position, View convertView, ViewGroup parent) {
AnimeRecord a = ((AnimeRecord) objects.get(position));
ImageView cover = (ImageView) v.findViewById(R.id.coverImage);
imageManager.download(a.getImageUrl(), cover);
public void download(String url, ImageView imageView) {
String filename = String.valueOf(url.hashCode());
File f = new File(getCacheDirectory(imageView.getContext()), filename);
Bitmap bitmap = null;
bitmap = (Bitmap)imageCache.get(f.getPath());
if(bitmap == null){
bitmap = BitmapFactory.decodeFile(f.getPath());//The functional module of image decoding
if(bitmap != null){
imageCache.put(f.getPath(), bitmap);//The functional module of image memory caching
imageView.setImageBitmap(bitmap);//The functional module of image displaying
//error position     lack of image releasing

Error description:line 20, inappropriate code implementation  