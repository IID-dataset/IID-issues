Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void saveDocument(ScannedDocument scannedDocument) {
Uri fileUri = ((Uri) intent.getParcelableExtra(MediaStore.EXTRA_OUTPUT));
fileName = fileUri.getPath();
animateDocument(fileName,scannedDocument);
private void animateDocument(String filename, ScannedDocument quadrilateral) {
AnimationRunnable runnable = new AnimationRunnable(filename,quadrilateral);
runOnUiThread(runnable);
public void run() {
final ImageView imageView = (ImageView) findViewById(R.id.scannedAnimation);
Bitmap bitmap = BitmapFactory.decodeFile(fileName);//The functional module of image decoding
int orientation = ExifInterface.ORIENTATION_UNDEFINED;
exif = new ExifInterface(fileName);
orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED);
bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
imageView.setImageBitmap(bitmap);//The functional module of image displaying
//error position         lack of image object releasing

Error description:line 20, inappropriate code implementation  