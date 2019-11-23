Triggering condition: handling a lot of images
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//The statement sequence below will be executed many times
private Bitmap mBitmap;   //buggy code    causing image leak
public Object instantiateItem(ViewGroup container, final int position) {
public Bitmap getBitmap() {
FileInputStream fis = context.openFileInput(String.valueOf(number));
mBitmap = BitmapFactory.decodeStream(fis);//The functional module of image decoding
fis.close();
public Bitmap getBitmap() {
return mBitmap;
pvComic.setImageBitmap(sComics[position].getBitmap());//The functional module of image displaying

