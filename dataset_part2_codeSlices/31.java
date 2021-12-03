Triggering condition: display a large image
Consequence: crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
fun onBindViewHolder(holder: QkViewHolder, position: Int) {
val uri = getItem(position)
val view = holder.itemView
/**
The begin of a functional module: image decoding+displaying
**/
view.thumbnail.setImageBitmap(bitmap)
/**
The end of the functional module: image decoding+displaying
**/

public void onStart() {
if (getFile() != null) {
if (mShowResizedImage) {
Bitmap thumbnail = ThumbnailsCacheManager.getBitmapFromDiskCache(String.valueOf(ThumbnailsCacheManager.PREFIX_THUMBNAIL + getFile().getRemoteId()));// buggy code   loading image without resizing
public static Bitmap getBitmapFromDiskCache(String key) {
synchronized (mThumbnailsDiskCacheLock) {
while (mThumbnailCacheStarting) {
mThumbnailsDiskCacheLock.wait();
if (mThumbnailCache != null) {
return mThumbnailCache.getBitmap(key);
if (resizedImage != null && !getFile().isUpdateThumbnailNeeded()) {
mImageView.setImageBitmap(resizedImage);

Error description:line 20, loading images without resizing











