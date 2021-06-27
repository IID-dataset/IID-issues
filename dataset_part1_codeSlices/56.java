Triggering condition: no triggering condition description
Consequence: memory bloat

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void onActivityResult(int requestCode, int resultCode, final Intent intent) {
switch (requestCode) {
case IMAGE_CAPTURE:
//lack of image resizing and image caching
File fi = new File(Collect.TMPFILE_PATH);
File nf = new File(s);
if (!fi.renameTo(nf)) {
Timber.e("Failed to rename %s", fi.getAbsolutePath());

Error description:line 9, lack of necessary functional modules
