Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//the following statement sequence executed many times
public View getView(int position, View convertView, ViewGroup parent) {
int viewType = getItemViewType(position);
View v = null;
if (viewType == VIEW_TYPE_NAV) {
} else if (viewType == VIEW_TYPE_SECTION_DIVIDER) {
} else {
v = getFeedView(position - getSubscriptionOffset(), convertView, parent);
private View getFeedView(int feedPos, View convertView, ViewGroup parent) {
FeedHolder holder;
Feed feed = itemAccess.getItem(feedPos);
Glide.with(context).load(feed.getImageUri()).placeholder(R.color.light_gray).diskCacheStrategy(DiskCacheStrategy.SOURCE).fitCenter().dontAnimate().into(holder.image);//The functional module of image decoding+resizing+disk-caching+displaying     buggy code


