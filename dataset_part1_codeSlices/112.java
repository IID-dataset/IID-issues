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
Display display = getWindowManager().getDefaultDisplay();
android.graphics.Point size = new android.graphics.Point();
display.getRealSize(size);
int width = Math.max(size.x, size.y);
int height = Math.min(size.x, size.y);
double imageWidth = imageSize.width;
double imageHeight = imageSize.height;
RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
if (previewPoints != null) {
double documentTopWidth = hipotenuse(previewPoints[0], previewPoints[1]);
public double hipotenuse( Point a , Point b) {
return Math.sqrt( Math.pow(a.x - b.x , 2 ) + Math.pow(a.y - b.y , 2 ));
double documentLeftHeight = hipotenuse(previewPoints[0], previewPoints[3]);
public double hipotenuse( Point a , Point b) {
return Math.sqrt( Math.pow(a.x - b.x , 2 ) + Math.pow(a.y - b.y , 2 ));
double documentRightHeight = hipotenuse(previewPoints[1], previewPoints[2]);
public double hipotenuse( Point a , Point b) {
return Math.sqrt( Math.pow(a.x - b.x , 2 ) + Math.pow(a.y - b.y , 2 ));
double documentBottomWidth = hipotenuse(previewPoints[3], previewPoints[0]);
public double hipotenuse( Point a , Point b) {
return Math.sqrt( Math.pow(a.x - b.x , 2 ) + Math.pow(a.y - b.y , 2 ));
/**
The begin of a functional module: image resizing
**/
double documentWidth = Math.max(documentTopWidth, documentBottomWidth);
double documentHeight = Math.max(documentLeftHeight, documentRightHeight);
double xratio = width / previewSize.width;
double yratio = height / previewSize.height;
params.topMargin = (int) (previewPoints[0].y * yratio);
params.leftMargin = (int) (previewPoints[0].x * xratio);
params.width = (int) (documentWidth * xratio);
params.height = (int) (documentHeight * yratio);
Bitmap scaledBitmap = decodeSampledBitmapFromUri(fileName, params.width, params.height);//The functional module of image decoding
/**
The end of the functional module: image resizing
**/
Matrix matrix = new Matrix();
matrix.postRotate(270);
bitmap = Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.getWidth(),scaledBitmap.getHeight(), matrix, true);//The functional module of image decoding
scaledBitmap.recycle();
imageView.setImageBitmap(bitmap);//The functional module of image displaying
//error position         lack of image object releasing

