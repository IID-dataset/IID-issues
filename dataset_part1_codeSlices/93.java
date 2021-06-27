Triggering condition: no triggering condition description
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
def onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
val avatarFile = new File(AVATAR.getStorageDir(activity), name)
resizeAvatar(avatarFile) match {
def resizeAvatar(avatar: File): Option[Bitmap] = {
val rawBitmap = BitmapFactory.decodeFile(avatar.getPath)//The functional module of image decoding    buggy code
/**
The begin of a functional module: image resizing
**/
val cropDimension =
if (rawBitmap.getWidth >= rawBitmap.getHeight) {
rawBitmap.getHeight
var bitmap = ThumbnailUtils.extractThumbnail(rawBitmap, cropDimension, cropDimension)
val MAX_DIMENSIONS = 256
val MIN_DIMENSIONS = 16
var currSize = MAX_DIMENSIONS
while (currSize >= MIN_DIMENSIONS && bitmap.getSizeInBytes > Constants.MAX_AVATAR_SIZE) {
bitmap = Bitmap.createScaledBitmap(bitmap, currSize, currSize, false)//The functional module of image decoding
currSize /= 2
case Some(bitmap) =>
FileUtils.writeBitmap(bitmap, Bitmap.CompressFormat.PNG, 0, avatarFile)//The functional module of image disk caching

Error description:line 10, inappropriate code implementation