Triggering condition: displaying a lot of images
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onClick(View view) {
String url = urlTextView.getText().toString();
((PostReplyActivity)getActivity()).setImageUri(fullImageUri);
public void setImageUri(Uri uri) {
if (uri != null) {
imageUri = uri;
setImagePreview();
protected void setImagePreview() {
DisplayImageOptions options = (new DisplayImageOptions.Builder()).cacheOnDisc().showStubImage(R.drawable.stub_image_background).resetViewBeforeLoading().fullSizeImageLocation(imageUri.toString()).imageSize(new ImageSize(300, 300)).build();//buggy code
ChanImageLoader.getInstance(this).displayImage(imageUri.toString(), imagePreview, options, previewListener);//The functional module of image resizing+decoding+displaying
