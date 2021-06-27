Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onSwipeRight() {
previousImage();
private void previousImage(){
loadImage();
private void loadImage(){
Bitmap image = BitmapFactory.decodeFile(item.getPath());//The functional module of image decoding       buggy code
mContentView.setImageBitmap(image);//The functional module of image displaying

Error description:line 11, inappropriate code implementation

