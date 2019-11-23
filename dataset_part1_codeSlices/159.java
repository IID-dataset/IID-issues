Triggering condition: no triggering condition description
Consequence: bad user experiences and lack of further details for inspecion

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected boolean onMarkerClicked(MapView mapView, int markerId, IGeoPoint makerPosition, Object markerData) {
return LocationMapFragment.this.onMarkerClicked(this, markerId, makerPosition, markerData);
protected boolean onMarkerClicked(IconOverlay marker, int markerId, IGeoPoint geoPosition, Object markerData) {
private Bitmap getBitmap(int id) {
final Bitmap thumbnail = MediaStore.Images.Thumbnails.getThumbnail(getActivity().getContentResolver(),id,MediaStore.Images.Thumbnails.MICRO_KIND,new BitmapFactory.Options());//The functional module of image decoding   buggy code
return thumbnail;
this.mImage.setImageBitmap(getBitmap(markerId));//The functional module of image displaying




