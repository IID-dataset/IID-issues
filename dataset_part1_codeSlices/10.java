Triggering condition: handling a large image
Consequence: app crash or abnormal image displaying

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
final String imageSrc = mImageMeta.getString(ATTR_SRC);
loadThumbnail(imageSrc);
private void loadThumbnail(String imageUrl, NetworkImageView imageView) {
if (imageUrl != null) {
Uri uri = Uri.parse(imageUrl);
String filepath = uri.getLastPathSegment();
if (MediaUtils.isValidImage(filepath)) {
/**
The begin of a functional module: image loading + image rendering
**/
imageView.setImageUrl(imageUrl, mImageLoader);
/**
The end of a functional module: image loading + image rendering
**/

Error description:line 14, inappropriate code implementation











