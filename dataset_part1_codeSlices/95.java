Triggering condition: handling a lot of images
Consequence: app slow

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public View getView(int position, View convertView, ViewGroup parent) {
View view = convertView == null ? newView() : convertView;
TimelineViewItem item = getItem(position);
showAttachedImage(item, view);
private void showAttachedImage(TimelineViewItem item, View view) {
ImageView imageView = (ImageView) view.findViewById(R.id.attached_image);
if (item.getAttachedImage() != null) {
  public Drawable getAttachedImage() {
return attachedImageFile == null ? null : attachedImageFile.getDrawable();
public Drawable getDrawable() {
if (downloadFile.exists()) {
String path = downloadFile.getFile().getAbsolutePath();
return MyImageCache.getAttachedImageDrawable(this, path);
public static Drawable getAttachedImageDrawable(Object objTag, String path) {
return attachedImagesCache.getDrawable(objTag, path);
BitmapDrawable getDrawable(Object objTag, String path) {
BitmapDrawable drawable = get(path);
if (drawable != null) {
} else {
misses.incrementAndGet();
/**
The begin of a functional module: image resizing
**/
static BitmapFactory.Options calculateScaling(Object objTag,Point imageSize) {
BitmapFactory.Options options2 = new BitmapFactory.Options();
Point displaySize = getDisplaySize(MyContextHolder.get().context());
while (imageSize.y > (int) (MAX_ATTACHED_IMAGE_PART * displaySize.y) || imageSize.x > displaySize.x) {
options2.inSampleSize = (options2.inSampleSize < 2) ? 2 : options2.inSampleSize * 2;
displaySize.set(displaySize.x * 2, displaySize.y * 2);
return options2
/**
The end of the functional module: image resizing
**/
Bitmap bitmap = BitmapFactory.decodeFile(path, calculateScaling(objTag, getImageSize(path)));//The functional module of image decoding     buggy code      performing image decoding in the UI thread
if (bitmap != null) {
drawable = new BitmapDrawable(MyContextHolder.get().context().getResources(), bitmap);
return drawable;
imageView.setImageDrawable(item.getAttachedImage());//The functional module of image displaying

  
