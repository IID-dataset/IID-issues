Triggering condition: displaying a lot of images
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public Dialog onCreateDialog(Bundle savedInstanceState) {
downloadImage();
protected void downloadImage() {
String url = urlTextView.getText().toString();
fullImageUri = ChanFileStorage.getHiddenLocalImageUri(urlTextView.getContext(), boardCode, threadNo, postExt);
fullImagePath = (new File(URI.create(fullImageUri.toString()))).getAbsolutePath();
DisplayImageOptions options = (new DisplayImageOptions.Builder()).cacheOnDisc().showStubImage(R.drawable.stub_image_background).resetViewBeforeLoading().fullSizeImageLocation(fullImagePath).imageSize(new ImageSize(300, 300)).build();//buggy code    lack of image memory caching
ChanImageLoader.getInstance(urlTextView.getContext()).displayImage(url, webImage, options, imageListener);//The functional module of image resizing+disk-caching+decoding+displaying

Error description:line 12, lack of necessary functional modules