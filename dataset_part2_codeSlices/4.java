
Triggering condition: no triggering condition description
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void load(FileItem item, ImageView view) {
/**
The begin of a functional module: image resizing
**/
BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
BitmapFactory.decodeFile(item.getPath(), options);
int sampleSize = 1;
int width = options.outWidth;
int height = options.outHeight;
if (width > GL11.GL_MAX_TEXTURE_SIZE || height > GL11.GL_MAX_TEXTURE_SIZE) {
			sampleSize = 2;
options = new BitmapFactory.Options();
options.inSampleSize = sampleSize;
/**
The end of the functional module: image resizing
**/
Bitmap image = BitmapFactory.decodeFile(item.getPath(), options);//the functional module: image decoding
//Lack of null checking
/**
The begin of the functional module: image resizing
**/
if (image.getWidth() > GL11.GL_MAX_TEXTURE_SIZE || image.getHeight() > GL11.GL_MAX_TEXTURE_SIZE) {
int maxEdge = Math.max(width, height);
image = Bitmap.createScaledBitmap(image, width * GL11.GL_MAX_TEXTURE_SIZE / maxEdge,height * GL11.GL_MAX_TEXTURE_SIZE / maxEdge, false);
/**
The end of the functional module: image resizing
**/
view.setImageBitmap(image);//the functional module: image displaying