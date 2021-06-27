Triggering condition: handling a large image
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public View instantiateItem(ViewGroup container, int position) {
Cursor cursor = getCursorAt(position);
if (cursor != null) {
long imageID = cursor.getLong(cursor.getColumnIndex(FotoSql.SQL_COL_PK));
Uri uri = getUri(imageID);
PhotoView photoView = new PhotoView(container.getContext());
setImage(position, imageID, uri, photoView);
private void setImage(int position, long imageID, Uri uri, PhotoView photoView) {
photoView.setImageReloadFile(new File(getFullFilePath(position)));
int resolutionKind = MediaStore.Images.Thumbnails.MINI_KIND;
Bitmap thumbnail = null;
final BitmapFactory.Options options = new BitmapFactory.Options();
final ContentResolver contentResolver = photoView.getContext().getContentResolver();
thumbnail = MediaStore.Images.Thumbnails.getThumbnail(contentResolver,imageID,resolutionKind,options);//The functional module of image decoding        buggy code
photoView.setImageBitmap(thumbnail);//The functional module of image displaying

Error description:line 19, inappropriate code implementation