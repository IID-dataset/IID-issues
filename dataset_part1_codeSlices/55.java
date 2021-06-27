Triggering condition: no triggering condition description
Consequence: memory bloat

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void onActivityResult(int requestCode, int resultCode,final Intent intent) {
case IMAGE_CHOOSER:
Runnable runnable = new Runnable() {
public void run() {
saveChosenImage(intent.getData());
private void saveChosenImage(Uri selectedImage) {
String instanceFolder1 = Collect.getInstance().getFormController().getInstancePath().getParent();
String destImagePath = instanceFolder1 + File.separator+ System.currentTimeMillis() + ".jpg";
File chosenImage;
chosenImage = MediaUtils.getFileFromUri(this, selectedImage, Images.Media.DATA);
if (chosenImage != null) {
final File newImage = new File(destImagePath);
//lack of image resizing and image caching
runOnUiThread(new Runnable() {
public void run() {
((ODKView) currentView).setBinaryData(newImage);

Error description:line 18, lack of necessary functional modules
                         