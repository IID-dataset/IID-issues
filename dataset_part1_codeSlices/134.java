Triggering condition: handling a lot of images
Consequence: bad user experiences and lack of further details for inspecion

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//the following statement sequence executed many times
public View getView(int position, View convertView, ViewGroup parent) {
View view = convertView;
ThingInfo item = this.getItem(position);
if (position == 0) {
} else if (isHiddenCommentDescendantPosition(position)) {
                  if (view == null) {
view = mInflater.inflate(R.layout.zero_size_layout, null);
//error position      need to cache the items in a view

Error description:line 13, lack of necessary functional modules