Triggering condition: handling a large image
Consequence: abnormal image displaying

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void setupWithStatus(StatusViewData.Concrete status, final StatusActionListener listener, boolean mediaPreviewEnabled) {
List<Attachment> attachments = status.getAttachments();
boolean sensitive = status.isSensitive();
if (mediaPreviewEnabled) {
setMediaPreviews(attachments, sensitive, listener, status.isShowingContent());		
protected void setMediaPreviews(final List<Attachment> attachments, boolean sensitive, final StatusActionListener listener, boolean showingContent) {
Context context = itemView.getContext();
int mediaPreviewUnloadedId =ThemeUtils.getDrawableId(itemView.getContext(), R.attr.media_preview_unloaded_drawable,android.R.color.black);
for (int i = 0; i < n; i++) {
String previewUrl = attachments.get(i).getPreviewUrl();
if (TextUtils.isEmpty(previewUrl)) {
/**
The begin of a functional module: image decoding+displaying
**/
Picasso.with(context).load(mediaPreviewUnloadedId).into(mediaPreviews[i]);//buggy code
/**
The end of the functional module: image decoding+displaying
**/

Error description:line 20, misconfiguration of third-party libraries