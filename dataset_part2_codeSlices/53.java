Triggering condition: no triggering condition description
Consequence: bad user experience without further details for inspection

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------

@Override public void onImagePreviewRequested(String mediaUrl) {
/**
The begin of a functional module: image decoding+displaying
**/
ActivityLauncher.openImageEditor(this, mediaUrl);//buggy code
/**
The end of the functional module: image decoding+displaying
**/

Error description:line 11, inappropriate code implementation







