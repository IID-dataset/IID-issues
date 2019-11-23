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
} else if (isHiddenCommentHeadPosition(position)) {
} else if (isLoadMoreCommentsPosition(position)) {
if (view == null) {
view = mInflater.inflate(R.layout.more_comments_view, null);
//error position      need to cache the items in a view
