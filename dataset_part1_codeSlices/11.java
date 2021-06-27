Triggering condition: handling a large image
Consequence: app crash or abnormal image displaying

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void loadImage(String url, final Callbacks callbacks, int maxWidth) {
if (new File(url).exists()) {
Bitmap bitmap = BitmapFactory.decodeFile(url);//The functional module of image decoding     buggy code
BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
callbacks.onImageLoaded(bitmapDrawable);//The functional module of image displaying

Error description:line 8, lack of necessary functional modules



































































