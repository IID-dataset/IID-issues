Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void run() {
final ImageView imageView = (ImageView) findViewById(R.id.scannedAnimation);
Bitmap bitmap = BitmapFactory.decodeFile(fileName);//The functional module of image decoding
bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
imageView.setImageBitmap(bitmap);//The functional module of image displaying
//error position         lack of image object releasing