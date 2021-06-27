Triggering condition: no triggering condition description
Consequence: bad user experiences and lack of further details for inspecion

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void bindView(View view, Context context, Cursor cursor) {
long imageID = cursor.getLong(cursor.getColumnIndex(FotoSql.SQL_COL_PK));
 holder.icon.setVisibility(((mSelectedItems != null) && (mSelectedItems.contains(imageID))) ? View.VISIBLE : View.GONE);
holder.loadImageInBackground(imageID,imageNotLoadedYet );
public void loadImageInBackground(long imageID, Drawable imageNotLoadedYet) {
if (imageID != this.imageID) {
this.imageID = imageID;
image.setImageDrawable(imageNotLoadedYet);
this.downloader = new DownloadImageTask();
downloader.execute(this);
protected Bitmap doInBackground(GridCellViewHolder... holders) {
Bitmap image = getBitmap(holder.imageID);
private Bitmap getBitmap(Long id) {
final Bitmap thumbnail = MediaStore.Images.Thumbnails.getThumbnail(holder.image.getContext().getContentResolver(),id,MediaStore.Images.Thumbnails.MICRO_KIND,new BitmapFactory.Options());//The functional module of image decoding   buggy code
return thumbnail;
return image;
protected void onPostExecute(Bitmap image) {
if (!isCancelled()) {
this.holder.image.setImageBitmap(image);//The functional module of image displaying

Error description:line 19, inappropriate code implementation