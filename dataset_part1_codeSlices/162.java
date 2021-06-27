Triggering condition: no triggering condition description
Consequence: bad user experiences and lack of further details for inspecion

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
mTreeView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
return DirectoryPickerFragment.this.onChildDirectoryClick(childPosition, mNavigation.getChild(groupPosition, childPosition));
private boolean onChildDirectoryClick(int childPosition, IDirectory selectedChild) {
updateParentPathBar(selectedChild);
private void updateParentPathBar(IDirectory selectedChild) {
if (mImage != null) {
updateBitmap(selectedChild.getIconID());
private void updateBitmap(int iconID) {
if (mLastIconID != iconID) {
mLastIconID = iconID;
if (mLastIconID == 0) {
} else {
private Bitmap getBitmap(int id) {
final Bitmap thumbnail = MediaStore.Images.Thumbnails.getThumbnail(getActivity().getContentResolver(),id,MediaStore.Images.Thumbnails.MICRO_KIND,new BitmapFactory.Options());//The functional module of image decoding   buggy code
return thumbnail;
this.mImage.setImageBitmap(getBitmap(mLastIconID));//The functional module of image displaying

Error description:line 21, inappropriate code implementation











