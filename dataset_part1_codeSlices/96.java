Triggering condition: handling a lot of images
Consequence: app slow

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
Drawable mImageDrawable = null;
void load(Cursor cursor) {
if (MyPreferences.showAttachedImages()) {
mImageDrawable = AttachedImageDrawable.drawableFromCursor(cursor);//The functional module of image decoding   buggy code
public View getView(int position, View convertView, ViewGroup parent) {
View view = convertView == null ? newView() : convertView;
setIndent(oMsg, view);
private void setIndent(ConversationViewItem oMsg, View messageView) {
float displayDensity = context.getResources().getDisplayMetrics().density;
int indent0 = (int)( 10 * displayDensity);
int indentPixels = indent0 * oMsg.mIndentLevel;
LinearLayout messageIndented = (LinearLayout) messageView.findViewById(R.id.message_indented);
AttachedImageView imageView = (AttachedImageView) messageView.findViewById(R.id.attached_image);
if (oMsg.mImageDrawable != null) {
imageView.setImageDrawable(oMsg.mImageDrawable);//The functional module of image displaying

