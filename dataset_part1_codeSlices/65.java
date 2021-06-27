Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onActivityResult(int requestCode, int resultCode, Intent data) {
if (requestCode == ReportConstants.GALLERY_INTENT && resultCode == Activity.RESULT_OK &&data != null) {
mCapturedImageURI = data.getData();
String[] filePathColumn = {MediaStore.Images.Media.DATA};
Cursor cursor = getActivity().getContentResolver().query(mCapturedImageURI,filePathColumn, null, null, null);
if (cursor == null) return;
cursor.moveToFirst();
int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
String picturePath = cursor.getString(columnIndex);
cursor.close();
mIssueImage.setImageBitmap(BitmapFactory.decodeFile(picturePath));//The functional module of image decoding+displaying      buggy code

Error description:line 16, inappropriate code implementation
