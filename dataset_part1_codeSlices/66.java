Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onActivityResult(int requestCode, int resultCode, Intent data) {
if (requestCode == ReportConstants.GALLERY_INTENT && resultCode == Activity.RESULT_OK &&data != null) {
} else if (requestCode == ReportConstants.CAPTURE_PICTURE_INTENT &&
resultCode == Activity.RESULT_OK && data != null) {
Bundle extras = data.getExtras();
Bitmap imageBitmap = (Bitmap) extras.get("data");//The functional module of image decoding     buggy code
mIssueImage.setImageBitmap(imageBitmap);//The functional module of image displaying

Error description:line 11, inappropriate code implementation
